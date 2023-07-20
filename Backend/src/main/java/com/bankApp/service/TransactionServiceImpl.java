package com.bankApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankApp.dao.ITransactionDao;
import com.bankApp.model.Transaction;

@Service("transactionService")
public class TransactionServiceImpl implements ITransactionService{

	@Autowired
	private ITransactionDao transactionDao;
	
	@Override
	public List<Transaction> getAllTransaction() {
		// TODO Auto-generated method stub
		return transactionDao.getAllTransaction();
	}

	@Override
	public Transaction addTransaction(Transaction t) {
		// TODO Auto-generated method stub
		return transactionDao.addTransaction(t);
	}

	@Override
	public List<Transaction> miniStatement(Long custId) {
		// TODO Auto-generated method stub
		return transactionDao.miniStatement(custId);
	}

}
