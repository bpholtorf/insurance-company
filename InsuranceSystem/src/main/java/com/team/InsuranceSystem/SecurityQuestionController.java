package com.team.InsuranceSystem;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.insurance.service.SecurityQuestionService;

@Controller
public class SecurityQuestionController {
  @Autowired
  private SecurityQuestionService securityQuestionService;
  @RequestMapping(value="/question/viewAll",method=RequestMethod.GET)
  public String viewAllQuestion(Model model)
  {
	  model.addAttribute("listQuestions",securityQuestionService.findAll());
	  return "question";
  }
  
  @RequestMapping(value = "/answer/add", method = RequestMethod.POST)
	public String addAnswer(
			@RequestParam(value = "values", required = true) String tempStr,
			ModelMap model, HttpSession session) {
	  
	  String[] namesArr = tempStr.split(",");
     System.out.println(tempStr);
	  return "";
  }
  
}
