package com.bankApp.service;

import java.util.List;

import com.bankApp.model.Customer;


public interface ICustomerService {
	public List<Customer> getAllCustomers();

	public Customer findCustomer(Long CustomerId);

	public void deleteCustomer(Long CustomerId);
	
	public void deleteAllCustomer();

	public Customer updateCustomer(Customer Customer);
	
	public Customer withdraw(Long CustomerId, Float amt);
	
	public Customer deposit(Long CustomerId, Float amt);
	
	public void addCustomer(Customer c);
	
	public Customer register(Customer customer);
	
	public List<Customer> login(String email);
	
	public List<Customer> getByCustAcc(String custAcc);

	public Customer addPayee(Long custId, String bankAcc);
	
	public List<Customer> getPayee(String custEmail);
	
	public Customer removePayee(Long custId, Long payeeId);
	
}
