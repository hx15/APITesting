package utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
	public PostRequestTest(String route, String requestBody, String expectedResponseBody, String expectedStatusCode) throws JsonMappingException, JsonProcessingException {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com" + route.replaceAll("\"", ""); 
		RequestSpecification request = RestAssured.given().body(requestBody); 
		request.header("Content-Type", "application/json"); 
		Response response = request.post(); 
		ResponseBody body = response.getBody();
		this.responseCode =  response.getStatusCode();
		this.testStatus = (this.responseCode == Integer.parseInt(expectedStatusCode) && CommonMethods.compareBodies(expectedResponseBody, body.asString()));
		//System.out.println("Expected Response body: \n" +  JsonPrettifier.prettifyJson(expectedResponseBody));
		//System.out.println("Actual response body: \n" + this.responseBody);
		
	}
	
	public Boolean getTestStatus() {
		return testStatus;
	}
}
