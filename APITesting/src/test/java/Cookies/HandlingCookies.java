package Cookies;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class HandlingCookies {
	
	@Test
	public void cookies() {
		
		RestAssured
		.given()
		.when()
		  .get("https://www.google.com/")
		.then()
		   .cookie("AEC","Ae3NU9MTLuxSFkCrX9ITWoFK-FXXEXPrNFnowqZ9czsABaHO9hudVgHwzg")
		   .log().all();
		
		
		
		
	}

}
