package DeleteMethod;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteExp {
	
	@Test
	public void DeleteExp1() {
		
		RestAssured.given()
		            
		           .when()
		           .delete("https://reqres.in/api/users/2")
		           .then()
		           .statusCode(204);
		           
		           
		
	}
	
	

}
