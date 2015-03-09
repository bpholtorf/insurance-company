package com.team.InsuranceSystem;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.insurance.data.CustomerDB;
import com.insurance.service.CustomerService;

@Controller
public class CustomerController {
  @Autowired
  private CustomerService customerService;
  @RequestMapping(value="/customer/add",method=RequestMethod.POST)
  public String addcustomer(@ModelAttribute("customerDB") CustomerDB c)
  {
	 customerService.addCustomer(c); 
     // return "redirect:/customers";
	  return "redirect:/customer/viewAll";
  }
  @RequestMapping(value="/customer/viewAll",method=RequestMethod.GET)
  public String findAll(Model model)
  {
	  
	  model.addAttribute("customers", customerService.findAll());
	 return "viewCustomer";
  }
  @RequestMapping("/customer/delete/{id}")
  public String deleteCustomer(@PathVariable("id") Integer id)
  {
	  customerService.deleteCustomer(id);
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
  public String updateCustomer(@ModelAttribute("customer") CustomerDB customer)
  {
	  this.customerService.updateCustomer(customer);
	  return "redirect:/customer/viewAll";
  }
  @RequestMapping(value="/customer/addcustomerPage",method=RequestMethod.POST)
  public String customerPage()
  {
	  return "addcustomer";
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
         incomeStatuses.put("More than 100000", "More than 100000");    
         return incomeStatuses;
     }
  
}
