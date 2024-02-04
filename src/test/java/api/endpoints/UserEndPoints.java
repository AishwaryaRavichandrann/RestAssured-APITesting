package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.response.*;

public class UserEndPoints {
	
	// CRUD - Create , Read, Update and Delete Operation
	
	public static Response CreateUser(User payload) {
		
		Response response=given()
			
			.contentType("application/json")
			.accept("application/json")
			.body(payload)
			
		.when()
			.post(Routes.post_URL);
		
		
		return response;
		
	}
	
	public static Response ReadUser(String userName) {
		
		Response response=given()
			.accept("application/json")
			.pathParam("username",userName)
			
			
		.when()
			.get(Routes.get_URL);
		
		
		return response;
		
	}
	
    public static Response UpdateUser(User payload, String userName) {
		
		Response response=given()
			.accept("application/json")
			.contentType("application/json")
			.pathParam("username",userName)
			.body(payload)
			
			
		.when()
			.put(Routes.put_URL);
		
		
		return response;
		
	}
    
    public static Response DeleteUser(String userName) {
		
		Response response=given()
			.accept("application/json")
			.pathParam("username",userName)
						
			
		.when()
			.delete(Routes.delete_URL);
		
		
		return response;
		
	}
	
	

}
