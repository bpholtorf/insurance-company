package com.team.InsuranceSystem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.insurance.data.QuestionAnswer;
import com.insurance.service.AnswerService;

@Controller
public class AnswerController {
	
	 private static final String SESSION_ID = "userId";
	 
	@Autowired
	private AnswerService answerService;

	@RequestMapping("answer/init")
	public String getJsp(HttpSession session,
			             ModelMap model)
	{
		String username=session.getAttribute("user").toString();
		model.addAttribute("user", username);
		return "answerQuestion";
	}
	@RequestMapping(value="answer/getQuestion",method = RequestMethod.GET)
	public @ResponseBody QuestionAnswer getQuestion(HttpServletRequest request, 
			                                  HttpServletResponse response,
			                                  HttpSession session) throws Exception
	{
		int sid=(Integer.parseInt(session.getAttribute(SESSION_ID).toString()));
		System.out.println(answerService.findBysid(sid).getQuestion());
		return answerService.findBysid(sid);
	}
}
