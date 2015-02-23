package com.team.InsuranceSystem;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.insurance.data.StaffDB;
import com.insurance.data.CustomerDB;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		//return "/pages/login.html";
		return "login";
	}
	@RequestMapping(value="/requestAdd",method=RequestMethod.GET)
	public ModelAndView getAddJsp()
	{
		StaffDB company = new StaffDB(); 
		return new ModelAndView("addStaff").addObject(company); 
		
	}
	@RequestMapping(value="/requestAddCustomer",method=RequestMethod.GET)
	public ModelAndView getAddCustomerJsp()
	{
		CustomerDB customer = new CustomerDB(); 
		return new ModelAndView("addCustomer").addObject(customer); 
		
	}
	
	
}
