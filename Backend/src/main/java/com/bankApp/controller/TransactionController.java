package com.bankApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bankApp.model.Transaction;
import com.bankApp.service.ITransactionService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/v1")
public class TransactionController {
	@Autowired
	private ITransactionService transactionService;
	
	@GetMapping("/transactions")
	public ResponseEntity<List<Transaction>> getAllTransaction(){
		try {
			List<Transaction> ts = transactionService.getAllTransaction();
			if(ts.isEmpty()) {
				return new ResponseEntity("Sorry! Customers not available!", 
						HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Transaction>>(ts, HttpStatus.OK);
			
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/transactions/{custId}")
	public ResponseEntity<List<Transaction>> miniStatement(@PathVariable ("custId")Long custId){
		try {
			List<Transaction> ts = transactionService.miniStatement(custId);
			if(ts.isEmpty()) {
				return new ResponseEntity("Sorry! Transactions not available!", 
						HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<Transaction>>(ts, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/transactions")
	public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction t){
		try {
			Transaction T= transactionService.addTransaction(t);
			return new ResponseEntity<Transaction>(T, HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
