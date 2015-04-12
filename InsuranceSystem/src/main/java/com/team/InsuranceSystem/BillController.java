package com.team.InsuranceSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.insurance.service.BillService;

public class BillController {
	@Autowired
    private BillService bService;
	@RequestMapping("bill/getBill/{ssn}")
	public String findBillBySSN(@PathVariable("ssn") String ssn,Model model)
	{
		System.out.println(bService.findPharBillBySSN(Integer.parseInt(ssn), 0));
		model.addAttribute("pharBills", bService.findPharBillBySSN(Integer.parseInt(ssn), 0));
		model.addAttribute("hosBills",bService.findHosBillBySSN(Integer.parseInt(ssn), 0));
		return "chooseBill";
	} 
}
