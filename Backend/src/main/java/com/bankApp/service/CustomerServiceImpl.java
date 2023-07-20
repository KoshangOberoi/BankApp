package com.bankApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankApp.dao.ICustomerDao;
import com.bankApp.model.Customer;

@Service("custService")
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	private ICustomerDao custDao;

	@Override
	public Customer findCustomer(Long CustomerId) {
		// TODO Auto-generated method stub
		return custDao.findCustomer(CustomerId);
	}

	@Override
	public void deleteCustomer(Long CustomerId) {
		// TODO Auto-generated method stub
		custDao.deleteCustomer(CustomerId);
		return;
	}
	
	@Override
	public void deleteAllCustomer() {
		// TODO Auto-generated method stub
		custDao.deleteAllCustomer();
		return;
	}

	@Override
	public Customer updateCustomer(Customer Customer) {
		// TODO Auto-generated method stub
		return custDao.updateCustomer(Customer);
	}

	@Override
	public Customer withdraw(Long CustomerId, Float amt) {
		// TODO Auto-generated method stub
		return custDao.withdraw(CustomerId, amt);
	}

	@Override
	public Customer deposit(Long CustomerId, Float amt) {
		// TODO Auto-generated method stub
		return custDao.deposit(CustomerId, amt);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return custDao.getAllCustomers();
	}

	@Override
	public void addCustomer(Customer c) {
		// TODO Auto-generated method stub
		custDao.addCustomer(c);
		return;
	}

	@Override
	public Customer register(Customer customer) {
		// TODO Auto-generated method stub
		return custDao.register(customer);
	}

	@Override
	public List<Customer> login(String email) {
		return custDao.login(email);
	}

	@Override
	public List<Customer> getByCustAcc(String custAcc) {
		// TODO Auto-generated method stub
		return custDao.getByCustAcc(custAcc);
	}

	@Override
	public Customer addPayee(Long custId, String bankAcc) {
		// TODO Auto-generated method stub
		return custDao.addPayee(custId, bankAcc);
	}

	@Override
	public List<Customer> getPayee(String custEmail) {
		// TODO Auto-generated method stub
		return custDao.getPayee(custEmail);
	}

	@Override
	public Customer removePayee(Long custId, Long payeeId) {
		// TODO Auto-generated method stub
		return custDao.removePayee(custId, payeeId);
	}
}
