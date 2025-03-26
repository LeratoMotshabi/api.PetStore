package apiTestCases;

import com.github.javafaker.Faker;

import apiPayload.Store;

public class StoreTestCases {
	
	Faker faker = new Faker();
	Store storePayload = new Store();
	
	public void dataSetup()
	{
		storePayload.setId(faker.idNumber().hashCode());
		storePayload.setPetId(faker.idNumber().hashCode());
		storePayload.setQuantity(faker.number());
		storePayload.setShipDate(faker.date());		
		
	}

}
