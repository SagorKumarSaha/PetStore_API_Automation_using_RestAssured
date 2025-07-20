package api.endpoints;

import static io.restassured.RestAssured.*;
import api.payloads.userPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userEndPoints {
	
	public static Response createUser(userPayload payload) {
		
		Response response=
				(Response)given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
				
				.when()
				.post(routes.post_user);
		
		return response;
		
	}
	
	public static Response getUser(String userName) {
		
		Response response=
				(Response)given()
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				
				.when()
				.get(routes.get_user);
		
		return response;
		
	}

	public static Response updateUser(userPayload payload,String userName) {
	
		Response response=
				(Response)given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)
				.pathParam("username", userName)
				
				.when()
				.put(routes.update_user);
		
		return response;
		
	}
	
	public static Response deleteUser(String userName) {
		
		Response response=
				(Response)given()
				.accept(ContentType.JSON)
				.pathParam("username", userName)
				
				.when()
				.delete(routes.delete_user);
		
		return response;
		
	}
	

}
