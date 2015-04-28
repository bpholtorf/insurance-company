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
public class InterfaceCustomerController {
  @Autowired
  private CustomerService customerService;
  
  
 
  

  @RequestMapping(value="/customer/interface/SSN",method=RequestMethod.GET)
  @ResponseBody
  public String searchCustomer( @RequestParam("SSN") String ssn, Model model)
  {
	  
	  String pattern=ssn;
	  boolean result=customerService.getCustomerSSN(pattern);
	  model.addAttribute("ssn", ssn);
	  model.addAttribute("result", result);
	  return "/customer/interface/SSN/{ssn}/{result}";
  }
  
}
