package com.example.security;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Employee")
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String customerName;
	private int age;
	private int principleAmount;
	private int years;
	private int rate;
	
	
	public double calculateSimpleIntrest() {
		return (principleAmount*years*rate)/100.0;
	}
	
	

}
