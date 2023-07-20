package com.mybootapp.mybootapp;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankApp.model.Customer;

public interface TestH2Repository extends JpaRepository<Customer, Long>{

}
