package com.example.kafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkaproducer.entity.Product;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class ProducerController {
	
	@Autowired
	private com.example.kafkaproducer.service.KafkaProducer kafkaProducer;
	
    @GetMapping() 
    public ResponseEntity<?> entity(@RequestBody Product product){
    	try {
			kafkaProducer.sendMessage(product);
		} catch (JsonProcessingException e) {
			return ResponseEntity.ok("error");
		}
    	return ResponseEntity.ok("ok");
	}

}
