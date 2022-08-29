import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import utils.PutRequestTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import utils.CommonMethods;

public class PutAPITest {
	private String route;
	private String requestBody;
	private  String expectedResponseBody;
	private  String expectedStatusCode;
	private PutRequestTest request;
	public PutAPITest(Object route, String requestBody, String expectedResponseBody, String expectedStatusCode) throws JsonMappingException, NumberFormatException, JsonProcessingException {
		request = new PutRequestTest(route.toString(), requestBody.toString(), expectedResponseBody.toString(), expectedStatusCode.toString());
	}
	
	@Test
	public void Test() {
		assertTrue(this.request.getTestStatus());
	}
}
