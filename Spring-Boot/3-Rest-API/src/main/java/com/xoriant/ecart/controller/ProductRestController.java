package com.xoriant.ecart.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.ecart.model.Product;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

	@GetMapping
	public String f1() {
		return "GET:: Welcome";
	}
	
	@GetMapping(value = "/getProduct")
	public Product f16() {
		
		Product p1=new Product(10, "Pen", 1000);
		
		return p1;
	}
	
	@GetMapping("/findAll")
	public List<Product> findAll(){
		return Arrays.asList(new Product(11, "Pen", 34),new Product(12, "Book", 445),new Product(13, "Mobile", 3334));
	}
	
	@GetMapping("/filter/byDate/{date}")
	public String f15(@PathVariable @DateTimeFormat(iso = ISO.DATE) LocalDate date) {
		return "GET- Date "+date+" :: Welcome";
	}
	
	@GetMapping("/{minPrice}/{maxPrice}")
	public String f14(@PathVariable double minPrice,@PathVariable double maxPrice) {
		return "GET - MIN "+minPrice+" and MAX "+maxPrice+" :: Welcome";
	}
	
	@GetMapping("/{id}")
	public String f13(@PathVariable int id) {
		return "GET - ID "+id+ ":: Welcome";
	}
	
	@GetMapping("/filter/{name}")
	public String f14(@PathVariable String name) {
		return "GET - Name "+name+" :: Welcome";
	}
	
	@GetMapping("/s2")
	public String f12() {
		return "GET-f12:: Welcome";
	}
	
	@GetMapping("/s1")
	public String f11() {
		return "GET-V1:: Welcome";
	}

	@PostMapping
	public String f2() {
		return "POST:: Welcome";
	}
	
	@PostMapping("/save")
	public Product f21(@RequestBody Product prod) {
		System.out.println(">>>>> "+prod);
		return prod;
	}

	@PutMapping
	public String f3() {
		return "PUT:: Welcome";
	}

	@PatchMapping
	public String f4() {
		return "PATCH:: Welcome";
	}

	@DeleteMapping
	public String f5() {
		return "DELETE:: Welcome";
	}

}
