/**
 * 
 */
package apiEnpoints;

/**
 * Swagger URI : https://petstore.swagger.io Create user(Post):
 * https://petstore.swagger.io/v2/user/{username} Update user(put) :
 * https://petstore.swagger.io/v2/user/{username} Delete user(delete) :
 * https://petstore.swagger.io/v2/user/{username}
 */
public class Routes {

	// static String baseURI = "https://petstore.swagger.io/v2" ;
	static String baseURI = "https://petstore.swagger.io/v2";

	// user Module
	public static String postUser_url = baseURI + "/user";
	public static String getUser_url = baseURI + "/user/{username}";
	public static String putUser_url = baseURI + "/user/{username}";
	public static String deleteUser_url = baseURI + "/user/{username}";

	// Store Module
	public static String postStore_url = baseURI + "/store/order";
	public static String getStoreOrderID_url = baseURI + "/store/inventory";
	public static String deleteStoreOrderID_url = baseURI + "/store/order/{orderId}";

	// Pet Module

	public static String postPetImage_url = baseURI + "/pet/{petId}/uploadImage";
	public static String postPet_url = baseURI + "/pet";
	public static String getPetByID_url = baseURI + "/pet/{petId}";
	public static String getPetByStatus_url = baseURI + "/pet/findByStatus";
	public static String putPet_url = baseURI + "/pet";
	public static String deletePet_url = baseURI + "/pet/{petId}";

}
