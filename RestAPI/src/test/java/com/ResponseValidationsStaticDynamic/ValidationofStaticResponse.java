package com.ResponseValidationsStaticDynamic;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class ValidationofStaticResponse {
	
	
	@Test
	
	public void Staticresponse()
	{
		
		String externalname= "Rathish772";
		
		Response response =  when()
				.get("http://localhost:8084/projects");
		response.then()
		.assertThat()
		.statusCode(200)
		.log().all();
		
		String stats = response.jsonPath().getString("[01].createdBy");
		
		System.out.println("Expected result:"+externalname);
		System.out.println("Actual resuls:"+stats);
		Assert.assertEquals(stats,externalname );
		
		
	}

}
