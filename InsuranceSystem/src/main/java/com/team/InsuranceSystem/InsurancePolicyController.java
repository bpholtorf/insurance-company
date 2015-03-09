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

import com.insurance.data.InsurancePolicyDB;
import com.insurance.service.InsurancePolicyService;

@Controller
public class InsurancePolicyController {
  @Autowired
  private InsurancePolicyService insurancePolicyService;
  @RequestMapping(value="/insurancePolicy/add",method=RequestMethod.POST)
  public String addInsurancePolicy(@ModelAttribute("InsurancePolicyDB") InsurancePolicyDB c)
  {
	 insurancePolicyService.addInsurancePolicy(c); 
     // return "redirect:/InsurancePolicys";
	  return "redirect:/insurancePolicy/viewAll";
  }
  @RequestMapping(value="/insurancePolicy/viewAll",method=RequestMethod.GET)
  public String findAll(Model model)
  {
	  
	  model.addAttribute("insurancePolicys", insurancePolicyService.findAll());
	 return "viewInsurancePolicy";
  }
  @RequestMapping("/insurancePolicy/delete/{id}")
  public String deleteInsurancePolicy(@PathVariable("id") Integer id)
  {
	  insurancePolicyService.deleteInsurancePolicy(id);
	  return "redirect:/insurancePolicy/viewAll";
  }
  @RequestMapping("/insurancePolicy/edit/{id}")
  public String editInsurancePolicy(@PathVariable("id") Integer id, Model model)
  {
	  model.addAttribute("insurancePolicy",insurancePolicyService.findById(id));
	  return "insurancePolicy";
	  
  }

  @RequestMapping("/insurancePolicy/view/{id}")
  public String viewInsurancePolicy(@PathVariable("id") Integer id, Model model)
  {
	  model.addAttribute("insurancePolicy",insurancePolicyService.findById(id));
	  return "InsurancePolicyView";
	  
  }
  @RequestMapping(value="/insurancePolicy/update",method=RequestMethod.POST)
  public String updateInsurancePolicy(@ModelAttribute("insurancePolicy") InsurancePolicyDB insurancePolicy)
  {
	  this.insurancePolicyService.updateInsurancePolicy(insurancePolicy);
	  return "redirect:/insurancePolicy/viewAll";
  }
  @RequestMapping(value="/InsurancePolicy/addInsurancePolicyPage",method=RequestMethod.POST)
  public String InsurancePolicyPage()
  {
	  return "addInsurancePolicy";
  }
  
  @ModelAttribute("planTypes")
  public Map<String,String> populatePlanTypes() {
         Map<String,String> planTypes = new LinkedHashMap<String,String>();
         planTypes.put("Individual", "Individual");
         planTypes.put("Family", "Family"); 
         return planTypes;
     }
  
  @ModelAttribute("payPeriods")
  public Map<Integer,String> populatePayPeriods() {
         Map<Integer,String> payPeriods = new LinkedHashMap<Integer,String>();
         payPeriods.put(6, "6");
         payPeriods.put(12, "12"); 
         return payPeriods;
     }
  
}
