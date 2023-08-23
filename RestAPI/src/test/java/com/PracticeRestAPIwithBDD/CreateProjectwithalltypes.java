package com.PracticeRestAPIwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;

public class CreateProjectwithalltypes
{
   @Test
   
   public void createproject()
   {
	Random random=  new Random(); 
	   int rn=random.nextInt(2000);
	JSONObject jobj = new JSONObject();
	   
	jobj.put("createdBy", "Manual Batch" );
	jobj.put("projectName","Azure Devops"+rn);
	jobj.put("status", "started");
	jobj.put("teamSize", 50);
	   
	 given()
	 .contentType(ContentType.JSON)
	   .body(jobj)
	   .when()
	   .post("http://localhost:8084/addProject")
	   .then()
	   .log().all()
	   .assertThat().statusCode(201)
	   .assertThat().contentType("application/json");
	   		 
	   
   }
   
  @Test
  
  public void Hashmap() {
	  
	  Random ran = new Random();
	  int rm = ran.nextInt(1000);
	  
	  HashMap map = new HashMap();
	  map.put("createdBy", "michel");
	  map.put("projectName","Postman"+rm);
	  map.put("status","Active" );
	  map.put("teamSize", 50);
	  
	  
	  given()
	  .contentType(ContentType.JSON)
	  .body(map)
	  .when()
	  .post("http://localhost:8084/addProject")
	  .then()
	  .assertThat().contentType("application/json")
	  .assertThat().statusCode(201)
	  .log().all();
	  
	  
  }
  
  
  @Test
  
  public void Treemap() {
	  
	  Random rand = new Random();
	  int rs = rand.nextInt(1000);
	  
	  
	  TreeMap tree = new TreeMap();
	  
	  tree.put("createdBy", "Swapna");
	  tree.put("projectName", "Automation"+rs);
	  tree.put("status", "Running");
	  tree.put("teamSize", 500);
	  
	  
	  given()
	  .contentType(ContentType.JSON)
	  .body(tree)
	  .when()
	  .post("http://localhost:8084/addProject")
	  .then()
	  .assertThat().contentType("application/json")
	  .assertThat().statusCode(201)
	  .log().all();
	  
	  
	  
  }
  
  
  @Test
  
  public void usingJsonfile()
  {
	  
	  File files = new File("./BinaryFiledata.json");
	  
	  given()
	  .contentType(ContentType.JSON)
	  .body(files)
	  .when()
	  .post("http://localhost:8084/addProject")
	  .then()
	  .assertThat().contentType("application/json")
	  .assertThat().statusCode(201)
	  .log().all();
  }
  
}


