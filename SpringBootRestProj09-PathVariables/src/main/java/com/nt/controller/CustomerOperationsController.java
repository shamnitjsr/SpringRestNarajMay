package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerOperationsController {

	@GetMapping("/report/{no}/{name}")
	public String fetchData( @PathVariable("name") String cname, @PathVariable Integer no) {
		return no + "<------> " + cname;

	}

}
