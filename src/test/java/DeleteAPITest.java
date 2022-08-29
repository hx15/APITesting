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
import utils.DeleteRequestTest;
import utils.DeleteRequestTest;
public class DeleteAPITest {
	private String route;
	private String requestBody;
	private  String expectedResponseBody;
	private  String expectedStatusCode;
	private DeleteRequestTest request;
	public DeleteAPITest(Object route, String requestBody, String expectedStatusCode) throws JsonMappingException, NumberFormatException, JsonProcessingException {
		request = new DeleteRequestTest(route.toString(), requestBody.toString(), expectedStatusCode.toString());
	}
	@Test
	public void Test() {
		assertTrue(this.request.getTestStatus());
	}
}
