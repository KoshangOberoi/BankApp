package com.bankApp.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transId", nullable = false)
	Long transId;
	@Column(name = "custId")
	private Long custId;
	@Column(name = "account")
	private String account;
	@Column(name = "operation")
	private String operation;
	@Column(name = "amount")
	private float amount;
	@Column(name = "timestamp", columnDefinition = "TIMESTAMP")
	private LocalDateTime timestamp;
	public Transaction(Long transId, Long custId, String account, String operation, float amount, LocalDateTime timestamp) {
		this.transId = transId;
		this.custId = custId;
		this.account = account;
		this.operation = operation;
		this.amount = amount;
		this.timestamp = timestamp;
	}
	public Transaction() {
	}
	public Long getTransId() {
		return transId;
	}
	public void setTransId(Long transId) {
		this.transId = transId;
	}
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
}
