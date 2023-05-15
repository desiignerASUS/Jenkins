package Demo;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TrelloAPI {
   //test all end-point of Trello
   //i am creating BaseURL because it is common to all the end points
   public static String baseURL = "https://api.trello.com";
   public static String key = "5a63bb5325f2e91d281ba900285f64aa";
   public static String token = "ATTA05baf76f193d8acc360cc0a293f9043c9f8e2f0a8470c46b40cc43a1cc07ae0f13CEB333";
   public static String id;
   public static String requestBody = "{ \"name\": \"Desiigner\", \"desc\": \"Testing using resAssured\" }";
   
   @Test(priority = 0)
   public void CreateBoard() {
	   //Rest-Assured will work with below aspect
	   //given: request- contains,body,headers-authorization-content-type,qweryparameter
	   //when : resource / board (this will have only resource)
	   //then : response - assertion - string format --jsonpath()
	   
	   //this is to pass my baseURL
	   RestAssured.baseURI = baseURL;
	   
	   //Pre-condition
	   Response response = 	given().queryParam("name", "Prabhatjain")
	   .queryParam("key",key)
	   .queryParam("token",token)
	   .header("Content-Type","application/json")
	   
	   .when()
	   .post("1/boards")
	   
	   .then()
	   .assertThat().statusCode(200).contentType(ContentType.JSON)
	   .extract().response();
	   
		//below code will be get response in the string format and store it in jsonresponce var   
		String jsonresponse = response.asString();
		//this should print entire response
		System.out.println(jsonresponse);
		//the Below code will convert my entire response in the json object
		JsonPath js = new JsonPath(jsonresponse);
		//this is to fetch the specafic object
		id=js.get("id");
		System.out.println(id);   
   }
   
   @Test(priority=1)
	public void UpdateBoard() {
		
		RestAssured.baseURI=baseURL;
				Response 	response = given()
				
				.queryParam("key",key)
				.queryParam("token",token)
	
				.header("Content-Type","application/json")
               .body(requestBody)
               .when()
               .put("1/boards/{id}",id)
               .then()
               .assertThat().statusCode(200).contentType(ContentType.JSON)
               .extract().response();
				String jsonresponse=response.asString();
       		System.out.println(jsonresponse);
		
	}
   
   @Test(priority=2)
	public void GetBoard() {
		
		RestAssured.baseURI=baseURL;
				Response 	response = given()
				
				.queryParam("key",key)
				.queryParam("token",token)
	
				.header("Content-Type","application/json")
    
              .when()
              .get("1/boards/{id}",id)
              .then()
              .assertThat().statusCode(200).contentType(ContentType.JSON)
              .extract().response();
				String jsonresponse=response.asString();
      		System.out.println(jsonresponse);
		
	}
   
   @Test(priority=3)
	public void DeleteBoard() {
		
		RestAssured.baseURI=baseURL;
				Response 	response = given()
				
				.queryParam("key",key)
				.queryParam("token",token)
	
				.header("Content-Type","application/json")
   
             .when()
             .delete("1/boards/{id}",id)
             .then()
             .assertThat().statusCode(200).contentType(ContentType.JSON)
             .extract().response();
				String jsonresponse=response.asString();
     		System.out.println(jsonresponse);
		
	}
   
}
