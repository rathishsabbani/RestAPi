package com.PracticeRestAPIwotBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetMenthod {
	
	@Test
	
	public void getresponse(){
		
		
		//Login to swagger application
		Response response = RestAssured.get("http://localhost:8084/projects");
		
		int actualstatuscode= response.getStatusCode();
		
		//int expectedstatuscode =response.getStatusCode();

		Assert.assertEquals(actualstatuscode, 200);
		
		// Validate the data
		
		ValidatableResponse vr = response.then();
		vr.assertThat().statusCode(actualstatuscode);
		vr.assertThat().contentType("application/json");
		vr.log().all();
		
		//Response from swagger
		
		System.out.println(response.contentType());
		System.out.println(response.statusCode());
		System.out.println(response.getTime());
		System.out.println(actualstatuscode);
		
		
		
		
	}
	


}
