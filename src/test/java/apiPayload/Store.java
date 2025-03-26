package apiPayload;

import com.github.javafaker.DateAndTime;
import com.github.javafaker.Number;

public class Store {

	int id;
	int petId;
	Number quantity;
	DateAndTime shipDate;
	String[] status;
	boolean complete;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public Number getQuantity() {
		return quantity;
	}

	public void setQuantity(Number number) {
		this.quantity = number;
	}

	public DateAndTime getShipDate() {
		return shipDate;
	}

	public void setShipDate(DateAndTime dateAndTime) {
		this.shipDate = dateAndTime;
	}

	public String[] getStatus() {
		return status;
	}

	public void setStatus(String[] status) {
		this.status = status;
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

}
