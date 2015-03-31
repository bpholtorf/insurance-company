package com.team.InsuranceSystem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.insurance.data.CustomerDB;
import com.insurance.data.CustomerPolicy;
import com.insurance.data.PolicyAdded;
import com.insurance.data.PolicyDB;
import com.insurance.data.PolicyFamilyDB;
import com.insurance.data.PolicyToCustomerDB;
import com.insurance.service.CustomerService;
import com.insurance.service.PolicyFamilyService;
import com.insurance.service.PolicyService;
import com.insurance.service.PolicyToCustomerService;

@Controller
public class PocilyToCustomerController {
	
  private static final String CUSTOMER_ID = "cid";
	
  @Autowired
  private CustomerService customerService;
  @Autowired
  private PolicyService policyService;
  @Autowired
  private PolicyToCustomerService pcService;
  @Autowired
  private PolicyFamilyService pfService;

  @RequestMapping("/customer/addPolicy/{id}")
  public String viewCustomer(@PathVariable("id") Integer id, Model model,HttpSession session)
  {
	  model.addAttribute("customer",customerService.findById(id));
	  model.addAttribute("policys",policyService.getPolicy());
	  session.setAttribute(CUSTOMER_ID, id);
	  return "addPolicyToCustomer";
	  
  }
  
  @RequestMapping(value="/customer/addPolicy/searchPolicy",method = RequestMethod.POST)
  public String searchPolicy(@RequestParam(value = "policyName", required = true) String policyName,
			ModelMap model,HttpSession session){

	  int cid=(Integer.parseInt(session.getAttribute(CUSTOMER_ID).toString()));
	  
	  List<PolicyDB> list=policyService.getPolicyByName(policyName);
	  System.out.println(policyName+"*********"+list.size());
	  List<PolicyAdded> list1=new ArrayList<PolicyAdded>();
	  for(int i=0;i<list.size();i++){
		  int pid=list.get(i).getId();
		  if(pcService.checkAdded(cid, pid)){
			  PolicyAdded p=new PolicyAdded(pid,list.get(i).getPolicyName(),
					  list.get(i).getPolicyNumber(),
					  list.get(i).getPlanType(),
					  list.get(i).getPayPeriod(),
					  list.get(i).getPamount(),
					  list.get(i).getHamount(),
					  list.get(i).getPremiumPercent(), 
					  "added");
			  list1.add(p);
			  System.out.println("*********");
		  }else{
			  PolicyAdded p1=new PolicyAdded(pid,list.get(i).getPolicyName(),
					  list.get(i).getPolicyNumber(),
					  list.get(i).getPlanType(),
					  list.get(i).getPayPeriod(),
					  list.get(i).getPamount(),
					  list.get(i).getHamount(),
					  list.get(i).getPremiumPercent(), 
					  "unadded");
			  list1.add(p1);
			  
		  }
	  }
	  System.out.println(list1.size());
	  model.addAttribute("policys",policyService.getPolicy());
	  model.addAttribute("policyInfo",list1);
	  model.addAttribute("customer",customerService.findById(cid));
	  
	  return "addPolicyToCustomer";
	  
  }
  
  private PolicyToCustomerDB generatePocilyCustomer(int cid,int pid,String policyNumber,double premium,double pamountLeft,double hamountLeft,Date dateFrom,Date dateTo){
	  PolicyToCustomerDB pcDB=new PolicyToCustomerDB();
	  pcDB.setCid(cid);
	  pcDB.setPid(pid);
	  pcDB.setPolicyNumber(policyNumber);
	  pcDB.setPremium(premium);
	  pcDB.setPamountLeft(pamountLeft);
	  pcDB.setHamountLeft(hamountLeft);
	  pcDB.setDateFrom(dateFrom);
	  pcDB.setDateTo(dateTo);
	  return pcDB;
  }
  
 private PolicyFamilyDB generateMember(int cid,int pid,String memberName){
	 PolicyFamilyDB pfDB=new PolicyFamilyDB();
	 pfDB.setCid(cid);
	 pfDB.setPid(pid);
	 pfDB.setMemberName(memberName);
	 return pfDB;
 }
  
