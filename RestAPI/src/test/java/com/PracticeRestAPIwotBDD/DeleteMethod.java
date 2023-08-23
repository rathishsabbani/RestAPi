package com.PracticeRestAPIwotBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteMethod {

	@Test
	public void Delete() {
		
		Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_604");
		
		
		 ValidatableResponse vresp = response.then();
		 vresp.assertThat().contentType("application/json");
		  vresp.assertThat().statusCode(204); 
		  vresp.log().all();
		   
	}
}
