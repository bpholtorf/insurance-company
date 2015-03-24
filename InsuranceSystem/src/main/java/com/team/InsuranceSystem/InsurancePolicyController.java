package com.team.InsuranceSystem;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.insurance.data.CustomerDB;
import com.insurance.data.InsurancePolicyDB;
import com.insurance.data.StaffDB;
import com.insurance.service.InsurancePolicyService;

@Controller
public class InsurancePolicyController {
  @Autowired
  private InsurancePolicyService insurancePolicyService;
  @RequestMapping(value="/insurancePolicy/add",method=RequestMethod.POST)
  public String addInsurancePolicy(@Valid InsurancePolicyDB i,BindingResult result, Model model )
  {
	  if (result.hasErrors()) {
		return "addInsurancePolicy";
	  }
	  
	 insurancePolicyService.addInsurancePolicy(i);
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
  @RequestMapping(value="/insurancePolicy/update/{id}",method=RequestMethod.POST)
  public String updateInsurancePolicy(@Valid InsurancePolicyDB i,BindingResult result, Model model, @PathVariable("id") Integer id )
  {
	  if (result.hasErrors()) {
		  model.addAttribute("insurancePolicy",insurancePolicyService.findById(id));
		  return "addInsurancePolicy";
	  }
	  
	  this.insurancePolicyService.updateInsurancePolicy(i);
	  return "redirect:/insurancePolicy/viewAll";
  }
  @RequestMapping(value="/insurancePolicy/addInsurancePolicyPage",method=RequestMethod.POST)
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
  

  @RequestMapping(value="/insurancePolicy/searchInsurancePolicy",method=RequestMethod.GET)
  public String searchInsurancePolicy(@RequestParam("type") String type,
		                    @RequestParam("keyword") String keyword,
		                    Model model)
  {
	  List<InsurancePolicyDB> result=new ArrayList<InsurancePolicyDB>();
	  
	  if (keyword.equals("")) {
		  System.out.println("keyword is empty");
		  model.addAttribute("type", type);
		  model.addAttribute("keyword",keyword);
		  result=insurancePolicyService.findAll();
		  System.out.println();
		  model.addAttribute("insurancePolicys",result);
		  return "viewInsurancePolicy";
	  }
			  
	  if (type.equals("Policy Number")) {
		  result=insurancePolicyService.searchByNumber(keyword);
	  }
	  else if(type.equals("Policy Name")){
		  String pattern="%";
	    for (int i = 0; i < keyword.length(); i++) {
			pattern=pattern+keyword.charAt(i)+"%";
			
		}
	    pattern=pattern+"%";
	    result=insurancePolicyService.searchByName(pattern);
	  }
	  
	  model.addAttribute("type", type);
	  model.addAttribute("keyword",keyword);
	  model.addAttribute("insurancePolicys",result);
	  return "viewInsurancePolicy";
  }
  
}
