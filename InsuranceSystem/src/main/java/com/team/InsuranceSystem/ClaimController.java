package com.team.InsuranceSystem;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.insurance.dao.PolicyFamilyDao;
import com.insurance.data.BillHeaderDB;
import com.insurance.data.CustomerDB;
import com.insurance.data.HosBillDB;
import com.insurance.data.HosBillInfoDB;
import com.insurance.data.PharBillDB;
import com.insurance.data.BillInfoDB;
import com.insurance.data.PolicyDB;
import com.insurance.data.PolicyFamilyDB;
import com.insurance.data.PolicyToCustomerDB;
import com.insurance.service.BillInfoService;
import com.insurance.service.BillService;
import com.insurance.service.DrugCoverageService;
import com.insurance.service.CustomerService;
import com.insurance.service.HosCoverageService;
import com.insurance.service.PolicyFamilyService;
import com.insurance.service.PolicyService;
import com.insurance.service.PolicyToCustomerService;

@Controller
public class ClaimController {
	@Autowired
	private PolicyToCustomerService pc;
	@Autowired
	private CustomerService cService;
	@Autowired
	private BillService bService;
	@Autowired
	private BillInfoService infoService;
	@Autowired
	private DrugCoverageService covService;
	@Autowired
	private HosCoverageService hosCovService;
	@Autowired
	private PolicyService pService;
	@Autowired
	private PolicyFamilyService pfService;

	@RequestMapping("/requestAddClaim")
	public String returnPage() {
		return "addClaim";
	}

	@RequestMapping("/claim/getPolicyByPid")
	public @ResponseBody String getPlanType(@RequestParam("pid") int pid) {
		return pService.getPolicyById(pid).getPlanType();
	}

	@RequestMapping("/claim/getFamily")
	public @ResponseBody List<String> getFamily(@RequestParam("pid") int pid,
			@RequestParam("cid") int cid) {
		List<String> familyList = new ArrayList<String>();
		List<PolicyFamilyDB> family = pfService.getMembersForOne(cid, pid);
		for (int i = 0; i < family.size(); i++) {
			familyList.add(family.get(i).getMemberName());
		}
		CustomerDB c = cService.getCustomerById(cid);
		familyList.add(c.getFirstName() + " " + c.getLastName());
		return familyList;

	}

	@RequestMapping("/claim/searchPolicies/{ssn}")
	public String searchPolicies(@PathVariable("ssn") Integer ssn, Model model,
			HttpSession session) {
		Integer cid = cService.searchBySSN(ssn.toString()).get(0).getId();
		CustomerDB c = cService.findById(cid);
		session.setAttribute("cid", cid);
		List<PolicyToCustomerDB> policies = pc.getOneAll(cid);
		model.addAttribute("policy", policies);
		model.addAttribute("cid", cid);
		model.addAttribute("ssn", ssn);
		model.addAttribute("c", c);
		return "customerPolicies";
	}

	@RequestMapping("/claim/searchClaim")
	public String searchBySSN(@RequestParam("keyword") String ssn, Model model) {
		model.addAttribute("pharClaims", bService.searchPharBillBySSN(ssn, 1));
		model.addAttribute("hosClaims", bService.searchHosBillBySSN(ssn, 1));
		model.addAttribute("keyword", ssn);
		return "viewClaim";
	}

	@RequestMapping("/claim/viewAll")
	public String viewAllClaim(Model model) {
		model.addAttribute("pharClaims", bService.findAllPharBills());
		model.addAttribute("hosClaims", bService.findAllHosBills());
		return "viewClaim";
	}

