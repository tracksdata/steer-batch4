package com.xoriant.ecart.model;

public class Product {

	private int id;
	private String name;
	private double salary;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

}