  @RequestMapping(value="/customer/addPolicy/viewPolicys",method=RequestMethod.GET)
  public String addPolicyToCustomer(@RequestParam("policyId") String policyId,
		  @RequestParam("name1") String name1,
		  @RequestParam("name2") String name2,
		  @RequestParam("name3") String name3,
		  @RequestParam("name4") String name4,
		  ModelMap model,HttpSession session) throws ParseException{
	  System.out.println(name1+"**"+name2+"**"+name3+"**"+name4);
	  int cid=(Integer.parseInt(session.getAttribute(CUSTOMER_ID).toString()));
	  int pid=Integer.parseInt(policyId);
	  
	  if(!name1.isEmpty()){
		  PolicyFamilyDB mem1=generateMember(cid,pid,name1);
		  pfService.addMember(mem1);
	  }
	  if(!name2.isEmpty()){
		  PolicyFamilyDB mem2=generateMember(cid,pid,name2);
		  pfService.addMember(mem2);
	  }
	  if(!name3.isEmpty()){
		  PolicyFamilyDB mem3=generateMember(cid,pid,name3);
		  pfService.addMember(mem3);
	  }
	  if(!name4.isEmpty()){
		  PolicyFamilyDB mem4=generateMember(cid,pid,name4);
		  pfService.addMember(mem4);
	  }
	  
	  int period=policyService.getPolicyById(pid).getPayPeriod();
	  String policyNum=policyService.getPolicyById(pid).getPolicyNumber();
	  
	  DateFormat dateFormat=new SimpleDateFormat("MM/dd/yyyy");
	  Calendar cal=Calendar.getInstance();
	  String dateFrom=dateFormat.format(cal.getTime());
      String dateTo="";
	  String[] items=dateFrom.split("/");
	  int month=Integer.parseInt(items[0]);
	  int year=Integer.parseInt(items[2]);
	  int mm=month+period;
	  if(mm>12){
		  dateTo=String.valueOf(mm-12)+"/"+items[1]+"/"+String.valueOf(year+1);
	  }else{
		  dateTo=String.valueOf(mm)+"/"+items[1]+"/"+String.valueOf(year);
	  }
	  
	  Date dateFrom1=dateFormat.parse(dateFrom);
	  Date dateTo1=dateFormat.parse(dateTo);
	  
	 
	  String income=customerService.findById(cid).getIncomeStatus();
	  double percent=policyService.getPolicyById(pid).getPremiumPercent();
	  double premium=0;
	  double pAmount=policyService.getPolicyById(pid).getPamount();
	  double hAmount=policyService.getPolicyById(pid).getHamount();
	  if(income.equals("Less than 10000")){
		  premium=percent*10000;
	  }
	  if(income.equals("10000 - 19999")){
		  premium=percent*15000;
	  }
	  if(income.equals("20000 - 29999")){
		  premium=percent*25000;
	  }
	  if(income.equals("30000 - 39999")){
		  premium=percent*35000;
	  }
	  if(income.equals("40000 - 49999")){
		  premium=percent*45000;
	  }
	  if(income.equals("50000 - 59999")){
		  premium=percent*55000;
	  }
	  if(income.equals("60000 - 69999")){
		  premium=percent*65000;
	  }
	  if(income.equals("70000 - 79999")){
		  premium=percent*75000;
	  }
	  if(income.equals("80000 - 89999")){
		  premium=percent*85000;
	  }
	  if(income.equals("90000 - 100000")){
		  premium=percent*95000;
	  }
	  if(income.equals("More than 100000")){
		  premium=percent*100000;
	  }
	  
	  PolicyToCustomerDB pc=generatePocilyCustomer(cid,pid,policyNum,premium,pAmount,hAmount,dateFrom1,dateTo1);
	  pcService.addPolicyToCustomer(pc);
	  model.addAttribute("customer",customerService.findById(cid));
	  model.addAttribute("customerPolicys",pcService.getOneAll(cid));
	  model.addAttribute("cc",cid);
	  return "redirect:/customer/viewPolicys/{cc}";
	 
	  
  }
  
