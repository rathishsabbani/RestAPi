package com.PracticeRestAPIwotBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import io.restassured.specification.RequestSpecification;

public class PostMethod {

	@Test
	
	public void postcreate() {
		
		Random random = new Random();
		 int rn = random.nextInt(1000);
		 
		 JSONObject jobk = new JSONObject();
		 jobk.put("createdBy","Offline Batch");
		 jobk.put("projectName","Harish"+rn);
		 jobk.put("status", "Starting");
		 jobk.put("teamSize", 20);
		 
		 
		 RequestSpecification req = RestAssured.given();
		  req.contentType(ContentType.JSON);
		  req.body(jobk);
		  
		  Response res = req.post("http://localhost:8084/addProject");
		  
		  ValidatableResponse resp = res.then();
		  resp.assertThat().contentType("application/json");
		  resp.assertThat().statusCode(201);
		  resp.log().all();
		  
		  
		 
		 
		 
		 
		 
	}
}
