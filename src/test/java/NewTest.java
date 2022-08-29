import static org.testng.Assert.assertTrue;

import java.io.File;
import io.restassured.*;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import utils.PostRequestTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Paths;
import java.util.Map;
import utils.PostRequestTest;
import org.testng.annotations.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.fasterxml.jackson.core.TreeCodec.*;
import com.fasterxml.jackson.core.ObjectCodec.*;
import com.fasterxml.jackson.databind.*;
public class NewTest {
	
	@BeforeClass
	public static void Initialize() {
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
	}
	@DataProvider (name = "TestCasesProvider")
	public Object[][] ProviderMethod(){
		Object[][] res;
		try {
			File jsonFile = new File("./data.json").getAbsoluteFile();
			JsonNode jsonNode = new ObjectMapper().readTree(jsonFile);
			res = new Object[jsonNode.size()][5];
			int i = 0;
			for(JsonNode node: jsonNode) {
				res[i][0] = node.get("expectedResponseBody");
				res[i][1] = node.get("requestedBody");
				res[i][2] = node.get("requestType");
				res[i][3] = node.get("route");
				res[i][4] = node.get("expectedStatusCode");
				i++;
			}
			return res;
		} catch(IOException e) {
			System.out.println(e);
		}
		return null;
	}
	@Test (dataProvider = "TestCasesProvider")
  public void APITesting(Object expectedResBody, Object requestBody, Object requestType, Object route, Object expectedStatusCode) throws JsonIOException, JsonSyntaxException, IOException {
		PostRequestTest postTest = new PostRequestTest (route.toString(), requestBody.toString(), expectedResBody.toString(), expectedStatusCode.toString());
		assertTrue(postTest.getTestStatus());
  }
}