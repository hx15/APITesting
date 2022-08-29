import java.io.File;
import java.io.IOException;

import org.testng.annotations.Factory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
 
public class TestFactory {
	@Factory
	public Object[] FactoryMethod() {
		Object[] data = null;
		try {
			File jsonFile = new File("./data.json").getAbsoluteFile();
			JsonNode jsonNode = new ObjectMapper().readTree(jsonFile);
			data = new Object[jsonNode.size()];
			int testIdx = 0;
			for(JsonNode node: jsonNode) {
				JsonNode expectedResponseBody = node.get("expectedResponseBody");
				JsonNode requestedBody = node.get("requestedBody");
				JsonNode requestType = node.get("requestType");
				JsonNode route = node.get("route");
				JsonNode expectedStatusCode = node.get("expectedStatusCode");
				if(node.get("requestType").toString().replaceAll("\"", "").equals("POST")) {
					data[testIdx] = new PostAPITest(route.toString(), requestedBody.toString(), expectedResponseBody.toString(), expectedStatusCode.toString());
				} else if (node.get("requestType").toString().replaceAll("\"", "").equals("PUT")) {
					data[testIdx] = new PutAPITest(route.toString().replaceAll("\"", ""), requestedBody.toString(), expectedResponseBody.toString(), expectedStatusCode.toString());
				} else if (node.get("requestType").toString().replaceAll("\"", "").equals("DELETE")) {
					data[testIdx] = new DeleteAPITest(route.toString(),requestedBody.toString(), expectedStatusCode.toString());
				}
				testIdx++;
				System.out.println("Hello");
			}
			return data;
		} catch(IOException e) {
			System.out.println(e);
		}
		return data;
	}
	
}
