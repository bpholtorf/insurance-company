package com.team.InsuranceSystem;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.insurance.data.EmployeeDB;
import com.insurance.data.PolicyToCustomerDB;
import com.insurance.service.CustomerService;
import com.insurance.service.EmployeeService;
import com.insurance.service.PolicyService;
import com.insurance.service.PolicyToCustomerService;

@Controller
public class EmployeeController {
  @Autowired
  private EmployeeService employeeService;
  @Autowired
  private PolicyToCustomerService pcService;
  @Autowired
  private PolicyService policyService;
  @Autowired
  private CustomerService customerService;
 
  @RequestMapping(value="/employee/addEmployee",method=RequestMethod.POST)
  public String addEmployeeId(@Valid EmployeeDB e, BindingResult result, Model model, HttpServletRequest request) throws ParseException
  {
	  
	  if(request.getParameter("submit") !=null){
		  String[] valuesSubmit = request.getParameterValues("submit");
		  model.addAttribute("id", valuesSubmit[0]);
		  return "redirect:/insurancePolicy/viewCoverages/{id}";
	  }
	  
	  if (result.hasErrors()){
		  String[] values;
		  if(request.getParameter("next") != null){
			  values = request.getParameterValues("next");
		  } else if (request.getParameter("submitAdd") != null){

			  values = request.getParameterValues("submitAdd");
			  model.addAttribute("id", values[0]);
		  } else{

			  values = request.getParameterValues("submit");
			  model.addAttribute("id", values[0]);
		  }
		  model.addAttribute("insuranceId", values[0]);
		  model.addAttribute("birthDate", e.getDateOfBirth());
		  return "addEmployee";
	  }
	  
	  
	  
	  if(request.getParameter("next") != null){
		  employeeService.addEmployee(e);
		  
		  String[] valuesNext = request.getParameterValues("next");
		  int pid=Integer.parseInt(valuesNext[0]);
		  int cid=e.getId();
		  
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

		  PolicyToCustomerDB pc=generatePocilyCustomer(cid,pid,policyNum,premium,pAmount,hAmount,dateFrom1,dateTo1);
		  pcService.addPolicyToCustomer(pc);
		  
		  
		  model.addAttribute("id", valuesNext[0]);
		  return "redirect:/insurancePolicy/nextEmployee/{id}";
		  
	  } else if (request.getParameter("submitAdd") != null){
		  employeeService.addEmployee(e);
		  
		  String[] valuesSubmitAdd = request.getParameterValues("submitAdd");
		  int pid=Integer.parseInt(valuesSubmitAdd[0]);
		  int cid=e.getId();
		  
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

		  PolicyToCustomerDB pc=generatePocilyCustomer(cid,pid,policyNum,premium,pAmount,hAmount,dateFrom1,dateTo1);
		  pcService.addPolicyToCustomer(pc);
		  
		 
		  model.addAttribute("id", valuesSubmitAdd[0]);
		 return "redirect:/insurancePolicy/viewCoverages/{id}";
	  } else {
		  String[] valuesSubmit = request.getParameterValues("submit");
		  model.addAttribute("id", valuesSubmit[0]);
		  return "redirect:/insurancePolicy/viewCoverages/{id}";
	  }
	  
  
  
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

}
