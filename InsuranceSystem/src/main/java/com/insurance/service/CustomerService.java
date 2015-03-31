package com.insurance.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dao.CustomerDao;
import com.insurance.data.CustomerDB;
import com.insurance.data.StaffDB;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao CustomerDao;
	

	
	
	public CustomerDB getCustomerById(Integer id){
		List<CustomerDB> list=CustomerDao.listCustomer();
		for (int i = 0; i < list.size(); i++) {
			CustomerDB Customer = list.get(i);
			if (Customer.getId().equals(id)) {
				return Customer;
			}
		}
		return null;
		
	}

	public List<CustomerDB> findAll()
	{
		return CustomerDao.findAll();
	}
	public void addCustomer(CustomerDB CustomerDB)
	{
		CustomerDao.addCustomer(CustomerDB);
	}
	public boolean deleteCustomer(Integer id)
	{
		return CustomerDao.deleteCustomer(id);
	}

	public boolean deleteCustomer1(Integer id)
	{
		return CustomerDao.deleteCustomer1(id);
	}

	
	public CustomerDB findById(Integer id) {
		return CustomerDao.findById(id);
	}

	public void updateCustomer(CustomerDB customer) {
		CustomerDao.updateCustomer(customer);
	}

	public List<CustomerDB> searchBySSN(String keyword) {
		return CustomerDao.searchBySSN(keyword);
	}
	public List<CustomerDB> searchByDateofBirth(String keyword) throws ParseException {
		return CustomerDao.searchByDateofBirth(keyword);
	}

	public List<CustomerDB> searchByName(String pattern) {
		return CustomerDao.searchByName(pattern);
	}
}
