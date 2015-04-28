package com.team.InsuranceSystem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.insurance.service.CustomerService;

@Controller
public class InterfaceCustomerController {
  @Autowired
  private CustomerService customerService;
  

  @RequestMapping(value="/customer/verify/SSN",method=RequestMethod.GET)
  @ResponseBody
  public String searchCustomer( @RequestParam("ssn") String ssn, Model model)
  {
	  boolean result=customerService.getCustomerSSN(ssn);
	  model.addAttribute("ssn", ssn);
	  model.addAttribute("result", result);
	  return ""+result;
  }
  
}
