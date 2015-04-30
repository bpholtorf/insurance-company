package com.team.InsuranceSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.insurance.dao.HosBillInfoDao;
import com.insurance.data.BillHeaderDB;
import com.insurance.data.BillInfoDB;
import com.insurance.data.HosBillDB;
import com.insurance.data.HosBillInfoDB;
import com.insurance.service.BillInfoService;
import com.insurance.service.BillService;
@Controller
public class BillController {
	@Autowired
    private BillService bService;
	@Autowired
	private BillInfoService infoService;
	@RequestMapping("bill/getBill/{ssn}")
	public String findBillBySSN(@PathVariable("ssn") String ssn,Model model)
	{
		System.out.println(bService.findPharBillBySSN(ssn, 0));
		model.addAttribute("pharBills", bService.findPharBillBySSN(ssn, 0));
		model.addAttribute("hosBills",bService.findHosBillBySSN(ssn, 0));
		return "chooseBill";
	} 
	//this method response to POST request http://localhost/bill/getPharBill/
		@RequestMapping(value="bill/getPharBill",method=RequestMethod.POST)
		public @ResponseBody String getPharBill(HttpServletRequest request) throws ParseException
		{
			StringBuffer jb = new StringBuffer();
			  String line = null;
			  try {
			    BufferedReader reader = request.getReader();
			    while ((line = reader.readLine()) != null)
			      jb.append(line);
			  } catch (Exception e) {  
				  
			  }
			  System.out.println("get PharBill!!!"+jb.toString());
			if(!jb.toString().equals(""))
			{
		    JSONObject jsonObject = JSONObject.fromObject(jb.toString());	
		    JSONObject billHeaderJson=jsonObject.getJSONObject("billHeader");
		    
		    String billId=billHeaderJson.getString("billId");
		    if(bService.findBillByBillNum(billId)==null){
		    String date=billHeaderJson.getString("billDate");
		    DateFormat df = new SimpleDateFormat("mm/dd/yyyy");
		    Date startDate =df.parse(date);
		    
		    String customerSsn=billHeaderJson.getString("customerSsn");
		    double billTotal=billHeaderJson.getDouble("billTotal");
		    
		    BillHeaderDB header=new BillHeaderDB();
		    header.setBillNumber(billId);
		    header.setBillType("prescription");
		    header.setDate(startDate);
		    header.setSsn(customerSsn);
		    header.setTotalCharge(billTotal);
		    header.setBillType(BillType.pharmacy.toString());
		    
		    
		    JSONArray info=jsonObject.getJSONArray("billContents");
		    if (info.size()>0) {
		    	for(int i=0;i<info.size();i++)
		    	{
				JSONObject billInfo=JSONObject.fromObject(info.get(i));
				String billNum=billInfo.getString("billId");
				String drugId=billInfo.getString("drugId");
				String name=billInfo.getString("drugNameCommercial");
				int qty=billInfo.getInt("drugQty");
				double drugCharge=billInfo.getDouble("drugCharge");
				BillInfoDB billInfoDB=new BillInfoDB();
				billInfoDB.setBillNumber(billNum);
				billInfoDB.setDrugId(drugId);
				billInfoDB.setName(name);
				billInfoDB.setQuantity(qty+"");
				billInfoDB.setTotalCharge(drugCharge);
				billInfoDB.setType("prescription");
				
				infoService.savePha(billInfoDB);
		    	}
		    	bService.save(header);
			}
		    
			}		
			return "get PharBill";
			}
			else {
				return "the bill with the billNumber has been sent to us before";
			}
		}
		public enum BillType
		{
			pharmacy,hospital
		}
		@RequestMapping(value="bill/sendPharBill",method=RequestMethod.POST)
		public @ResponseBody String sendPharBill(HttpServletRequest request)
		{
			StringBuffer jb = new StringBuffer();
			  String line = null;
			  try {
			    BufferedReader reader = request.getReader();
			    while ((line = reader.readLine()) != null)
			      jb.append(line);
			  } catch (Exception e) {  
				  
			  }
			  System.out.println(""+jb.toString());
			  return "get PharBill!!!";
		}
		@RequestMapping(value="bill/getHosBill",method=RequestMethod.POST)
		public @ResponseBody String getHosBill(HttpServletRequest request) throws ParseException
		{
			StringBuffer jb = new StringBuffer();
			String line = null;
			  try {
			    BufferedReader reader = request.getReader();
			    while ((line = reader.readLine()) != null)
			      jb.append(line);
			  } catch (Exception e) {  
				  
			  }
			  System.out.println("get PharBill!!!"+jb.toString());
			 if (!jb.toString().equals("")) {
				JSONObject jsonObject=JSONObject.fromObject(jb.toString());
				JSONObject billHeaderJson=jsonObject.getJSONObject("trans");
				String billId=billHeaderJson.getInt("transcription_id")+"";
				
			if(bService.getHosBill(billId)==null){
				String patientSsn=billHeaderJson.getString("patient_ssn");
				String date=billHeaderJson.getString("create_date");
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			    Date startDate =df.parse(date);
			    String operatorTitle=billHeaderJson.getString("writer_type");
			    double total=0;
			    
			    JSONArray diagnosticList=jsonObject.getJSONArray("diagnosticList");
			    
			    if (diagnosticList.size()>0) {
					for (int i = 0; i < diagnosticList.size(); i++) {
						JSONObject item=diagnosticList.getJSONObject(i);
						String itemName=item.getString("diagnostic_test_name");
						double price=item.getDouble("price");
						total+=price;
						HosBillInfoDB billItem=new HosBillInfoDB();
						billItem.setBillNumber(billId);
						billItem.setItemName(itemName);
						billItem.setItemType("diagnostic_test");
						billItem.setOperatorTitle(operatorTitle);
						billItem.setPrice(price);
						infoService.saveHos(billItem);
					}
				}
			    
			    JSONArray surgeryList=jsonObject.getJSONArray("surgeryList");
			    
			    if (surgeryList.size()>0) {
					for (int i = 0; i < surgeryList.size(); i++) {
						JSONObject item=surgeryList.getJSONObject(i);
						String itemName=item.getString("surgery_name");
						double price=item.getDouble("price");
						total+=price;
						HosBillInfoDB billItem=new HosBillInfoDB();
						billItem.setBillNumber(billId);
						billItem.setItemName(itemName);
						billItem.setItemType("surgery");
						billItem.setOperatorTitle(operatorTitle);
						billItem.setPrice(price);
						infoService.saveHos(billItem);
					}
				}
			    
			    JSONArray treatmentList=jsonObject.getJSONArray("treatmentList");
			    if (treatmentList.size()>0) {
					for (int i = 0; i < treatmentList.size(); i++) {
						JSONObject item=treatmentList.getJSONObject(i);
						String itemName=item.getString("treatment_name");
						double price=item.getDouble("price");
						total+=price;
						HosBillInfoDB billItem=new HosBillInfoDB();
						billItem.setBillNumber(billId);
						billItem.setItemName(itemName);
						billItem.setItemType("treatment");
						billItem.setOperatorTitle(operatorTitle);
						billItem.setPrice(price);
						infoService.saveHos(billItem);
					}
				}
			    
			    BillHeaderDB billHeaderDB=new BillHeaderDB();
			    billHeaderDB.setBillNumber(billId);
			    billHeaderDB.setBillType("hospital");
			    billHeaderDB.setDate(startDate);
			    billHeaderDB.setTotalCharge(total);
			    billHeaderDB.setSsn(patientSsn);
			    bService.save(billHeaderDB);
			    
			    return "receive bill successfully";
			}  
			else
			 return "You have sent us the bill before";
			}
			return "the data is empty";
		}
	   @RequestMapping(value="bill/sendReport",method=RequestMethod.GET)
	   public @ResponseBody String sendReport(@RequestParam("billId") String billId)
	   {
			BillHeaderDB billHeaderDB=bService.findBillDB(billId);
		    String billType=billHeaderDB.getBillType();
		    if (billType.equalsIgnoreCase("hospital")) {
				sendHosReport(billId);
				
			}
		    else {
				sendPharReport(billId);
			}
		    int status=billHeaderDB.getStatus();
			billHeaderDB.setStatus(status+1);
			bService.update(billHeaderDB);
			return "pose success";
			
	   }
	 
