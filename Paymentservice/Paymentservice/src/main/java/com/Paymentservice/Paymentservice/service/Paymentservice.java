package com.Paymentservice.Paymentservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Paymentservice.Paymentservice.Model.Payment;
import com.Paymentservice.Paymentservice.repository.Paymentrepository;

@Service
public class Paymentservice {

	@Autowired
	private Paymentrepository repo;
	
//	add payment
	public Payment addpayments(Payment p) {
		return repo.save(p);
	}
//		get all payments
	public List<Payment>getallpayments(){
		return repo.findAll();
		
	}
	
//	get payment by id
	public Payment getpaymentbyid(int id) {
		return repo.getById(id);
	}
	
//	update payment by id
	public Payment updatebyid(int id, Payment p) {
	    Optional<Payment> existingPayment = repo.findById(id);
	    if (existingPayment.isPresent()) {
	        Payment pay = existingPayment.get();

	        // ✅ Update the values from the new object 'p'
	        pay.setAmount(p.getAmount());
	        pay.setPaymentmethod(p.getPaymentmethod());
	        pay.setPaymentstatus(p.isPaymentstatus());

	        // Note: Usually you don’t update the ID
	        return repo.save(pay);
	    }
	    return null;
	}

//	delete by id
	public String deletebyid(int id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
			return "deleted successfully" +id;
			
					
		}
		return "id not found";
		
	}
//	delete all
	public String deleteall() {
		repo.deleteAll();
		return "all deleted successfully";
	}

}
