package apiEnpoints;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndPoints {
	
	
	public Response createStore(String store)
	{
		Response response = given().
				contentType(ContentType.JSON).
				accept(ContentType.JSON).body(store).
				when().
				post(Routes.postStore_url);
		return response;
	}
	
	public Response readStore(int ID)
	{
		Response response = given().
				pathParam("orderId", ID).
				when().
				get(Routes.getStoreOrderID_url);
		return response;
	}
	
	public Response deleteStore(int ID)
	{
		Response response = given().
				pathParam("orderId", ID).
				when().
				delete(Routes.deleteStoreOrderID_url);
		return response;
	}

}
