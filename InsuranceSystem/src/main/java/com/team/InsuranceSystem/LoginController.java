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
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String getLoginPage(
//			@RequestParam(value = "error", required = false) boolean error,
//			ModelMap model) {
//		model.put("error", error);
//		return "login";
//	}

	
	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public String checkLogin(
			@RequestParam(value = "j_username", required = true) String username,
			@RequestParam(value = "j_password", required = true) String password,
			ModelMap model, HttpSession session) {

		String sid = staffService.checkLogin(username, password);

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
	

}