  @RequestMapping("/customer/viewPolicys/{id}")
  public String viewCustomerPolicys(@PathVariable("id") Integer id, Model model,HttpSession session)
  {
	  model.addAttribute("customer",customerService.findById(id));
	  model.addAttribute("customerPolicys",pcService.getOneAll(id));
	  return "viewPolicys";
	  
  }
  @RequestMapping("/customer/viewAllPolicys")
  public String viewAllPolicys(Model model,HttpSession session)
  {

	  List<PolicyToCustomerDB> list=pcService.getAll();
	  List<CustomerPolicy> list1=new ArrayList<CustomerPolicy>();
	  for(int i=0;i<list.size();i++){
		  int cid=list.get(i).getCid();
		  CustomerPolicy p=new CustomerPolicy(cid,list.get(i).getPid(),
				      list.get(i).getPolicyNumber(),
					  list.get(i).getPremium(),
					  list.get(i).getPamountLeft(),
					  list.get(i).getHamountLeft(),
					  list.get(i).getDateFrom(),
					  list.get(i).getDateTo(),
					  customerService.getCustomerById(cid).getFirstName()+" "+customerService.getCustomerById(cid).getLastName(),customerService.getCustomerById(cid).getSSN());
			  list1.add(p);
			  
		  }
	  model.addAttribute("allPolicys",list1);
	  return "viewAllPolicys";
	  
  }
  
  @RequestMapping(value="/customer/searchPolicy",method=RequestMethod.GET)
  public String searchPolicy(@RequestParam("keyword") String keyword,
		                    Model model){
List<CustomerPolicy> result=new ArrayList<CustomerPolicy>();
List<PolicyToCustomerDB> list=pcService.getAll();
	  if (keyword.equals("")) {
		  model.addAttribute("keyword",keyword);
		  
		  for(int i=0;i<list.size();i++){
			  int cid=list.get(i).getCid();
			  CustomerPolicy p=new CustomerPolicy(cid,list.get(i).getPid(),
					      list.get(i).getPolicyNumber(),
						  list.get(i).getPremium(),
						  list.get(i).getPamountLeft(),
						  list.get(i).getHamountLeft(),
						  list.get(i).getDateFrom(),
						  list.get(i).getDateTo(),
						  customerService.getCustomerById(cid).getFirstName()+" "+customerService.getCustomerById(cid).getLastName(),customerService.getCustomerById(cid).getSSN());
				  result.add(p);
				  
			  }
		 
	  }else{
		  
		  for(int i=0;i<list.size();i++){
			  int cid=list.get(i).getCid();
			  if(customerService.getCustomerById(cid).getSSN().equals(keyword)){
			  CustomerPolicy p=new CustomerPolicy(cid,list.get(i).getPid(),
					      list.get(i).getPolicyNumber(),
						  list.get(i).getPremium(),
						  list.get(i).getPamountLeft(),
						  list.get(i).getHamountLeft(),
						  list.get(i).getDateFrom(),
						  list.get(i).getDateTo(),
						  customerService.getCustomerById(cid).getFirstName()+" "+customerService.getCustomerById(cid).getLastName(),customerService.getCustomerById(cid).getSSN());
				  result.add(p);
			  }  
			  }
		  
		  model.addAttribute("keyword",keyword);
	  }
	  model.addAttribute("allPolicys",result);
	  
	  return "viewAllPolicys";
  }
  
  @RequestMapping(value="/customer/viewPolicys/delete",method=RequestMethod.GET)
  public String deletePolicy(@RequestParam("pid") String pid,
		  @RequestParam("cid") String cid,Model model)
  {
	  if(pcService.getOneAll(Integer.parseInt(cid)).size()==1){
		  System.out.println("*********");
		  customerService.deleteCustomer1(Integer.parseInt(cid));
		  pcService.deletePolicyToCustomer(Integer.parseInt(pid), Integer.parseInt(cid));
		  model.addAttribute("customerPolicys",pcService.getOneAll(Integer.parseInt(cid)));
	  }else{
	  pcService.deletePolicyToCustomer(Integer.parseInt(pid), Integer.parseInt(cid));
	  model.addAttribute("customerPolicys",pcService.getOneAll(Integer.parseInt(cid)));
	  model.addAttribute("customer",customerService.findById(Integer.parseInt(cid)));
	  }
	  return "viewPolicys";
  }
 
}

