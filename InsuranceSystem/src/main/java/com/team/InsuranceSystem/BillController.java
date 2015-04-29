package com.team.InsuranceSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.insurance.service.BillInfoService;

public class BillController {
	@Autowired
    private BillInfoService bService;
	@RequestMapping("bill/getBill/{ssn}")
	public String findBillBySSN(@PathVariable("ssn") String ssn,Model model)
	{
		model.addAttribute("bills", bService.findBillBySSN(Integer.parseInt(ssn), 0));
		return "chooseBill";
	} 
}
