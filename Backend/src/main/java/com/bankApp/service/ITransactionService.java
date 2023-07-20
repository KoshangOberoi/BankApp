package com.bankApp.service;

import java.util.List;

import com.bankApp.model.Transaction;

public interface ITransactionService {
	public List<Transaction> getAllTransaction();

	public Transaction addTransaction(Transaction t);

	public List<Transaction> miniStatement(Long custId);
}
