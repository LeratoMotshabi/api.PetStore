
package apiEnpoints;
import static io.restassured.RestAssured.*;

import java.util.ResourceBundle;

import apiPayload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

/**
 * 
 */
public class UserEndPoints {
	
	public static ResourceBundle getURL()
	{
		ResourceBundle bundle = ResourceBundle.getBundle("routes");
		return bundle;
	}
	
	public static Response createUser(User payload)
	{
		//String postURL = getURL().getString("postUser_url");
		Response response = 
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(payload).
		when().
		post(Routes.postUser_url);
		return response;
	}
	
	public static Response readUser(String username)
	{
		Response response = 
				given().
				pathParam("username", username).		
				when().
				get(Routes.getUser_url);
				return response;
	}
	
	public static Response updateUser(String username,User payload)
	{
		Response response = 
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		pathParam("username", username).
		body(payload).		
		when().put(Routes.putUser_url);
		return response;
	}
	
	public static Response deleteUser(String username)
	{
		Response response = 
				given().
				pathParam("username", username).		
				when().
				delete(Routes.deleteUser_url);
				return response;
	}

}
