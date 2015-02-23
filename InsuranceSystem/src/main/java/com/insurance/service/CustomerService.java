package com.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dao.CustomerDao;
import com.insurance.data.CustomerDB;

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
	public void deleteCustomer(Integer id)
	{
		CustomerDao.deleteCustomer(id);
	}

	public CustomerDB findById(Integer id) {
		return CustomerDao.findById(id);
	}

	public void updateCustomer(CustomerDB customer) {
		// TODO Auto-generated method stub
		CustomerDao.updateCustomer(customer);
	}
}
