package com.xoriant.ecart;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class C1 {
	
	@Value("${name}")
	private String personName;
	
	public C1() {
		System.out.println(">>> C1 class object created..");
	}
	
	@PostConstruct
	public void f1() {
		System.out.println(">>> Name is : "+personName);
	}

}
