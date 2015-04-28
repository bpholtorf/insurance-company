package com.insurance.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dao.EmployeeDao;
import com.insurance.data.EmployeeDB;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao EmployeeDao;
	

	
	
	public EmployeeDB getEmployeeById(Integer id){
		List<EmployeeDB> list=EmployeeDao.listEmployee();
		for (int i = 0; i < list.size(); i++) {
			EmployeeDB Employee = list.get(i);
			if (Employee.getId().equals(id)) {
				return Employee;
			}
		}
		return null;
		
	}

	public List<EmployeeDB> findAll()
	{
		return EmployeeDao.findAll();
	}
	public void addEmployee(EmployeeDB EmployeeDB)
	{
		EmployeeDao.addEmployee(EmployeeDB);
	}
	

	
	public EmployeeDB findById(Integer id) {
		return EmployeeDao.findById(id);
	}

	

	public List<EmployeeDB> searchBySSN(String keyword) {
		return EmployeeDao.searchBySSN(keyword);
	}
	public List<EmployeeDB> searchByDateofBirth(String keyword) throws ParseException {
		return EmployeeDao.searchByDateofBirth(keyword);
	}

	public List<EmployeeDB> searchByName(String pattern) {
		return EmployeeDao.searchByName(pattern);
	}
}
