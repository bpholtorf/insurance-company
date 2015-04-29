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
		  model.addAttribute("id", valuesNext[0]);
		  return "redirect:/insurancePolicy/nextEmployee/{id}";
		  
	  } else if (request.getParameter("submitAdd") != null){
		  employeeService.addEmployee(e);
		  String[] valuesSubmitAdd = request.getParameterValues("submitAdd");
		  model.addAttribute("id", valuesSubmitAdd[0]);
		 return "redirect:/insurancePolicy/viewCoverages/{id}";
	  } else {
		  String[] valuesSubmit = request.getParameterValues("submit");
		  model.addAttribute("id", valuesSubmit[0]);
		  return "redirect:/insurancePolicy/viewCoverages/{id}";
	  }
	  
  }
  
}
