package MavenProject.APIReusable;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class RequestMethods {

	private static String requestBody = "{\n" + "  \"title\": \"foo\",\n" + "  \"body\": \"bar\",\n"
			+ "  \"userId\": \"1\" \n}";

	public Response postRequest() {
		Response response = given().header("Content-type", "application/json")
				.header("authorization", "Bearer 0431655cfe7ba40a791e0ce32d83ad33363348919c11627f409a3228f205e19f")
				.and().body(requestBody).when().post("/posts").then().extract().response();

//	        Assertions.assertEquals(201, response.statusCode());
//	        Assertions.assertEquals("foo", response.jsonPath().getString("title"));
//	        Assertions.assertEquals("bar", response.jsonPath().getString("body"));
//	        Assertions.assertEquals("1", response.jsonPath().getString("userId"));
//	        Assertions.assertEquals("101", response.jsonPath().getString("id"));
		return response;
	}

	public Response getTest() {

		/*
		 * given application is up and running and performing the GET request with
		 * get(URL) and printing the response
		 *
		 */
		Response response = given()
				.header("authorization", "Bearer 0431655cfe7ba40a791e0ce32d83ad33363348919c11627f409a3228f205e19f")
				.when().get("https://gorest.co.in/public-api/users");

		// Printing the response
		return response;
	}

	public String getStatusCode()
	    {
	    	Response response=getTest();
	    	int status=response.statusCode();
	    	if(status==404)
	    	{
	    		return "the URL is not recognized";
	    	}
	    	else if(status==500)
	    	{
	    		return "Internal Server Error";
	    	}
	    	else if(status==401)
	    	{
	    		return "Unauthorized Access";
	    	}
	    	return "Get Successfully";
	    }

}
