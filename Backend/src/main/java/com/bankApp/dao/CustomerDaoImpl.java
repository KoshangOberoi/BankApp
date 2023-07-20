package com.bankApp.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.bankApp.model.*;
import com.bankApp.repository.CustomerRepository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

@Repository("custDao")
public class CustomerDaoImpl implements ICustomerDao{
	@Autowired
	private CustomerRepository customerRepo;

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		List<Customer> customers = new ArrayList<Customer>();
		customerRepo.findAll().forEach(customers::add);
		return customers;
	}
 
	public Customer findCustomer (Long CustomerId) {
		// TODO Auto-generated method stub
		Optional<Customer> customerData = customerRepo.findById(CustomerId);

		if (customerData.isPresent()) {
			return customerData.get();
		} 
		else {
			return null;
		}
	}

	public void deleteCustomer(Long CustomerId) {
		// TODO Auto-generated method stub
		customerRepo.deleteById(CustomerId);
		return;
	}


	public Customer updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		Optional<Customer> customerData = customerRepo.findById(c.getCustId());
		if (customerData.isPresent()) {
			Customer _customer = customerData.get();
			if(c.getName() != null) {
				_customer.setName(c.getName());
			}
			if(c.getAadhar() != null) {
				_customer.setAadhar(c.getAadhar());
			}
			if(c.getAddress() != null) {
				_customer.setAddress(c.getAddress());
			}
			if(c.getBal() != 0.0f) {
				_customer.setBal(c.getBal());
			}
			if(c.getCIBILscore() != 0) {
				_customer.setCIBILscore(c.getCIBILscore());
			}
			if(c.getCustEmail() != null) {
				_customer.setCustEmail(c.getCustEmail());
			}
			if(c.getPan() != null) {
				_customer.setPan(c.getPan());
			}
			if(c.getPassword() != null) {
				_customer.setPassword(c.getPassword());
			}
			_customer.setKycStatus(1);
			
			customerRepo.save(_customer);
			return _customer;
		} else {
			return null;
		}
	}

	public Customer withdraw(Long CustomerId, Float amt) {
		// TODO Auto-generated method stub
		Optional<Customer> customerData = customerRepo.findById(CustomerId);
		Customer c = customerData.get();
		if(c!=null && c.getBal() > amt && customerData.isPresent()) {
			c.setBal(c.getBal()-amt);
			c.setCIBILscore(c.getCIBILscore()-5);
			c.setName(c.getName());
			c.setCustEmail(c.getCustEmail());
			c.setCIBILscore(c.getCIBILscore());
			customerRepo.save(c);
			return c;
		}
		return null;
	}

	public Customer deposit(Long CustomerId, Float amt) {
		Optional<Customer> customerData = customerRepo.findById(CustomerId);
		Customer c = customerData.get();
		if(c!=null && customerData.isPresent()) {
			c.setBal(c.getBal()+amt);
			c.setCIBILscore(c.getCIBILscore()+10);
			c.setName(c.getName());
			c.setCustEmail(c.getCustEmail());
			c.setCIBILscore(c.getCIBILscore());
			customerRepo.save(c);
			return c;
		}
		return null;
	}

	public void deleteAllCustomer() {
		// TODO Auto-generated method stub
		customerRepo.deleteAll();
		return;
	}
	
	public void addCustomer(Customer c) {
		customerRepo.save(new Customer(c.getCustId(), c.getCustEmail(), c.getName(), c.getAddress(), c.getBal(), c.getCIBILscore(), c.getAadhar(), c.getPan(), c.getKycStatus(), c.getPassword(), c.getBankAcc(), c.getPayee()));
		return;
	}
	
	public Customer register(Customer cust) {
		List<Customer> cs = customerRepo.findByCustEmail((String)cust.getCustEmail());
		if(!cs.isEmpty()) return null;
		Customer c = new Customer();
		c.setName(cust.getName());
		c.setCustEmail(cust.getCustEmail());
		c.setPassword(cust.getPassword());
		c.setBankAcc(cust.getBankAcc().toUpperCase());
		customerRepo.save(c);
		return c;
	}
	
	public List<Customer> login(String email) {
		List<Customer> cust = customerRepo.findByCustEmail(email);
		return cust;
	}

	@Override
	public List<Customer> getByCustAcc(String custAcc) {
		// TODO Auto-generated method stub
		List<Customer> cust = customerRepo.findBybankAcc(custAcc);
		return cust;
	}

	@Override
	public Customer addPayee(Long custId, String bankAcc) {
		// TODO Auto-generated method stub
		
		Optional<Customer> x = customerRepo.findById(custId);
		Customer c = x.get();
		if(c == null)return null;
		List<Customer> payee = customerRepo.findBybankAcc(bankAcc);
		if(payee.isEmpty())return null;
		if(c.getPayee() == null) {
			c.setPayee(new Long[] {payee.get(0).getCustId()});
		}
		else {
			Long[] arr = Arrays.copyOf(c.getPayee(), c.getPayee().length+1);
			arr[c.getPayee().length] = payee.get(0).getCustId();
			c.setPayee(arr);
		}
		customerRepo.save(c);
		return c;
	}

	@Override
	public List<Customer> getPayee(String custEmail) {
		// TODO Auto-generated method stub
		List<Customer> payees = new ArrayList<Customer>();
		Long[] payeeIds = customerRepo.findByCustEmail(custEmail).get(0).getPayee();
		if(payeeIds == null)return null;
		for(Long id: payeeIds) {
			payees.add(customerRepo.findById(id).get());
		}
		return payees;
	}

	@Override
	public Customer removePayee(Long custId, Long payeeId) {
		// TODO Auto-generated method stub
		Optional<Customer> cData = customerRepo.findById(custId);
		if(cData.isPresent()) { 
			Customer c = cData.get();
			List<Long> newPayee = new ArrayList<Long>();
			for(Long payee: c.getPayee()) {
				newPayee.add(payee);
			}
			if(newPayee.contains(payeeId))newPayee.remove(payeeId);
			if(newPayee.size() == 0)c.setPayee(null);
			else c.setPayee(newPayee.toArray(new Long[newPayee.size()]));
			customerRepo.save(c);
			return c;
		}
		else return null;
	}
	
}
