package com.bankApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankApp.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	
	List<Transaction> findFirst10ByCustIdOrderByTimestampDesc(Long custId);

}
