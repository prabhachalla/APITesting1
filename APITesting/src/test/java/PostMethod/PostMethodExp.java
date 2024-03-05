package PostMethod;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

/* 
 Different ways to create post request body
 1. post request body using Hashmap
 2. post request body using org.JSON
 3. post request body using POJO Class
 4. post request using external json file data
 */

public class PostMethodExp {
	
	//@Test(priority = 1)
	  public void Hashmap() {
		Map<String, Object> data=new HashMap<>();
		data.put("name", "prabhakar");
		data.put("job", "Lead");
		
		
		RestAssured.
		given()
		   .contentType(ContentType.JSON)
		   .body(data)
		.when()
		   .post("https://reqres.in/api/users")
		.then()
		  .statusCode(201)
		  .log().all();
		  
		  }
	  @Test
	  public void Jsonformate() {
			Map<String, Object> data=new HashMap<>();
			data.put("name", "prabhakar");
			data.put("job", "Lead");
			
			
			RestAssured.
			given()
			   .contentType(ContentType.JSON)
			   .body(data)
			.when()
			   .post("https://reqres.in/api/users")
			.then()
			  .statusCode(201)
			  .log().all();
			  
			  }
	
	@Test
	public void Deleteid() {
		
		RestAssured
		.given()
		.when()
		  .delete("https://reqres.in/api/users/753")
		.then()
		 .statusCode(204);
		
		
		
	}
	
	
	
	
	
	

}
