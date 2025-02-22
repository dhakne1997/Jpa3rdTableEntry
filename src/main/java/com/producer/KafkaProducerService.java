package com.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.entity.Constants;
import com.entity.Department;
import com.entity.Student;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@Service
public class KafkaProducerService {


	@Value("${kafka.topic}")
	private String kafkatopic;
	

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	
	@Autowired
	Gson gson;



	public void sendAccountCreationEvent(Long tableAId, Long tableBId) {
	    try {
	        JsonObject data = new JsonObject();
	        data.addProperty("tableAId", tableAId);
	        data.addProperty("tableBId", tableBId);
	        String json = gson.toJson(data);
	        kafkaTemplate.send(kafkatopic, json.toString());
	        System.out.println("AccountCreation Successful send request");
	    } catch (Exception e) {
	        System.err.println("Error sending account creation event: " + e.getMessage());
	    }
	}



	public void sendStudentDetails(Student student) {
			try {
				kafkaTemplate.send(kafkatopic, gson.toJson(student));
				System.out.println("StudentDetails added Successful send request");
			} catch (Exception e) {
		        System.err.println("Error StudentDetails not added Successful send request: " + e.getMessage());

			}
		}



	public void sendDepartmentDetails(Department department) {
		try {
			kafkaTemplate.send(kafkatopic, gson.toJson(department));
			System.out.println("DepartmentDetails added Successful send request");
		} catch (Exception e) {
	        System.err.println("Error DepartmentDetails not added Successful send request: " + e.getMessage());

		}
		
	}
		
	}

