package utils;

import io.restassured.RestAssured;
import io.restassured.internal.path.json.JsonPrettifier;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.internal.path.json.JsonPrettifier;
public class DeleteRequestTest extends RequestTest{
	int responseCode;
	String responseBody;
	boolean testStatus = true;
	public DeleteRequestTest(String route, String requestBody, String expectedResponseBody, String expectedStatusCode) {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com" + route.replaceAll("\"", ""); 
		Response response = RestAssured.delete(RestAssured.baseURI); 
		ResponseBody body = response.getBody();
		this.responseCode =  response.getStatusCode();
		this.responseBody = body.asPrettyString();
		this.testStatus = (this.responseCode == Integer.parseInt(expectedStatusCode));
	}
	
	public Boolean getTestStatus() {
		return testStatus;
	}
}
