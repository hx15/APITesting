package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import io.restassured.RestAssured;
import io.restassured.internal.path.json.JsonPrettifier;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.internal.path.json.JsonPrettifier;
public class PutRequestTest extends RequestTest{
	int responseCode;
	String responseBody;
	boolean testStatus = true;
	public PutRequestTest(String route, String requestBody, String expectedResponseBody, String expectedStatusCode) throws JsonMappingException, NumberFormatException, JsonProcessingException {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com" + route.replaceAll("\"", ""); 
		RequestSpecification request = RestAssured.given().body(requestBody); 
		request.header("Content-Type", "application/json"); 
		Response response = request.put(); 
		ResponseBody body = response.getBody();
		this.responseCode =  response.getStatusCode();
		this.responseBody = body.asPrettyString();
		this.testStatus = (this.responseCode == Integer.parseInt(expectedStatusCode) && CommonMethods.compareBodies(expectedResponseBody, body.asString()));
	}

	public Boolean getTestStatus() {
		return testStatus;
	}
}
