package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.*;
//import com.aventstack.extentreports.util.Assert;
import com.github.javafaker.Faker;
import api.endpoints.UserEndPoints;
import api.payload.User;

public class UserTest {
		
	User userPayload= new User();
	Faker faker= new Faker();
	
	@BeforeClass
	public void setUpData() {
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
	}
	
	@Test
	public void testPostUser() {
		
		Response response=UserEndPoints.CreateUser(userPayload);
		//System.out.println(response.getBody().asString());
		Assert.assertEquals(response.getStatusCode(),200);
		
	}
	

}
