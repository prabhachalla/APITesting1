package DataDrivenTesting;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DatadrivenTestingExp {
	
	@Test
	public void post() {
		
		String excelPath="D:\\Selenium_Automation\\APITesting\\data\\TestData.xlsx";
		String sheetName="Sheet1";
		ExcelUtils excel=new ExcelUtils(excelPath,sheetName);
		
		JSONObject request=new JSONObject();
		request.put("name", excel.getCellData(1, 0));
		request.put("job", excel.getCellData(1, 1));
		
		 RestAssured.given().body(request).when().
				put( "https://reqres.in/api/users").then().extract().response();
		
	
		
		
	}

}
