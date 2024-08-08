package com.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.errors.SerializationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.entity.Department;
import com.entity.Student;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;


@Service
public class KafkaConsumerService {@Autowired
	Gson gson;

	@Value("${kafka.topic}")
	private String kafkatopic;


	@KafkaListener(id ="my-project-topic-group0",topics="my-project-topic",containerFactory = "kafkaMEContainerFactory")
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
	}
	
	
	@KafkaListener(id ="my-project-topic-group1",topics="my-project-topic",containerFactory = "kafkaMEContainerFactory")
	public void listenToTopic1(ConsumerRecord<String, String> record) {
        try {
        	System.out.println(record.value());
            String student = record.value(); 
             Student stud=gson.fromJson(student, Student.class);
            System.out.println("The  message received for student: " + student.toString());
        } catch (SerializationException e) {
            System.err.println("Error deserializing message: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error processing message: " + e.getMessage());
        }
    }

	
	@KafkaListener(id ="my-project-topic-group2",topics="my-project-topic",containerFactory = "kafkaMEContainerFactory")
	public void listenToTopic2(ConsumerRecord<String, String> record) {
        try {
        	System.out.println(record.value());
            String department = record.value(); 
            Department depar=gson.fromJson(department, Department.class);
            System.out.println("The  message received for department: " + department.toString());
        } catch (SerializationException e) {
            System.err.println("Error deserializing message: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error processing message: " + e.getMessage());
        }
    }

}
