package com.team.InsuranceSystem;

import java.util.ArrayList;
import java.util.List;

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

import com.insurance.data.StaffDB;
import com.insurance.data.StaffDB2;
import com.insurance.service.StaffService;
import com.insurance.util.Cryption;

@Controller
public class StaffController {
  @Autowired
  private StaffService staffService;
  @RequestMapping(value="/staff/add",method=RequestMethod.POST)
  public String addStaff(@Valid StaffDB s,BindingResult result, Model model )
  {

	  if (result.hasErrors()) {
		  model.addAttribute("birthDate", s.getDateOfBirth());
		return "addStaff";
	}
	  String password=s.getPassword();
	  s.setPassword(Cryption.encryptToMD5(password));
      s.setName(s.getFirstName()+" "+s.getLastName());
	 

	 	  staffService.addStaff(s); 
     // return "redirect:/staffs";
	  return "redirect:/staff/viewAll";
  }
  @RequestMapping(value="/staff/searchStaff",method=RequestMethod.GET)
  public String searchStaff(@RequestParam("type") String type,
		                    @RequestParam("keyword") String keyword,
		                    Model model)
  {
	  List<StaffDB> result=new ArrayList<StaffDB>();
	  
	  
			  
	  if (type.equals("SSN")) {
		  result=staffService.searchBySSN(keyword);
	  }
	  else if(type.equals("Name")){
		  String pattern="%";
	    for (int i = 0; i < keyword.length(); i++) {
			pattern=pattern+keyword.charAt(i)+"%";
			
		}
	    pattern=pattern+"%";
	    result=staffService.searchByName(pattern);
	  }
	  else {
		  String pattern="%";
		    for (int i = 0; i < keyword.length(); i++) {
				pattern=pattern+keyword.charAt(i)+"%";
				
			}
		    pattern=pattern+"%";
		    result=staffService.searchByUsername(pattern);
	  }
	  
	  model.addAttribute("type", type);
	  model.addAttribute("keyword",keyword);
	  model.addAttribute("staffs",result);
	  return "viewStaff";
  }
  @RequestMapping(value="/staff/viewAll",method=RequestMethod.GET)
  public String findAll(Model model)
  {
	  
	  model.addAttribute("staffs", staffService.findAll());
	 return "viewStaff";
  }
  @RequestMapping("/staff/delete/{username:.+}")
  public String deleteStaff(@PathVariable("username") String username)
  {
	  staffService.deleteStaff(username);
	  return "redirect:/staff/viewAll";
  }
  @RequestMapping("/staff/edit/{username:.+}")
  public String editStaff(@PathVariable("username") String username, Model model)
  {
	  
	  model.addAttribute("staff",staffService.findByUsername(username));
	  return "staff";
	  
  }
  @RequestMapping(value="/staff/update",method=RequestMethod.POST)
  public String updateStaff(@ModelAttribute("staff") @Valid StaffDB2 staff,BindingResult result,Model model)
  {
	  if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			model.addAttribute("staff",staff);
			return "staff";
		}
	  else{
	  this.staffService.updateStaff(staff);
	  return "redirect:/staff/viewAll";
	  }
  }
  @RequestMapping(value="/staff/addStaffPage",method=RequestMethod.POST)
  public String staffPage()
  {
	  return "addStaff";
  }
}
