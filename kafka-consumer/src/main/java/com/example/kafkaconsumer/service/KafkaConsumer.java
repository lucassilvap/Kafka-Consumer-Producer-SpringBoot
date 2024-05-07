package com.example.kafkaconsumer.service;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.example.kafkaproducer.entity.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KafkaConsumer {
	
	private ObjectMapper mapper = new ObjectMapper();
	
	 @KafkaListener(topics = "nome-do-topico", groupId = "group_id")
	    public void consume(String message) {
	        System.out.println("Mensagem recebida: " + message);
	        try {
				Product product = mapper.readValue(message, Product.class);
				System.out.println("O nome do objeto é: " + product.getName());
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 }
}
