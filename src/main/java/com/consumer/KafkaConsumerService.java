package com.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.entity.Constants;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;


@Service
public class KafkaConsumerService {@Autowired
	Gson gson;

	@Value("${kafka.topic}")
	private String kafkatopic;


	@KafkaListener(id ="test-consumer-group",topics="account-creation-topic",containerFactory = "kafkaMEContainerFactory")
	public void listenToTopic(ConsumerRecord<String, String> record) {
	    try {
	      
	            String json = record.value();
	            Gson gson = new Gson();
	            JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
	            Long tableAId = jsonObject.get("tableAId").getAsLong();
	            Long tableBId = jsonObject.get("tableBId").getAsLong();
	            
	            System.out.println("Received new account creation event: tableAId=" + tableAId + ", tableBId=" + tableBId);
	      
	    } catch (JsonSyntaxException e) {
	        System.err.println("Error parsing JSON: " + e.getMessage());
	    } catch (NullPointerException e) {
	        System.err.println("Null pointer exception: " + e.getMessage());
	    } catch (Exception e) {
	        System.err.println("Error processing record: " + e.getMessage());
	    } 
	}}
