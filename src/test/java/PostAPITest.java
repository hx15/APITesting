import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import utils.PostRequestTest;
import utils.PutRequestTest;

public class PostAPITest {
	private String route;
	private String requestBody;
	private  String expectedResponseBody;
	private  String expectedStatusCode;
	private PostRequestTest request;
	public PostAPITest(Object route, String requestBody, String expectedResponseBody, String expectedStatusCode) throws JsonMappingException, NumberFormatException, JsonProcessingException {
		request = new PostRequestTest(route.toString(), requestBody.toString(), expectedResponseBody.toString(), expectedStatusCode.toString());
	}
	
	@Test
	public void Test() {
		assertTrue(this.request.getTestStatus());
	}
}