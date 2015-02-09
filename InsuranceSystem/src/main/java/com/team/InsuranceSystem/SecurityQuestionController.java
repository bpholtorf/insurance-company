package com.team.InsuranceSystem;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.insurance.data.AnswerDB;
import com.insurance.service.SecurityQuestionService;
import com.insurance.service.AnswerService;

@Controller
public class SecurityQuestionController {
	
	private static final String SESSION_USER = "user";
	   private static final String SESSION_ID = "userId";
	   
  @Autowired
  private SecurityQuestionService securityQuestionService;
  @Autowired
  private AnswerService answerService;
  @RequestMapping(value="/question/viewAll",method=RequestMethod.GET)
  public String viewAllQuestion(Model model)
  {
	  model.addAttribute("listQuestions",securityQuestionService.findAll());
	  return "question";
  }
  
  private AnswerDB generateAnswer(int qid,int sid,String answer){
	  AnswerDB an=new AnswerDB();
	  an.setQid(qid);
	  an.setSid(sid);
	  an.setAnswer(answer);
	  return an;
  }
  
  @RequestMapping(value = "/question/answer/add", method = RequestMethod.POST)
	public String addAnswer(
			@RequestParam(value = "answers", required = false) String tempStr,
			ModelMap model, HttpSession session) {
	 
	  String userId = (String) session.getAttribute(SESSION_ID);
	 String[] namesArr = tempStr.split(",");
	 for(int i=0;i<namesArr.length;i=i+2){
		 AnswerDB an=generateAnswer(Integer.parseInt(namesArr[i]),Integer.parseInt(userId),namesArr[i+1]);
		 answerService.addAnswer(an);
	 }
	 
     
	  return "login";
  }
  
  
  
}
