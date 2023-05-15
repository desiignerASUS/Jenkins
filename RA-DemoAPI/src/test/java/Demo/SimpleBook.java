package Demo;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class SimpleBook {
	
//	public will create variable that we can use in all packages
	public static String baseURL = "https://simple-books-api.glitch.me" ;
	
//	public static   String[] names = {"John", "Mary", "Adam", "Emma", "Oliver", "Ava", "Sophia"};
//	public static   String[] domains = {"example.com", "test.com", "example.org", "test.org"};
//	public static  Random rand = new Random();
//	public static  String name = names[rand.nextInt(names.length)];
//	public static   String email = name.toLowerCase() + "@" + domains[rand.nextInt(domains.length)];

	public static String token ;
	public static String id ;

	
//	given : request => url, body, querypara, headers 
//	when : resource => /user , /board
//	then : response => Assertion - stringFormet - jsonPath
	@Test(priority = 0)
	public void authentication() {
		
		String jsonBody = "{\r\n"
				+ "   \"clientName\": \"prabha55\",\r\n"
				+ "   \"clientEmail\": \"productnagfddme12113@example.com\"\r\n"
				+ "}" ;
		
		RestAssured.baseURI = baseURL ;
		
	    Response response = 	given()
		 .header("Content-Type" , "application/json" )
		 .body(jsonBody)
		.when()
		 .post("/api-clients/")
		
		.then()
		 .assertThat()
		  .statusCode(201)
		  .contentType(ContentType.JSON) 
		.extract().response() ;
	
	String result = response.asPrettyString() ;
	System.out.println(result);
	
	JsonPath js = new JsonPath(result);
	 token = js.get("accessToken") ;
	System.out.println(token);
	}
	
	
	@Test(priority = 1)
	public void OrderBookToken() {
		
		String jsonBody = "{\r\n"
				+ "  \"bookId\": 1,\r\n"
				+ "  \"customerName\": \"Hinataa-kunn\"\r\n"
				+ "}" ;
		RestAssured.baseURI = baseURL ;
		
	    Response response = 	given()
		 .header("Content-Type" , "application/json" )
		 .header("Authorization", token)
		 .body(jsonBody)
		.when()
		 .post("/orders")
		
		.then()
		 .assertThat()
		  .statusCode(201)
		  .contentType(ContentType.JSON) 
		.extract().response() ;
	
	String result = response.asPrettyString() ;
	System.out.println(result);
	
	
	
	JsonPath js = new JsonPath(result);
	 id = js.get("orderId") ;
	System.out.println(id);
	}
	
	@Test(priority = 2)
	public void updateBookName() {
		
		String jsonBody = "{\r\n"
				+ "  \"customerName\": \"Gangadhar is Shaktiman \"\r\n"
				+ "}" ;
		
		RestAssured.baseURI = baseURL ;
		
	    Response response = 	given()
		 .header("Content-Type" , "application/json" )
		 .header("Authorization", token)
		 .body(jsonBody)
		.when()
		 .patch("/orders/" + id)
		
		.then()
		 .assertThat()
		  .statusCode(204)
		.extract().response() ;
	
	String result = response.asPrettyString() ;
	System.out.println(result);

	}	
	
	@Test(priority = 3)
	public void getBookDetails() {
		
		
		RestAssured.baseURI = baseURL ;
		
	    Response response = 	given()
		 .header("Content-Type" , "application/json" )
		 .header("Authorization", token)
		 
		.when()
		 .get("/orders/" + id)
		
		.then()
		 .assertThat()
		  .statusCode(200)
		  .contentType(ContentType.JSON) 
		.extract().response() ;
	
	String result = response.asPrettyString() ;
	System.out.println(result);
	
	JsonPath js = new JsonPath(result);
	String cname = js.get("customerName") ;
	assertEquals( cname,"Gangadhar is Shaktiman " );
	System.out.println(cname);
	}
	
	@Test(priority = 4)
	public void deleteBook() {
		
		
		RestAssured.baseURI = baseURL ;
		
	    Response response = 	given()
		 .header("Content-Type" , "application/json" )
		 .header("Authorization", token)
		 
		.when()
		 .delete("/orders/" + id)
		
		.then()
		 .assertThat()
		  .statusCode(204)
		.extract().response() ;
	
	String result = response.asPrettyString() ;
	System.out.println(result);
	
	}
	
}
