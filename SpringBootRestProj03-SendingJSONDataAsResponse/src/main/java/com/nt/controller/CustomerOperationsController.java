package com.nt.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;
import com.nt.model.Customer;

@RestController
@RequestMapping("/customer")
public class CustomerOperationsController {

	@GetMapping("/report1")
	public ResponseEntity<Customer> showData1() {
		//body
		Customer cust = new Customer(1001,"Shambhu",6578.89f,
				new String[] {"read","green","blue"},
				List.of("10th","10+2","B.Tech"),
				Set.of(456789876L,9876543456789L,76545678L),
				Map.of("aadhar",4567765L,"panNo",9876556789L),
				new Company("ORACLE","blr","computer",4500));
		//status
		HttpStatus status = HttpStatus.OK;
		return new ResponseEntity<Customer>(cust,status);
	}

}
