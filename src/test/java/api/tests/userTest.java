package api.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userEndPoints;
import api.payloads.userPayload;
import io.restassured.response.Response;

public class userTest {
	
	userPayload userPayload;
	Faker faker;
	
	@BeforeClass
	public void setup() {
		faker=new Faker();
		userPayload=new userPayload();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setPassword(faker.internet().password(5, 8));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		userPayload.setUsername(faker.name().username());
		userPayload.setUserStatus(0);
		
	}
	
	@Test(priority = 1)
	public void createUser() {
		Response response = userEndPoints.createUser(userPayload);
		
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 2)
	public void getUser() {
		Response response = userEndPoints.getUser(this.userPayload.getUsername());
		
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 3)
	public void UpdateUser() {
		
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setPassword(faker.internet().password(5, 8));
		
		Response response = userEndPoints.updateUser(userPayload, this.userPayload.getUsername());
		
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);
		
		
		Response responseAfterUpdate = userEndPoints.getUser(this.userPayload.getUsername());
		responseAfterUpdate.then().log().all();
		assertEquals(responseAfterUpdate.getStatusCode(), 200);
		
	}
	
	@Test(priority = 4,enabled = false)
	public void deleteUser() {
		
		Response response=userEndPoints.deleteUser(this.userPayload.getUsername());
		
		response.then().log().all();
		assertEquals(response.getStatusCode(), 200);
	}
}
