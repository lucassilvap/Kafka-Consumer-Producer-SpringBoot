package com.example.kafkaproducer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.kafkaproducer.entity.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaProducer {
	
	 private static final String TOPIC = "nome-do-topico";
	 
	 private ObjectMapper mapper = new ObjectMapper();
	 
	 @Autowired
	 private KafkaTemplate<String, String> kafkaTemplate;

	 public void sendMessage(Product product) throws JsonProcessingException {
	        kafkaTemplate.send(TOPIC, mapper.writeValueAsString(product));
	 }
}
