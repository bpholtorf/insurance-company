package com.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dao.StaffDao;
import com.insurance.data.StaffDB;

@Service
public class StaffService {
	
	@Autowired
	private StaffDao staffDao;
	
	public Boolean checkAccount(StaffDB staff) {
		List<StaffDB> list = staffDao.listStaff();
		for (int i = 0; i < list.size(); i++) {
			StaffDB st = list.get(i);
			if(staff.getUsername().equals(st.getUsername())){
				return true;
			}
		}
		return null;
	}
	
	public String checkLogin(String username, String password) {

		List<StaffDB> list = staffDao.listStaff();
		for (int i = 0; i < list.size(); i++) {
			StaffDB staff = list.get(i);
			if (staff.getUsername().equals(username)
					&& staff.getPassword().equals(password)) {
				return staff.getId().toString();
			}
		}
		return null;
	}
	
	public Boolean checkSSN(String ssn){
		List<StaffDB> list = staffDao.listStaff();
		for (int i = 0; i < list.size(); i++) {
			StaffDB staff = list.get(i);
			if (staff.getSSN().equals(ssn)) {
				return true;
			}
		}
		return false;
	}
	
	public StaffDB getStaffByUsername(String username){
		List<StaffDB> list=staffDao.listStaff();
		for (int i = 0; i < list.size(); i++) {
			StaffDB staff = list.get(i);
			if (staff.getUsername().equals(username)) {
				return staff;
			}
		}
		return null;
		
	}
	
	public void updatePassword(StaffDB staff,String password){
		staffDao.updatePassword(staff, password);
	}

	public List<StaffDB> findAll()
	{
		return staffDao.findAll();
	}
	public void addStaff(StaffDB staffDB)
	{
		staffDao.addStaff(staffDB);
	}
	public void deleteStaff(String username)
	{
		staffDao.deleteStaff(username);
	}

	public StaffDB findByUsername(String username) {
		
		return staffDao.findByUsername(username);
	}

	public void updateStaff(StaffDB staff) {
		// TODO Auto-generated method stub
		staffDao.updateStaff(staff);
	}
}
