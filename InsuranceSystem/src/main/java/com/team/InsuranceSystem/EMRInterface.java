package com.team.InsuranceSystem;


import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.insurance.data.DiagnosticDB;
import com.insurance.data.HosCoverageDB;
import com.insurance.data.HospitalCoverageDB;
import com.insurance.data.SurgeryDB;
import com.insurance.data.TreatmentDB;
import com.insurance.service.DiagnosticService;
import com.insurance.service.HosCoverageService;
import com.insurance.service.PolicyCoverageService;
import com.insurance.service.SurgeryService;
import com.insurance.service.TreatmentService;

@Controller
public class EMRInterface {
	@Autowired
	private SurgeryService surgeryService;
	@Autowired
	private DiagnosticService diagnosticService;
	@Autowired
	private TreatmentService treatmentService;
	@Autowired
	private HosCoverageService hosCoverageService;
	@Autowired
	private PolicyCoverageService pcService;
	
	@RequestMapping(value = "/syn", method = RequestMethod.POST)
	public @ResponseBody String postTest(
			@RequestBody JSONObject receivedPost) {
		
		String actionName=(String) receivedPost.get("action");
		LinkedHashMap obj= (LinkedHashMap) receivedPost.get("object");
		
		
		String tableName=(String) receivedPost.get("table");
		System.out.println(receivedPost.toString());
		if(tableName.equals("diagnostic_test")){
			
				String id=(String)obj.get("diagnostic_test_id");
				String nameBefore=diagnosticService.findDiagnostic(Integer.parseInt(id));
				String name=(String)obj.get("diagnostic_test_name");
				String cost=(String)obj.get("cost");
				DiagnosticDB diagnostic=generateDiagnostic(name,Double.parseDouble(cost));
				if(actionName.equals("add")){
					diagnosticService.addDiagnostic(diagnostic);
					HosCoverageDB hs1=generateHospitalCoverage(name,"Individual",200,"NULL");
					HosCoverageDB hs2=generateHospitalCoverage(name,"Family",400,"NULL");
					HosCoverageDB hs3=generateHospitalCoverage(name,"Employee-sponsored-individual",200,"NULL");
					HosCoverageDB hs4=generateHospitalCoverage(name,"Employee-sponsored-family",200,"NULL");
					hosCoverageService.addHosCoverage(hs1);
					hosCoverageService.addHosCoverage(hs2);
					hosCoverageService.addHosCoverage(hs3);
					hosCoverageService.addHosCoverage(hs4);
				}
				if(actionName.equals("update")){
					diagnosticService.updateDiagnostic(diagnostic);
					if(!name.equals(nameBefore)){
					HosCoverageDB hs1=generateHospitalCoverage(nameBefore,"Individual",200,"NULL");
					HosCoverageDB hs2=generateHospitalCoverage(nameBefore,"Family",400,"NULL");
					HosCoverageDB hs3=generateHospitalCoverage(nameBefore,"Employee-sponsored-individual",200,"NULL");
					HosCoverageDB hs4=generateHospitalCoverage(nameBefore,"Employee-sponsored-family",200,"NULL");
					hosCoverageService.updateHosCoverage(hs1,name);
					hosCoverageService.updateHosCoverage(hs2,name);
					hosCoverageService.updateHosCoverage(hs3,name);
					hosCoverageService.updateHosCoverage(hs4,name);
					}
				}
				if(actionName.equals("delete")){
					diagnosticService.deleteDiagnostic(Integer.parseInt(id));
					hosCoverageService.deleteHosCoverage(name);
					pcService.deleteCoverage(name);
				}
			
		}
		
		if(tableName.equals("surgery")){
			
				String id=(String)obj.get("surgery_id");
				String name=(String)obj.get("surgery_name");
				String nameBefore=surgeryService.findSurgery(Integer.parseInt(id));
				String cost=(String)obj.get("cost");
				System.out.println(cost);
				SurgeryDB surgery=generateSurgery(name,Double.parseDouble(cost));
				if(actionName.equals("add")){
					surgeryService.addSurgery(surgery);
					HosCoverageDB hs1=generateHospitalCoverage(name,"Individual",200,"NULL");
					HosCoverageDB hs2=generateHospitalCoverage(name,"Family",400,"NULL");
					HosCoverageDB hs3=generateHospitalCoverage(name,"Employee-sponsored-individual",200,"NULL");
					HosCoverageDB hs4=generateHospitalCoverage(name,"Employee-sponsored-family",200,"NULL");
					hosCoverageService.addHosCoverage(hs1);
					hosCoverageService.addHosCoverage(hs2);
					hosCoverageService.addHosCoverage(hs3);
					hosCoverageService.addHosCoverage(hs4);
					System.out.println(name);
				}
				if(actionName.equals("update")){
					surgeryService.updateSurgery(surgery);
					if(!name.equals(nameBefore)){
						HosCoverageDB hs1=generateHospitalCoverage(nameBefore,"Individual",200,"NULL");
						HosCoverageDB hs2=generateHospitalCoverage(nameBefore,"Family",400,"NULL");
						HosCoverageDB hs3=generateHospitalCoverage(nameBefore,"Employee-sponsored-individual",200,"NULL");
						HosCoverageDB hs4=generateHospitalCoverage(nameBefore,"Employee-sponsored-family",200,"NULL");
						hosCoverageService.updateHosCoverage(hs1,name);
						hosCoverageService.updateHosCoverage(hs2,name);
						hosCoverageService.updateHosCoverage(hs3,name);
						hosCoverageService.updateHosCoverage(hs4,name);
						}
				}
				if(actionName.equals("delete")){
					surgeryService.deleteSurgery(Integer.parseInt(id));
					hosCoverageService.deleteHosCoverage(name);
					pcService.deleteCoverage(name);
				}
			
		}
		
		if(tableName.equals("treatment")){
			
				String id=(String)obj.get("treatment_id");
				String name=(String)obj.get("treatment_name");
				String nameBefore=treatmentService.findTreatment(Integer.parseInt(id));
				String cost=(String)obj.get("treatment_price");
				String canStaff=(String)obj.get("can_medical_staff");
				String per="";
				if(canStaff.equals("yes")){
					per="PHYSICIAN";
				}else{
					per="MEDICAL_STAFF";
				}
				TreatmentDB treatment=generateTreatment(name,Double.parseDouble(cost),canStaff);
				if(actionName.equals("add")){
					treatmentService.addTreatment(treatment);
					HosCoverageDB hs1=generateHospitalCoverage(name,"Individual",200,per);
					HosCoverageDB hs2=generateHospitalCoverage(name,"Family",400,per);
					HosCoverageDB hs3=generateHospitalCoverage(name,"Employee-sponsored-individual",200,per);
					HosCoverageDB hs4=generateHospitalCoverage(name,"Employee-sponsored-family",200,per);
					hosCoverageService.addHosCoverage(hs1);
					hosCoverageService.addHosCoverage(hs2);
					hosCoverageService.addHosCoverage(hs3);
					hosCoverageService.addHosCoverage(hs4);
				}
				if(actionName.equals("update")){
					treatmentService.updateTreatment(treatment);
					if(!name.equals(nameBefore)){
						HosCoverageDB hs1=generateHospitalCoverage(nameBefore,"Individual",200,per);
						HosCoverageDB hs2=generateHospitalCoverage(nameBefore,"Family",400,per);
						HosCoverageDB hs3=generateHospitalCoverage(nameBefore,"Employee-sponsored-individual",200,per);
						HosCoverageDB hs4=generateHospitalCoverage(nameBefore,"Employee-sponsored-family",200,per);
						hosCoverageService.updateHosCoverage(hs1,name);
						hosCoverageService.updateHosCoverage(hs2,name);
						hosCoverageService.updateHosCoverage(hs3,name);
						hosCoverageService.updateHosCoverage(hs4,name);
						}
				}
				if(actionName.equals("delete")){
					treatmentService.deleteTreatment(Integer.parseInt(id));
					hosCoverageService.deleteHosCoverage(name);
					pcService.deleteCoverage(name);
				}
			
		}
		//{"action":"delete","object":{"diagnostic_test_id":"87","diagnostic_test_name":"asd","cost":"123.12"},"table":"diagnostic"}
	  	return "abcd";
	} 
	
	public DiagnosticDB generateDiagnostic(String name,double cost){
		DiagnosticDB diagnostic=new DiagnosticDB();
		
		diagnostic.setDiagnostic_test_name(name);
		diagnostic.setCost(cost);
		return diagnostic;
		
	}
	
	public SurgeryDB generateSurgery(String name,double cost){
		SurgeryDB surgery=new SurgeryDB();
		
		surgery.setSurgery_name(name);
		surgery.setCost(cost);
		return surgery;
	}
	
	public TreatmentDB generateTreatment( String name, double cost,String can_staff){
		TreatmentDB treatment=new TreatmentDB();
		
		treatment.setTreatment_name(name);
		treatment.setTreatment_price(cost);
		treatment.setCan_medical_staff(can_staff);
		return treatment;
	}
	
	public HosCoverageDB generateHospitalCoverage(String itemName,String policyType,double deductible,String operator){
		HosCoverageDB hc=new HosCoverageDB();
		hc.setItemName(itemName);
		hc.setPolicyType(policyType);
		hc.setDeductible(deductible);
		hc.setOperatorTitle(operator);
		return hc;
	}

}
