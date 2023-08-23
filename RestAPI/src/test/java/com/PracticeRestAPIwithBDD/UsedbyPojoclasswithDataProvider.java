package com.PracticeRestAPIwithBDD;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import project.pojolibrary.ProjectLib;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class UsedbyPojoclasswithDataProvider {
	
	
	@Test(dataProvider="Projectwithprovider")
	
	public void Multipledata(String createdBy,String projectName,String status,int teamSize) {
		
		
		ProjectLib plib = new ProjectLib(createdBy, projectName, status, teamSize);
		
		given()
		
		.contentType(ContentType.JSON)
		.body(plib)
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().contentType("application/json")
		.assertThat().statusCode(201)
		.log().all();
	}
	
	@DataProvider()
	public Object[][] Projectwithprovider()
	{
		
		Random random = new Random();
		int rn = random.nextInt(1000);
		
		
	Object[][] obj = new Object[4][4];
	
	obj[0][0] ="Tony";
	obj[0][1]="Ramkumar"+rn;
	obj[0][2]="Active";
	obj[0][3]=250;
	
	obj[1][0] ="rahim";
	obj[1][1]="kumar"+rn;
	obj[1][2]="Active";
	obj[1][3]=150;
	
	obj[2][0] ="Bhumesh";
	obj[2][1]="Rajkumar"+rn;
	obj[2][2]="Active";
	obj[2][3]=200;
	
	
	obj[3][0] ="Mukeshsir";
	obj[3][1]="Shyamkumar"+rn;
	obj[3][2]="Active";
	obj[3][3]=100;
			
		
				return obj;
		
	}
}
