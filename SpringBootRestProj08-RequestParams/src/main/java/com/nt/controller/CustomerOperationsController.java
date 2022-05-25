package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Customer;

@RestController
public class CustomerOperationsController {

	@PostMapping("/register")
	public ResponseEntity<String> saveCustomer(@RequestBody Customer cust) {
		return new ResponseEntity<String>(cust.toString(), HttpStatus.OK);
	}

	@GetMapping("/report")
	public String reportData(@RequestParam("cno") Integer no, @RequestParam String cname) {
		return no + " " + cname;

	}
	
	@GetMapping("/report1")
	public String reportData1(@RequestParam("cno") Integer no, @RequestParam(required=false) String cname) {
		return no + " " + cname;

	}
	
	@GetMapping("/report2")
	public String reportData2(@RequestParam("cno") Integer no, @RequestParam(required=true) String cname) {
		return no + " " + cname;

	}
}
