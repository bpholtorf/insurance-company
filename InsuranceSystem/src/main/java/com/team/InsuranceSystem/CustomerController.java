package com.team.InsuranceSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.junit.runner.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.insurance.data.CustomerDB;
import com.insurance.data.CustomerDB2;
import com.insurance.data.EmployeeDB;
import com.insurance.data.StaffDB;
import com.insurance.service.CustomerService;
import com.insurance.service.EmployeeService;
import com.insurance.util.Cryption;

@Controller
public class CustomerController {
  @Autowired
  private CustomerService customerService;
  @Autowired
  private EmployeeService employeeService;
  
  
  @RequestMapping(value="/customer/add",method=RequestMethod.POST)
  public String addcustomer(@Valid CustomerDB c,BindingResult result, Model model )
  {
	  if (result.hasErrors()) {
		  model.addAttribute("birthDate", c.getDateOfBirth());
		return "addCustomer";
	  }

	  customerService.addCustomer(c); 
	  return "redirect:/customer/viewAll";
  }
  
  @RequestMapping(value="/customer/viewAll",method=RequestMethod.GET)
  public String findAll(Model model)
  {
	  
	  model.addAttribute("customers", customerService.findAll());
	 return "viewCustomer";
  }
  
  @RequestMapping(value="/customer/{errMessage}",method=RequestMethod.GET)
  public String findAllError(Model model, @PathVariable("errMessage") String error)
  {
	  model.addAttribute("customers", customerService.findAll());
	  model.addAttribute("errMessage", error);
	 return "viewCustomer";
  }
  
  @RequestMapping("/customer/delete/{id}")
  public String deleteCustomer(@PathVariable("id") Integer id, ModelMap model)
  {
	  if(!customerService.deleteCustomer(id)){
		  model.addAttribute("errMessage","ViewAll-Error");
		  return "redirect:/customer/{errMessage}"; 
	  }
	  return "redirect:/customer/viewAll";
  }
  @RequestMapping("/customer/edit/{id}")
  public String editCustomer(@PathVariable("id") Integer id, Model model)
  {
	  model.addAttribute("customer",customerService.findById(id));
	  return "customer";
	  
  }

  @RequestMapping("/customer/view/{id}")
  public String viewCustomer(@PathVariable("id") Integer id, Model model)
  {
	  model.addAttribute("customer",customerService.findById(id));
	  return "customerView";
	  
  }
  @RequestMapping(value="/customer/update",method=RequestMethod.POST)
  public String updateCustomer(@Valid CustomerDB2 customer,BindingResult result, Model model )
  {
	  if (result.hasErrors()) {
		  System.out.println(result.getAllErrors());
		  model.addAttribute("customer",customer);
		  return "customer";
	  }
  
	  this.customerService.updateCustomer(customer);
	  return "redirect:/customer/viewAll";
  }
  

  @RequestMapping(value="/customer/searchCustomer",method=RequestMethod.GET)
  public String searchCustomer(@RequestParam("type") String type,
		                    @RequestParam("keyword") String keyword,
		                    Model model) throws ParseException 
  {
	  List<CustomerDB> result=new ArrayList<CustomerDB>();
	  
	  if (keyword.equals("")) {
		  if (type.equals("Date of Birth") ) {
			  model.addAttribute("type", type);  
			  model.addAttribute("keyword",keyword);
			  System.out.println("**************");
				Date date=new Date();
			  model.addAttribute("keyword1",date);
			  result=customerService.findAll();
			  model.addAttribute("customers",result);
			  return "viewCustomer";
		  }else{
		  System.out.println("keyword is empty");
		  model.addAttribute("type", type);  
		  model.addAttribute("keyword",keyword);
		  model.addAttribute("keyword1",keyword);
		  result=customerService.findAll();
		  model.addAttribute("customers",result);
		  return "viewCustomer";
		  }
	  }else{

			  
	  if (type.equals("SSN")) {
		  String pattern="%"+keyword+"%";
		  result=customerService.searchBySSN(pattern);
		  model.addAttribute("keyword",keyword);
	  }else if (type.equals("Date of Birth")) {
		  SimpleDateFormat dt=new SimpleDateFormat("MM/dd/yyyy");
		  SimpleDateFormat dt1=new SimpleDateFormat("yyyy-MM-dd");
			Date date=dt.parse(keyword);
			String date1=dt1.format(date);	
		 
		  result=customerService.searchByDateofBirth(date1);
		  
		  System.out.println(date1+"*****"+result.size());
		  model.addAttribute("keyword1",date);
	  }
	  else if(type.equals("Name")){
		  String pattern="%";
	    for (int i = 0; i < keyword.length(); i++) {
			pattern=pattern+keyword.charAt(i)+"%";
			
		}
	    pattern=pattern+"%";
	    result=customerService.searchByName(pattern);
	    model.addAttribute("keyword",keyword);
	  }
	  }
	  model.addAttribute("type", type);  
	  model.addAttribute("customers",result);
	  return "viewCustomer";
  }
  
  @ModelAttribute("incomeStatuses")
  public Map<String,String> populateIncomeStatuses() {
         Map<String,String> incomeStatuses = new LinkedHashMap<String,String>();
         incomeStatuses.put("Less than 10000", "Less than 10000");
         incomeStatuses.put("10000 - 19999", "10000 - 19999");
         incomeStatuses.put("20000 - 29999", "20000 - 29999");
         incomeStatuses.put("30000 - 39999", "30000 - 39999");
         incomeStatuses.put("40000 - 49999", "40000 - 49999"); 
         incomeStatuses.put("50000 - 59999", "50000 - 59999");
         incomeStatuses.put("60000 - 69999", "60000 - 69999");
         incomeStatuses.put("70000 - 79999", "70000 - 79999");
         incomeStatuses.put("80000 - 89999", "80000 - 89999"); 
         incomeStatuses.put("90000 - 99999", "90000 - 99999");  
         incomeStatuses.put("100000 or More", "100000 or More");    
         return incomeStatuses;
     }
  
  @RequestMapping("/customer/findById")
  public @ResponseBody CustomerDB findCustomerById(HttpServletRequest request,
		                                           HttpServletResponse response)
  {
	 
	  Integer cid=Integer.parseInt(request.getParameter("cid"));
	  CustomerDB cDB=new CustomerDB();
	  cDB=customerService.findById(cid);
	  
	  return cDB;
  }
  @RequestMapping("/customer/findBySSN")
  public @ResponseBody CustomerDB findCustomerBySSN(HttpServletRequest request,
		                                           HttpServletResponse response)
  {
	 
	  String ssn=request.getParameter("ssn");
	  CustomerDB cDB=new CustomerDB();
	  System.out.println("customerController"+ssn);
	  List<CustomerDB> cDBs=customerService.searchBySSN(ssn);
	  if(cDBs.size()!=0)
	  {
		  cDB=customerService.searchBySSN(ssn).get(0);	  	  
	  }
	  
	  return cDB;
  }
}
