package JsonSchema;

import java.io.File;

import org.testng.annotations.Test;

import com.jayway.restassured.module.jsv.JsonSchemaValidator;

import io.restassured.RestAssured;

public class JsonSchemaValidation {
	

	@Test
	public void jsonschemavalidation() {
		RestAssured.given()
		           .when()
		           .get("https://reqres.in/api/users?page=2")
		           .then()
		           .assertThat()
		           .body(JsonSchemaValidator.matchesJsonSchema(new File("D:\\Selenium_Automation\\APITesting\\src\\test\\java\\schema\\Schema.json")));
		           

		 
		
		
	}

}
