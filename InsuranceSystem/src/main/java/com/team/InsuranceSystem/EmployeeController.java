package com.team.InsuranceSystem;

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
import com.insurance.service.EmployeeService;

@Controller
public class EmployeeController {
  @Autowired
  private EmployeeService employeeService;
  
 
  @RequestMapping(value="/employee/addEmployee",method=RequestMethod.POST)
  public String addEmployeeId(@Valid EmployeeDB e, BindingResult result, Model model, HttpServletRequest request)
  {
	  if (result.hasErrors()) {
		  String[] valuesNext = request.getParameterValues("next");
		  model.addAttribute("insuranceId", valuesNext[0]);
		  model.addAttribute("birthDate", e.getDateOfBirth());
		  return "addEmployee";
	  }
	  
	  employeeService.addEmployee(e);
	  
	  if(request.getParameter("next") != null){
		  String[] valuesNext = request.getParameterValues("next");
		  model.addAttribute("id", valuesNext[0]);
		  return "redirect:/insurancePolicy/nextEmployee/{id}";
		  
	  } else if (request.getParameter("submit") != null){
		  String[] valuesSubmit = request.getParameterValues("submit");
		  model.addAttribute("id", valuesSubmit[0]);
		 return "redirect:/insurancePolicy/viewCoverages/{id}";
	  }

	   String[] valuesNext = request.getParameterValues("next");
	   model.addAttribute("insuranceId", valuesNext[0]);
	   model.addAttribute("birthDate", e.getDateOfBirth());
	   return "addEmployee";
  }
  
}
