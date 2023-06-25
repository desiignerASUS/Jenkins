package StepDefinition;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility1.payloadconvertor;
import io.restassured.path.json.JsonPath;

public class booksteps {

	public static String baseURLg = "https://simple-books-api.glitch.me";
	Response response ;
	RequestSpecification requestSpecification ;
	
	public static String Loginpayload;
	public static String Orderpayload;
	public static String token ;
	public static String orderId;
	
	@Given("Login API")
	public void login_api() throws IOException {
		Loginpayload = payloadconvertor.generatePayloadString("login.json");
		System.out.println(Loginpayload);
	}
	
	@When("Login Execute {string} and provide accessToken")
	public void login_execute_and_provide_access_token(String resourcepath) {
		requestSpecification = RestAssured.given().body(Loginpayload) ;
		requestSpecification.contentType(ContentType.JSON) ;
		response =  requestSpecification.post( baseURLg + resourcepath ); 
	}
	
	@Then("Successfully Login with status code {int}")
	public void successfully_login_with_status_code(Integer statusCode) {
		Assert.assertEquals(statusCode, response.getStatusCode());
	}
	
	@Then("Varify accessToken")
	public void varify_access_token() {
		JsonPath js = new JsonPath(response.getBody().asPrettyString());
		token = js.get("accessToken") ;
		System.out.println("Token"+"=>"+token);
	}

// this is for order book
	
	@Given("Login Successfully with accessToken")
	public void login_successfully_with_access_token() throws IOException {
		Orderpayload = payloadconvertor.generatePayloadString("Order.json") ;
		System.out.println(Orderpayload);
	}
	@When("book a order {string} and fetch orderId")
	public void book_a_order_and_fetch_order_id(String orderRs) {
		requestSpecification = RestAssured.given().body(Orderpayload) ;
		requestSpecification.contentType(ContentType.JSON) ;
		requestSpecification.header("Authorization","Bearer "+token);
		response =  requestSpecification.post( baseURLg + orderRs);
	}
	@Then("Varify status code {int}")
	public void varify_status_code(Integer statusCode) {
		Assert.assertEquals(statusCode, response.getStatusCode());
		JsonPath js = new JsonPath(response.getBody().asPrettyString());
		orderId = js.get("orderId");
		System.out.println("OrderID"+"=>"+orderId);
	}

}
