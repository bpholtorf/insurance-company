package com.team.InsuranceSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.insurance.data.StaffDB;
import com.insurance.service.StaffService;

@Controller
public class StaffController {
  @Autowired
  private StaffService staffService;
  @RequestMapping(value="/staff/add",method=RequestMethod.POST)
  public String addStaff(@ModelAttribute("staffDB") StaffDB s)
  {
	  staffService.addStaff(s); 
     // return "redirect:/staffs";
	  return " redirect:/staff/viewAll";
  }
  @RequestMapping(value="/staff/viewAll",method=RequestMethod.GET)
  public String findAll(Model model)
  {
	  
	  model.addAttribute("staffs", staffService.findAll());
	 return "viewStaff";
  }
  @RequestMapping("/staff/delete/{username}")
  public String deleteStaff(@PathVariable("username") String username)
  {
	  staffService.deleteStaff(username);
	  return "redirect:/staff/viewAll";
  }
  @RequestMapping("/staff/edit/{username}")
  public String editStaff(@PathVariable("username") String username, Model model)
  {
	  model.addAttribute("staff",staffService.findByUsername(username));
	  return "staff";
	  
  }
  @RequestMapping(value="/staff/update",method=RequestMethod.POST)
  public String updateStaff(@ModelAttribute("staff") StaffDB staff)
  {
	  this.staffService.updateStaff(staff);
	  return "redirect:/staff/viewAll";
  }
  @RequestMapping(value="/staff/addStaffPage",method=RequestMethod.POST)
  public String staffPage()
  {
	  return "addStaff";
  }
}
