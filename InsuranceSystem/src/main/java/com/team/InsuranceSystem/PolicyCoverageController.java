package com.team.InsuranceSystem;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.insurance.data.CoverageAdded;
import com.insurance.data.HospitalCoverageDB;
import com.insurance.data.InsurancePolicyDB;
import com.insurance.service.HospitalCoverageService;
import com.insurance.service.InsurancePolicyService;
import com.insurance.service.PolicyCoverageService;

@Controller
public class PolicyCoverageController {

	  private static final String INSURANCE_POLICY_ID = "pid";
	
  @Autowired
  private InsurancePolicyService ipService;
  @Autowired
  private HospitalCoverageService hcService;
  @Autowired
  private PolicyCoverageService pcService;
  

  @RequestMapping(value="/insurancePolicy/viewCoverages/{id}")
  public String viewCoverages(@PathVariable("id") Integer pid, ModelMap model,HttpSession session){

	  session.setAttribute(INSURANCE_POLICY_ID, pid);
	  InsurancePolicyDB insurancePolicy = ipService.getInsurancePolicyById(pid);
	  List<HospitalCoverageDB> hcList=hcService.getAllByPlanType(insurancePolicy.getPlanType());
	  List<CoverageAdded> coverageList=new ArrayList<CoverageAdded>();
	  
	  for(int i=0;i<hcList.size();i++){
		  String status = "unadded";
		  String itemName = hcList.get(i).getItemName();
		  if(pcService.checkAdded(pid, itemName)){
			  status = "added";
		  }
		  CoverageAdded c = new CoverageAdded(
			  hcList.get(i).getId(),
			  hcList.get(i).getItemName(),
			  hcList.get(i).getPolicyType(),
			  hcList.get(i).getDeductible(),
			  hcList.get(i).getOperatorTitle(),
			  status);
		  coverageList.add(c);
	  }
	  model.addAttribute("coverageInfo",coverageList);
	  model.addAttribute("insurancePolicy",ipService.findById(pid));	  
	  
	  return "addCoverageToPolicy";
  }
  
  @RequestMapping("/insurancePolicy/viewCoverages/addCoverage/{itemName}")
  public String addCoverage(@PathVariable("itemName") String itemName, ModelMap model,HttpSession session)
  {
	  int pid = Integer.parseInt(session.getAttribute(INSURANCE_POLICY_ID).toString());
	  pcService.addPolicyCoverage( pid, itemName);
	  model.addAttribute("id", pid);
	  return "redirect:/insurancePolicy/viewCoverages/{id}";
  }
  
  @RequestMapping("/insurancePolicy/viewCoverages/deleteCoverage/{itemName}")
  public String deleteCoverage(@PathVariable("itemName") String itemName, ModelMap model,HttpSession session)
  {
	  Integer pid = Integer.parseInt(session.getAttribute(INSURANCE_POLICY_ID).toString());
	  pcService.deletePolicyCoverage( pid, itemName);
	  model.addAttribute("id", pid);
	  return "redirect:/insurancePolicy/viewCoverages/{id}";
	  
  }

  

}

