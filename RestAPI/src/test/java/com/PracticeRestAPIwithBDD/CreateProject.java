package com.PracticeRestAPIwithBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProject {
	
	@Test
	
	public void Create() {
		
		Random random = new Random();
		 int rn= random.nextInt(1000);
		 
		 JSONObject jobr = new JSONObject();
		 jobr.put("createdBy", "Smith");
		 jobr.put("projectName", "Api"+rn);
		 jobr.put("status", "Active");
		 jobr.put("teamSize", 25);
		 
		 given()
		  .contentType(ContentType.JSON)
		  .body(jobr)
		  .when()
		  .post("http://localhost:8084/addProject")
		  .then()
		  .log().all()
		  .assertThat().contentType("application/json")
		  .assertThat().statusCode(201);
		  
		  
	}

}