		private String sendPharReport(String billId) {
			 try {  
				   // String strURL="http://localhost:8080/InsuranceSystem/bill/sendPharBill";
				String strURL="http://138.49.101.83/Pharmacy/interface/bill";
				    JSONObject jsonObject=JSONObject.fromObject(bService.findBillByBillNum(billId));					
					String params=jsonObject.toString();
		            URL url = new URL(strURL); 
		            HttpURLConnection connection = (HttpURLConnection) url.openConnection();  
		            connection.setDoOutput(true);  
		            connection.setDoInput(true);  
		            connection.setUseCaches(false);  
		            connection.setInstanceFollowRedirects(true);  
		            connection.setRequestMethod("POST");   
		            connection.setRequestProperty("Accept", "application/json"); 
		            connection.setRequestProperty("Content-Type", "application/json"); 
		            connection.connect();  
		            OutputStreamWriter out = new OutputStreamWriter(  
		                    connection.getOutputStream(), "UTF-8");  
		            out.append(params);  
		            out.flush();  
		            out.close();  
		           
		            int length = (int) connection.getContentLength(); 
		            InputStream is = connection.getInputStream();  
		            if (length != -1) {  
		                byte[] data = new byte[length];  
		                byte[] temp = new byte[512];  
		                int readLen = 0;  
		                int destPos = 0;  
		                while ((readLen = is.read(temp)) > 0) {  
		                    System.arraycopy(temp, 0, data, destPos, readLen);  
		                    destPos += readLen;  
		                }  
		                String result = new String(data, "UTF-8");   
		                System.out.println(result);  
		                return result;  
		            }  
		        } catch (IOException e) {  
		            e.printStackTrace();  
		        }  
		        return "error"; 
		    
		  
			
		}
		private String sendHosReport(String billId) {
			
			try {  
			   // String strURL="http://localhost:8080/InsuranceSystem/bill/sendPharBill";
			    String strURL="http://138.49.101.81/Administrative/bill/calcBill";
				//String strURL="http://172.31.156.156:8080/admin/bill/calcBill";
			    HosBillDB billDB=bService.getHosBill(billId);
			    JSONObject jsonObject=new JSONObject();
			    jsonObject.put("transcriptionId", billId);
			    jsonObject.put("ssn", billDB.getSsn());
			    jsonObject.put("totalAmount", billDB.getTotalCharge());
			    jsonObject.put("coveredAmount", billDB.getTotalCoverage());
				String params=jsonObject.toString();
	            URL url = new URL(strURL); 
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();  
	            connection.setDoOutput(true);  
	            connection.setDoInput(true);  
	            connection.setUseCaches(false);  
	            connection.setInstanceFollowRedirects(true);  
	            connection.setRequestMethod("POST");   
	            connection.setRequestProperty("Accept", "application/json"); 
	            connection.setRequestProperty("Content-Type", "application/json"); 
	            connection.connect();  
	            OutputStreamWriter out = new OutputStreamWriter(  
	                    connection.getOutputStream(), "UTF-8");  
	            out.append(params);  
	            out.flush();  
	            out.close();  
	           
	            int length = (int) connection.getContentLength(); 
	            InputStream is = connection.getInputStream();  
	            if (length != -1) {  
	                byte[] data = new byte[length];  
	                byte[] temp = new byte[512];  
	                int readLen = 0;  
	                int destPos = 0;  
	                while ((readLen = is.read(temp)) > 0) {  
	                    System.arraycopy(temp, 0, data, destPos, readLen);  
	                    destPos += readLen;  
	                }  
	                String result = new String(data, "UTF-8");   
	                System.out.println(result);  
	                return result;  
	            }  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	        return "error"; 
	    
	  
		}
}
