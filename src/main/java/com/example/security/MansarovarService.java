package com.example.security;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MansarovarService {
    @Autowired
	MansarovarRepository repo;
    
    private static final int Max_principle=100000;
    private static final int Max_rate=100;
    
    
    public Employee saveEmployee(Employee employee) {
    	validate(employee);
    	return repo.save(employee);
    }
    	
    	

	private void validate(Employee employee) {
		if(!Pattern.matches("^[a-zA-Z]+$", employee.getCustomerName())) {
			throw new IllegalArgumentException("customer name should only contains alphabets and spaces");
		}
		if(employee.getAge()<=0) {
			throw new IllegalArgumentException("Age should not be in negative number");
		}
		if(employee.getYears()<=0) {
			throw new IllegalArgumentException("years should not be in negative number");
		}
		if(employee.getPrincipleAmount()<=0 || employee.getPrincipleAmount()>Max_principle) {
			throw new IllegalArgumentException("principleAmount should be in positive number and not exceed more than 1 lakh");
		}
		if(employee.getRate()<=0 || employee.getRate()>Max_rate) {
			throw new IllegalArgumentException("rate should be in positive number and not exceed than 100");
		}
			
		
	}
	
}
