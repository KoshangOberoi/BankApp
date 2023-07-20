package com.bankApp.dao;

import java.util.List;

import com.bankApp.model.Transaction;

public interface ITransactionDao {
	public List<Transaction> getAllTransaction();

	public Transaction addTransaction(Transaction t);

	public List<Transaction> miniStatement(Long custId);
}
