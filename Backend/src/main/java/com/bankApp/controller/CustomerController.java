package com.bankApp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankApp.model.*;
import com.bankApp.repository.CustomerRepository;
import com.bankApp.service.ICustomerService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1")
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		List<Customer> customers = customerService.getAllCustomers();
		if(customers.isEmpty()) {
			return new ResponseEntity("Sorry! Customers not available!", 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/customers/{custId}")
	public ResponseEntity<Customer> findCustomer(@PathVariable("custId")Long custId){
		Customer c = customerService.findCustomer(custId);
		if (c == null) {
			return new ResponseEntity("Sorry! Customer not available!", 
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(c, HttpStatus.OK);
	}
	
	@GetMapping("/customers/email/{custEmail}")
	public ResponseEntity<Customer> login(@PathVariable("custEmail")String custEmail){
		List<Customer> cust = customerService.login(custEmail);
		if (cust == null) {
			return new ResponseEntity("Sorry! Customer not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Customer>(cust.get(0), HttpStatus.OK);
	}
	
	@GetMapping("/customers/acc/{custAcc}")
	public ResponseEntity<Customer> getByCustAcc(@PathVariable("custAcc")String custAcc){
		List<Customer> cust = customerService.getByCustAcc(custAcc);
		if (cust == null) {
			return new ResponseEntity("Sorry! Customer not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Customer>(cust.get(0), HttpStatus.OK);
	}
	
	@GetMapping("/customers/get-payee/{custEmail}")
	public ResponseEntity<List<Customer>> getPayee(@PathVariable("custEmail")String custEmail){
		List<Customer> cust = customerService.getPayee(custEmail);
		try {
			if (cust == null) {
				return new ResponseEntity("Sorry! Customer not available!", 
						HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<List<Customer>>(cust, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping("/customers/{custId}")
	public ResponseEntity<HttpStatus> deleteCustomer(
			@PathVariable("custId")Long custId){
		try {
			customerService.deleteCustomer(custId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/customers")
	public ResponseEntity<?> deleteAllCustomer(){
		try {
			customerService.deleteAllCustomer();
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/customers/remove-payee/{custId}/{payeeId}")
	public ResponseEntity<Customer> removePayee(@PathVariable ("custId")Long custId, @PathVariable ("payeeId")Long payeeId){
		try {
			Customer c = customerService.removePayee(custId, payeeId);
			return new ResponseEntity<Customer>(c, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/customers/deposit/{custId}/{amt}")
	public ResponseEntity<Customer> deposit(
			@PathVariable("custId")Long custId, @PathVariable("amt")Float amt){
		Customer c = customerService.deposit(custId, amt);
		if(c == null) {
			return new ResponseEntity("Sorry! CustomerId not available!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Customer>(c, HttpStatus.OK);
	}
	
	@PutMapping("/customers/withdraw/{custId}/{amt}")
	public ResponseEntity<Customer> withdraw(
			@PathVariable("custId")Long custId, @PathVariable("amt")Float amt){
		Customer c = customerService.withdraw(custId, amt);
		if(c == null) {
			return new ResponseEntity("Sorry! Withdrawl Failed!", 
					HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Customer>(c, HttpStatus.OK);
	}
	
	@PutMapping("/customers")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer c){
		Customer cust = customerService.updateCustomer(c);
		if (cust != null) {
			return new ResponseEntity<Customer>(cust, HttpStatus.OK);
		} else {
			return new ResponseEntity("Sorry! CustomerId not found!", 
					HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/customers/{custId}")
	public ResponseEntity<Customer> updateCust(@RequestBody Customer c, @PathVariable("custId")Long custId){
		Customer cust = customerService.updateCustomer(c);
		if (cust != null) {
			return new ResponseEntity<Customer>(cust, HttpStatus.OK);
		} else {
			return new ResponseEntity("Sorry! CustomerId not found!", 
					HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/customers/add-payee/{custId}/{bankAcc}")
	public ResponseEntity<Customer> addPayee(@PathVariable("custId")Long custId, @PathVariable("bankAcc")String bankAcc){
		Customer cust = customerService.addPayee(custId, bankAcc);
		if (cust != null) {
			return new ResponseEntity<Customer>(cust, HttpStatus.OK);
		} else {
			return new ResponseEntity("Sorry! CustomerId not found or payee already exist!", 
					HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/customers") // PostMapping is used to save new data on the server
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer c) {
		try {
			customerService.addCustomer(c);
			return new ResponseEntity<>(c, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/customers/new") // PostMapping is used to save new data on the server
	public ResponseEntity<Customer> register(@RequestBody Customer cust) {
		Customer c = customerService.register(cust);
		if(c == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		else {
			return new ResponseEntity<>(c, HttpStatus.CREATED);
		}
	}
	
}
