package com.team.InsuranceSystem;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.insurance.data.PolicyToCustomerDB;
import com.insurance.service.PolicyToCustomerService;

@Controller
public class ClaimController {
	@Autowired
  private PolicyToCustomerService pc;
	@RequestMapping("/requestAddClaim")
  public String returnPage()
  {
	  return "addClaim";
  }
	@RequestMapping("/claim/searchPolicies/{cid}")
	public String searchPolicies(@PathVariable("cid") Integer cid,
			                     Model model)
	{
		List<PolicyToCustomerDB> policies=pc.getOneAll(cid);
		model.addAttribute("policy", policies);
		return "customerPolicies";
	}
}
