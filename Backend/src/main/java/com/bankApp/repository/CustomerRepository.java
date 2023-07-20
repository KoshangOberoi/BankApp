package com.bankApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankApp.model.Customer;



public interface CustomerRepository extends JpaRepository<Customer, Long> {
	List<Customer> findByCustEmail(String custEmail);
	List<Customer> findBybankAcc(String custAcc);
}