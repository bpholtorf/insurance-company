package com.team.InsuranceSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javassist.expr.NewArray;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.hamcrest.core.Is;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.insurance.data.Drug;
import com.insurance.data.DrugCoverageDB;
import com.insurance.service.DrugCoverageService;

@Controller
public class DrugController {
  @Autowired
  private DrugCoverageService dService;
  @RequestMapping(value="/drug/view")
  public String getDrugList(Model model)
  {
	  List<DrugCoverageDB> drugList=getAllDrug();
	  List<String> ids=new ArrayList<String>();
	  for (DrugCoverageDB db:dService.findAll()) {
		ids.add(db.getDrugId());
	  }
	  List<Drug> drugs=new ArrayList<Drug>();
	  for (DrugCoverageDB drug:drugList) {
		  if (ids.contains(drug.getDrugId())) {
			  drugs.add(new Drug(drug.getDrugId(), drug.getDrugName(), 1));
		}
		  else
		drugs.add(new Drug(drug.getDrugId(), drug.getDrugName(), 0));
	 }
	  model.addAttribute("list",drugs);
	  return "viewDrug";
  }
  public List<DrugCoverageDB> getAllDrug()
  {
	  String url="http://138.49.101.83/Pharmacy/interface/drugList/all";
	  String jsonString="";
	  try{
		 URL u=new URL(url);
	     BufferedReader reader=new BufferedReader(new InputStreamReader(u.openStream()));
	     StringBuffer buffer=new StringBuffer();
	     char[] buf = new char[1024];
	     int len;
	     while ((len = reader.read(buf)) != -1) {
	    	 buffer.append(buf,0,len);
	     }
	     jsonString=buffer.toString();
	     System.out.println("Drug list:"+jsonString);
	  }
	  catch(IOException e){
		  e.printStackTrace();
	  }
	  JSONArray list=JSONArray.fromObject(jsonString);
	  ArrayList<DrugCoverageDB> drugList=new ArrayList<DrugCoverageDB>();
	  if (list.size()>0) {
		for (int i = 0; i < list.size(); i++) {
			JSONObject drug=list.getJSONObject(i);
			String id=drug.getString("drugId");
			String drugName=drug.getString("drugNameCommercial");
			
			DrugCoverageDB db=new DrugCoverageDB(id,drugName);
			drugList.add(db);
			
		}
		
	  }
	  return drugList;
  }
  @RequestMapping("/drug/addDrug")
  public @ResponseBody String addDrug(@RequestParam("id") String drugId,
		                              @RequestParam("name") String name)
  {
	  dService.save(new DrugCoverageDB(drugId,name));
	  return "add Successfully";
  }
  
  @RequestMapping("/drug/delete")
  public @ResponseBody String deleteDrug(@RequestParam("id") String drugId)
  {
	  dService.delete(drugId);
	  return "delete successfully";
  }
  
	  
  
}
