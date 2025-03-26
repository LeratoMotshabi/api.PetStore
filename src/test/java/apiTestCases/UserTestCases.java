package apiTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.Listeners.Listeners;
import api.Utilities.XLDataProvider;
import apiEnpoints.UserEndPoints;
import apiPayload.User;
import io.restassured.response.Response;

public class UserTestCases {
	
	Faker faker = new Faker();;
	User userPayload = new User();;
	
	
//	public void setupData(String id, String username, String firstName, String lastName, 
//            String email, String password, String phone)
//	{
//		faker = new Faker();
//		userPayload = new User();
//		
//		userPayload.setId(faker.idNumber().hashCode());
//		userPayload.setUsername(faker.name().username());
//		userPayload.setFirstName(faker.name().firstName());
//		userPayload.setLastName(faker.name().lastName());
//		userPayload.setEmail(faker.internet().safeEmailAddress());
//		userPayload.setPassword(faker.internet().password(5,10));
//		userPayload.setPhone(faker.phoneNumber().cellPhone());
//		
//		
//	}
	
	@Test(priority=0,dataProvider="UserData",dataProviderClass=XLDataProvider.class)
	public void testPostUser(String id, String username, String firstName, String lastName, String email, String password, String phone)
	{
		
		userPayload = new User();
		userPayload.setId(Integer.parseInt(id));
		userPayload.setUsername(username);
		userPayload.setFirstName(firstName);
		userPayload.setLastName(lastName);
		userPayload.setEmail(email);
		userPayload.setPassword(password);
		userPayload.setPhone(phone);
		
		Response response =  UserEndPoints.createUser(userPayload);
		response.then().log().all();
		
		
		try {
	        Thread.sleep(4000); // Wait for 1 second, adjust if necessary
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Listeners.test.info("User is created ");
		Listeners.test.info("Status code " + response.getStatusCode());
	}
	
	@Test(priority=1,dataProvider="Usernames",dataProviderClass=XLDataProvider.class)
	public void testGettUserByUsername(String username)
	{
		Response response =  UserEndPoints.readUser(username);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Listeners.test.info("User info is displayed ");
		Listeners.test.info("Status code " + response.getStatusCode());
	}
	
	@Test(priority=2,dataProvider="Usernames",dataProviderClass=XLDataProvider.class)
	public void testUpdateUserByUsername(String username)
	{
		
		
		//userPayload.setId(faker.lorem().characters(4));
		//userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5,10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		
		Response response =  UserEndPoints.updateUser(username, userPayload);
		response.then().log().all();
		
	
		Assert.assertEquals(response.getStatusCode(), 200);
		Listeners.test.info("User info is updated ");
		Listeners.test.info("Status code " + response.getStatusCode());
	
	}
	
	//@Test(priority=3)
	public void testDeleteUserByUsername()
	{
		Response response =  UserEndPoints.deleteUser(this.userPayload.getUsername());
		response.then().log().all();
		
		try {
	        Thread.sleep(4000); // Wait for 1 second, adjust if necessary
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    }
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Listeners.test.info("User info is deleted ");
		Listeners.test.info("Status code " + response.getStatusCode());
	}

}
