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


}
