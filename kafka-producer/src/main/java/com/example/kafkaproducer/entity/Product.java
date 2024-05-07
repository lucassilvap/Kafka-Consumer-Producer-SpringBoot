package com.example.kafkaproducer.entity;

public class Product {
	
private String name;
private String message;

public Product(String name, String message) {
	// TODO Auto-generated constructor stub
	this.name = name;
	this.message = message;
}

public Product() {
	
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

}
