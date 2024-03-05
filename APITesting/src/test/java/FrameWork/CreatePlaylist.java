package FrameWork;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.spotyfy.Playlist;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class CreatePlaylist {
	RequestSpecification requestspecification=null;
	ResponseSpecification responsespecification=null;
	
	String accesstoken="BQCq4UKZBT2Izl_b0wD3emkaEQPAhPlHgIM4TiepCkAPXPYLSB7djpYZnCZ_uBBEasOsEjnPQERdszI95F-MhVuSRcQR6KZdTpFR8Zbs59sj9NgmPcclhsrXRWfbU_NUAhzZ0fwteLS3u3JyzG0_d8ZS04Mb9EDLz55-mKDm-gN0sYdeGprtWQikyY7Tlt7Zo0Hc4EKG3epj9IILpyyML2X84Dyg6khKUwRYcwv8ScR7xagIB1tdWkVIabCQGOlV07Bt0BOxo6JFdg";
	
	@BeforeClass
	public void beforeclass() {
		
		RequestSpecBuilder requestspecificbuilder=new RequestSpecBuilder();
		requestspecificbuilder.setBaseUri("https://api.spotify.com");
		requestspecificbuilder.setBasePath("/v1");
		requestspecificbuilder.addHeader("Authorization", "Bearer " +accesstoken);
		requestspecificbuilder.setContentType(ContentType.JSON);
		requestspecificbuilder.log(LogDetail.ALL);
		requestspecification=requestspecificbuilder.build();
		
		ResponseSpecBuilder  responseBuilder=new ResponseSpecBuilder();
		responseBuilder.log(LogDetail.ALL);
		responsespecification=responseBuilder.build();
		
	}
	
		@Test(enabled = true)
		public void createplaylist() {
			
			Playlist payLoad=new Playlist();
			payLoad.setName("Mis");
			payLoad.setDescription("Mis playlist description");
			payLoad.setPublic(false);
			
			RestAssured.given().
		    spec(requestspecification).
			
			body(payLoad).
			
            pathParam("userid", "31lfw43kpdwspppzj2hm7hajnncu").
			when().
			post("/users/{userid}/playlists").
			then().spec(responsespecification).
			assertThat().
			statusCode(201).
			body("name", Matchers.equalTo("Mis"));
			
			
	}
		
		
		@Test(enabled =false)
		public void Getplaylist() {
			
		
			RestAssured.given().
		    spec(requestspecification).
			
            pathParam("userid", "3cEYpjA9oz9GiPac4AsH4n").
			when().
			get("/playlists/{userid}").
			then().spec(responsespecification).
			assertThat().
			statusCode(200).
			body("name", Matchers.equalTo("Spotify Web API Testing playlist"));
			
			
	}

}
