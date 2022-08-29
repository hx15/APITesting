package utils;

import io.restassured.RestAssured;
import io.restassured.internal.path.json.JsonPrettifier;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.internal.path.json.JsonPrettifier;
public class PostRequestTest extends RequestTest{
	int responseCode;
	String responseBody;
	boolean testStatus = true;
	public PostRequestTest(String route, String requestBody, String expectedResponseBody, String expectedStatusCode) {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com" + route.replaceAll("\"", ""); 
		RequestSpecification request = RestAssured.given().body(requestBody); 
		request.header("Content-Type", "application/json"); 
		Response response = request.post(); 
		ResponseBody body = response.getBody();
		this.responseCode =  response.getStatusCode();
		this.responseBody = body.asPrettyString();
		//System.out.println(this.responseCode);
		//System.out.println(expectedStatusCode);
		this.testStatus = (this.responseCode == Integer.parseInt(expectedStatusCode));
		//this.testStatus = this.testStatus && (JsonPrettifier.prettifyJson(expectedResponseBody) == body.asPrettyString());
		//System.out.println("Expected Response body: \n" +  JsonPrettifier.prettifyJson(expectedResponseBody));
		//System.out.println("Actual response body: \n" + this.responseBody);
		
	}
	
	public Boolean getTestStatus() {
		return testStatus;
	}
}
