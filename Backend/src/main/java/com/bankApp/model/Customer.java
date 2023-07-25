package com.bankApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "Bank_Cust")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	Long custId;
	@Column(name = "CUSTEMAIL")
	private String custEmail;
	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "bal")
	private float bal;
	@Column(name= "pri_bal")
	private float pri_bal;
	@Column(name = "CIBILscore")
	private int CIBILscore;
	@Column(name = "aadhar")
	private String aadhar;
	@Column(name = "pan")
	private String pan;
	@Column(name = "kycStatus")
	private Integer kycStatus;
	@Column(name = "password")
	private String password;
	@Column(name = "bankAcc")
	private String bankAcc;
	@Column(name = "payee")
    @Type(type = "com.bankApp.customType.CustomLongArrayType")
	private Long[] payee;

	public Customer(Long custId, String custEmail, String name, String address, float bal, float pri_bal,
			int cIBILscore, String aadhar, String pan, Integer kycStatus, String password, String bankAcc,
			Long[] payee) {
		super();
		this.custId = custId;
		this.custEmail = custEmail;
		this.name = name;
		this.address = address;
		this.bal = bal;
		this.pri_bal = pri_bal;
		CIBILscore = cIBILscore;
		this.aadhar = aadhar;
		this.pan = pan;
		this.kycStatus = kycStatus;
		this.password = password;
		this.bankAcc = bankAcc;
		this.payee = payee;
	}

	public float getPri_bal() {
		return pri_bal;
	}

	public void setPri_bal(float pri_bal) {
		this.pri_bal = pri_bal;
	}

	public Customer() {
		super();
	}
	public String getBankAcc() {
		return bankAcc;
	}
	public void setBankAcc(String bankAcc) {
		this.bankAcc = bankAcc;
	}
	public Long[] getPayee() {
		return payee;
	}
	public void setPayee(Long[] payee) {
		this.payee = payee;
	}
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public float getBal() {
		return bal;
	}
	public void setBal(float bal) {
		this.bal = bal;
	}
	public int getCIBILscore() {
		return CIBILscore;
	}
	public void setCIBILscore(int cIBILscore) {
		CIBILscore = cIBILscore;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public Integer getKycStatus() {
		return kycStatus;
	}
	public void setKycStatus(Integer kycStatus) {
		this.kycStatus = kycStatus;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
