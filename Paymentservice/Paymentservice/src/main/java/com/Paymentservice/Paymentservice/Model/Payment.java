package com.Paymentservice.Paymentservice.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Payment {
	@Id
	private int paymentId;
	private double amount;
	private String paymentmethod;
	private boolean paymentstatus;
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getPaymentmethod() {
		return paymentmethod;
	}
	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}
	public boolean isPaymentstatus() {
		return paymentstatus;
	}
	public void setPaymentstatus(boolean paymentstatus) {
		this.paymentstatus = paymentstatus;
	}
	
	
	

}
