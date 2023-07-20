package com.bankApp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankApp.model.Transaction;
import com.bankApp.repository.TransactionRepository;


@Repository("transactionDao")
public class TransactionDaoImpl implements ITransactionDao{

	@Autowired
	private TransactionRepository transactionRepo;
	
	@Override
	public List<Transaction> getAllTransaction() {
		// TODO Auto-generated method stub
		return transactionRepo.findAll();
	}

	@Override
	public Transaction addTransaction(Transaction t) {
		// TODO Auto-generated method stub
		return transactionRepo.save(new Transaction(t.getTransId(), t.getCustId(), t.getAccount(), t.getOperation(), t.getAmount(), t.getTimestamp()));
	}

	@Override
	public List<Transaction> miniStatement(Long custId) {
		// TODO Auto-generated method stub
		return transactionRepo.findFirst10ByCustIdOrderByTimestampDesc(custId);
	}

}
