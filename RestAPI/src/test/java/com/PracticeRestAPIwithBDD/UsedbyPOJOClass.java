package com.PracticeRestAPIwithBDD;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import project.pojolibrary.ProjectLib;
import static io.restassured.RestAssured.*;

public class UsedbyPOJOClass {

	@Test
	
	public void Pojoclass() {
		
		Random random = new Random();
		int rn = random.nextInt(1000);
		
		ProjectLib plibs = new ProjectLib("Mukesh", "Testyantra"+rn, "Active", 20);
		given()
		.contentType(ContentType.JSON)
		.body(plibs)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().contentType("application/json")
		.assertThat().statusCode(201)
		.log().all();
		
	}
	
	
	
	
	
}
