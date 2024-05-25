package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/testingNew")
public class MansarovarController {
	
	@Autowired
	MansarovarService service;
	
	@PostMapping(value="/create")
	
	public ResponseEntity<String> create(@RequestBody Employee employee) {
		try {
			Employee savedEmployee=service.saveEmployee(employee);
			
			double simpleInterest=savedEmployee.calculateSimpleIntrest();
			return ResponseEntity.ok("record inserted successfully . simple intrest:"+simpleInterest);
			
		}
		catch(IllegalArgumentException ie) {
			return ResponseEntity.badRequest().body(ie.getMessage());	
		}
		
	}
	
	
	

}
