package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerOperationsController {

	@GetMapping("/report")
	public ResponseEntity<Customer> showData() {
		Customer cust = new Customer(1001,"Shambhu","blr",456787.97f);
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<Customer>(cust, status);
	}

}
