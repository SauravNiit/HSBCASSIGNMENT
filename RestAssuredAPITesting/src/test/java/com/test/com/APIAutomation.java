package com.test.com;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIAutomation {
	
	@Test
	 public void GetWeatherDetails()
	 {   
		RestAssured.baseURI ="https://sandbox.xpand-it.com/secure/Dashboard.jspa";
		 RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		 requestParams.put("FirstName", "Saurav"); // Cast
		 requestParams.put("LastName", "Singh");
		 requestParams.put("UserName", "sdimpleuser2dd2011");
		 requestParams.put("Password", "password1");
		 
		 requestParams.put("Email",  "sample2ee26d9@gmail.com");
		 request.body(requestParams.toJSONString());
		 Response response = request.post("/register");
		 
		 int statusCode = response.getStatusCode();
		 Assert.assertEquals(statusCode, "201");
		 String successCode = response.jsonPath().get("SuccessCode");
		 Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
		}
		// Specify the base URL to the RESTful web service
		/*
		 * RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		 * 
		 * // Get the RequestSpecification of the request that you want to sent // to
		 * the server. The server is specified by the BaseURI that we have // specified
		 * in the above step. RequestSpecification httpRequest = RestAssured.given(); //
		 * Make a request to the server by specifying the method Type and the method
		 * URL. // This will return the Response from the server. Store the response in
		 * a variable Response response = httpRequest.request(Method.GET, "/Hyderabad");
		 * // Now let us print the body of the message to see what response // we have
		 * recieved from the server String responseBody = response.getBody().asString();
		 * System.out.println("Response Body is =>  " + responseBody);
		 * 
		 * //status code int statusCode = response.getStatusCode();
		 * System.out.println("status code is:" + statusCode);
		 * Assert.assertEquals(statusCode, 200);
		 * 
		 * //status line verification String statusLine = response.getStatusLine();
		 * System.out.println("Status Line is:" + statusLine);
		 * Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		 */
}
