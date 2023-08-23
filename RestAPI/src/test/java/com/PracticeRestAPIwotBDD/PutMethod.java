package com.PracticeRestAPIwotBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PutMethod {
	
	@Test
	
	public void put() {
		
		
		JSONObject jobs= new JSONObject();
		jobs.put("createdBy","Mukesh");
		jobs.put("projectName","RestAssured");
		jobs.put("teamSize", "25");
		jobs.put("status", "Active");

		 RequestSpecification reqspec=RestAssured.given();
		  
		 reqspec.contentType(ContentType.JSON);
		 reqspec.body(jobs);
		 
		 Response response = reqspec.put("http://localhost:8084/projects/TY_PROJ_602");
		 
		 ValidatableResponse vresp = response.then();
		 vresp.assertThat().statusCode(200);
		 vresp.assertThat().contentType("application/json");
		 vresp.log().all(); 
		 
	}

}
