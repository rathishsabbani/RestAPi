package com.ResponseValidationsStaticDynamic;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.util.List;

public class ValidationofDynamicTest {
	
	
	@Test
	
	public void Dynamic() {
		
		String expecteddata= "Mukeshsir";
		String actualdata= null;
		
		Response response = when()
				.get("http://localhost:8084/projects");
		 response.then()
		 .statusCode(200)
		 .log().all();
		 
	//	 System.out.println(response);
		 
		 List<String> list = response.jsonPath().get("createdBy");
		 System.out.println(list);
		 
		 for(String data:list)
		 {
			 if(data.equals(expecteddata))
			 {
				 System.out.println(data);
				 actualdata=data;
				 System.out.println(actualdata);
				 System.out.println("Vale is presrent in the table:"+actualdata);
				 break;
				 
			 }
		 }
		 
		 Assert.assertEquals(actualdata,expecteddata);
		
	}

}
