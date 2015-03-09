package com.team.InsuranceSystem;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.insurance.service.SecurityQuestionService;
import com.insurance.service.StaffService;
import com.insurance.service.AnswerService;

import com.insurance.util.Cryption;


@Controller

public class LoginController {
	
   private static final String SESSION_USER = "user";
   private static final String SESSION_ID = "userId";
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	
	@Autowired
	private StaffService staffService;
	@Autowired
	private SecurityQuestionService securityQuestionService;
	@Autowired
	private AnswerService answerService;

	
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public String checkLogin(
			@RequestParam(value = "j_username", required = true) String username,
			@RequestParam(value = "j_password", required = true) String password,
			ModelMap model, HttpSession session) {
       
		String pass=Cryption.encryptToMD5(password);
		//staffService.updatePassword(staffService.getStaffByUsername(username),pass);
		
		String sid = staffService.checkLogin(username, pass);

		if (sid != null) {
			
			session.setAttribute(SESSION_USER, username);
			model.addAttribute("user", username);
			session.setAttribute(SESSION_ID, sid);
			String es=answerService.findSid(Integer.parseInt(sid));
			if(es.equals("YES")){
			 return	"redirect:/answer/init";
			}else{
			return "redirect:/question/viewAll";
			}
			

		} else {
			model.put("error", "true");
			return "login";
		}
	}
	
	@RequestMapping(value = "resetPass", method = RequestMethod.GET)
	public @ResponseBody String reset(
			@RequestParam(value = "ssn", required = true) String ssn,
			ModelMap model) {
		Boolean result=staffService.checkSSN(ssn);
		System.out.print(result);
		return result.toString();
	}
	
	@RequestMapping(value="resetPassword")
	public String re(ModelMap model){
		return "resetPassword";
	}
	
	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public String resetPassword(
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "password1", required = true) String cpassword,
			ModelMap model, HttpSession session) {
		if(password.equals(cpassword)){
			if(staffService.getStaffByUsername(username)!=null){
				String pass=Cryption.encryptToMD5(password);
			staffService.updatePassword(staffService.getStaffByUsername(username),pass);
			
			return "login";
			}else{
				model.put("error1", "true");
				return "resetPassword";
			}
			
			
		}else{
			model.put("error", "true");
			return "resetPassword";
		}
		
	}
	

}