	@RequestMapping(value = "/claim/view/{billNumber}", method = RequestMethod.POST)
	public String ViewClaim(@PathVariable("billNumber") String billNumber,
			Model model) {
		BillHeaderDB billHeader = bService.findBillDB(billNumber);
		String billType = billHeader.getBillType();
		String ssn = billHeader.getSsn();
		if (cService.searchBySSN(ssn).size()==0) {
		  int cid=pfService.getBySSN(ssn).getCid();
		  model.addAttribute("cus", cService.findById(cid));
		  model.addAttribute("patientName",pfService.getBySSN(ssn).getMemberName());
		}
		else {
			
		
		CustomerDB c = cService.searchBySSN(ssn).get(0);
		model.addAttribute("cus", c);
		model.addAttribute("patientName",c.getFirstName()+" "+c.getLastName());
		}
		if (billType.equals(BillType.pharmacy.toString())) {
			model.addAttribute("bill", bService.findBillByBillNum(billNumber));
			System.out.println(bService.findBillByBillNum(billNumber)
					.getTotalCoverage());
			return "claim";
		} else {
			model.addAttribute("bill", bService.getHosBill(billNumber));
			return "hosClaim";
		}
	}

	@RequestMapping("/claim/addClaim")
	public String addClaim(HttpServletRequest request, Model model,
			HttpSession session) {
		int cid = Integer.parseInt(request.getParameter("cid"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		CustomerDB insured = cService.findById(cid);
		session.setAttribute("pid", pid);
		String ssn = "";
		String memberName = request.getParameter("memberName");
		String planType = pService.getPolicyById(pid).getPlanType();

		session.setAttribute("memberName", memberName);
		if (planType.equalsIgnoreCase("family")) {
			if (memberName.equalsIgnoreCase(insured.getFirstName() + " "
					+ insured.getLastName())) {
				ssn = insured.getSSN();
			} else {
				ssn = pfService.getMemberSSN(memberName, cid, pid);
			}

		} else {
			ssn = insured.getSSN();
		}
		model.addAttribute("pharBills", bService.findPharBillBySSN(ssn, 0));
		model.addAttribute("hosBills", bService.findHosBillBySSN(ssn, 0));
		model.addAttribute("memberName", memberName);
		model.addAttribute("cid", cid);
		model.addAttribute("pid", pid);

		return "chooseBill";
	}

	@RequestMapping("/claim/generateClaim")
	public String generateClaimResult(@RequestParam("bNumber") String bNumber,
			@RequestParam("cid") int cid, @RequestParam("pid") int pid,
			Model model, HttpSession session) {
		model.addAttribute("cus", cService.getCustomerById(cid));
		model.addAttribute("policy", pService.getPolicyById(pid));
		model.addAttribute("memberName", session.getAttribute("memberName"));

		BillHeaderDB billDB = bService.findBillDB(bNumber);

		if (billDB.getBillType().equals(BillType.pharmacy.toString())) {
			model.addAttribute("bill", pharClaim(billDB, bNumber, cid, pid));
			PolicyToCustomerDB db2 = pc.getById(pid, cid);
			model.addAttribute("cusPo", db2);
			PharBillDB pharBillDB = pharClaim(billDB, bNumber, cid, pid);
			Date dateObject = pharBillDB.getDate();
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			String dateString = df.format(dateObject);
			JSONObject jsonObject = JSONObject.fromObject(pharBillDB);
			jsonObject.remove("date");
			jsonObject.put("date", dateString);
			String jsonStr = jsonObject.toString();
			model.addAttribute("dataJson", jsonStr);
			System.out.println(jsonStr);
			return "claimReport";

		}

		else {
			model.addAttribute("bill", hosClaim(billDB, bNumber, cid, pid));
			PolicyToCustomerDB db2 = pc.getById(pid, cid);
			model.addAttribute("cusPo", db2);
			return "hosClaimReport";
		}

	}

	private HosBillDB hosClaim(BillHeaderDB billDB, String bNumber, int cid,
			int pid) {
		HosBillDB db = bService.getHosBill(bNumber);
		PolicyToCustomerDB db2 = pc.getById(pid, cid);
		List<HosBillInfoDB> infoDBs = db.getInfoDBs();
        PolicyDB policyDB=pService.getPolicyById(pid);
        String planType=policyDB.getPlanType();
		double hamountLeft = db2.getHamountLeft();
		double totalCoverage = 0;
		for (int i = 0; i < infoDBs.size(); i++) {
			HosBillInfoDB hDb = infoDBs.get(i);

			if (!hosCovService.isCovered(pid, hDb.getItemName())) {
				infoDBs.get(i).setCoverage(0);
				hDb.setCovered(false);
				infoDBs.get(i).setCovered(false);
			} else {
				double duc = hosCovService.getDuc(
						planType, hDb.getItemName(),
						hDb.getOperatorTitle());
				double itemCoverAmount = 0;
				hDb.setCovered(true);
				infoDBs.get(i).setCovered(true);
				if (hamountLeft > 0) {
					if (hDb.getPrice() >= hamountLeft) {
						if (hamountLeft <= duc) {
							itemCoverAmount = hamountLeft;
						} else {
							itemCoverAmount = duc;
						}
					} else {
						if (hDb.getPrice() <= duc) {
							itemCoverAmount = hDb.getPrice();
						} else {
							itemCoverAmount = duc;
						}
					}

				}
				infoDBs.get(i).setCoverage(itemCoverAmount);
				hDb.setCoverage(itemCoverAmount);

			}
			hamountLeft = hamountLeft - infoDBs.get(i).getCoverage();
			totalCoverage += infoDBs.get(i).getCoverage();
			infoService.updateHosBillInfo(hDb);

		}

		db2.setHamountLeft(hamountLeft);
		pc.updateAmountLeft(db2);
		billDB.setTotalCoverage(totalCoverage);
		billDB.setCustomerPay(billDB.getTotalCharge() - totalCoverage);
		billDB.setClaimNumber(System.currentTimeMillis() + "");
		billDB.setStatus(1);
		bService.update(billDB);
		db.setTotalCoverage(totalCoverage);
		db.setCustomerPay(db.getTotalCharge() - totalCoverage);
		db.setInfoDBs(infoDBs);

		return db;
	}

	private PharBillDB pharClaim(BillHeaderDB billDB, String bNumber, int cid,
			int pid) {
		PharBillDB db2 = bService.findBillByBillNum(bNumber);
		PolicyToCustomerDB db = pc.getById(pid, cid);

		List<BillInfoDB> infoDBs = db2.getInfoDBs();

		double pamountLeft = db.getPamountLeft();
		double totalCoverAmount = 0;

		for (int i = 0; i < infoDBs.size(); i++) {
			BillInfoDB bInfoDB = infoDBs.get(i);
			if (!covService.isCovered(bInfoDB.getDrugId())) {
				infoDBs.get(i).setCovered(false);
				bInfoDB.setCovered(false);
			}

			// if the drug can be covered
			else {
				infoDBs.get(i).setCovered(true);
				bInfoDB.setCovered(true);
				if (pamountLeft > 0) {
					double coverAmount = 0;
					if (bInfoDB.getTotalCharge() >= pamountLeft)
						coverAmount = pamountLeft;
					else
						coverAmount = bInfoDB.getTotalCharge();

					totalCoverAmount += coverAmount;
					infoDBs.get(i).setCoverage(coverAmount);
					bInfoDB.setCoverage(coverAmount);
					pamountLeft = pamountLeft - coverAmount;
				}
			}
			infoService.update(bInfoDB);
		}
		db.setPamountLeft(pamountLeft);

		pc.updateAmountLeft(db);

		db2.setInfoDBs(infoDBs);
		db2.setTotalCoverage(totalCoverAmount);
		db2.setCustomerPay(db2.getTotalCharge() - totalCoverAmount);
		billDB.setCustomerPay(db2.getCustomerPay());

		db2.setClaimNumber(System.currentTimeMillis() + "");
		billDB.setClaimNumber(System.currentTimeMillis() + "");
		billDB.setStatus(1);
		billDB.setTotalCoverage(totalCoverAmount);
		bService.update(billDB);

		return db2;

	}

	public enum PolicyType {
		Family, Individual, EmployeeSponsoredFamily, EmployeeSponsoredIndividual
	}

	public enum BillType {
		hospital, pharmacy
	}

}
