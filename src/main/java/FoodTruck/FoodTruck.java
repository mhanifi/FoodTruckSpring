package FoodTruck;


import java.text.ParseException;
public class FoodTruck {
 
	 private String applicant;
	 private String locationDescription;
	 private String address;
	 private String lot;
	 private String foodItems;
	 private String latitude;
	 private String longitude;
	 private String dayHours;
	 private String status;

	public FoodTruck() {}
	public FoodTruck( String applicant,String locationDescription,String address,String lot,String foodItems,
					  String latitude,String longitude,String dayHours, String status) throws ParseException{
		this.applicant= applicant;
		this.locationDescription= locationDescription;
		this.address= address;
		this.lot= lot;
		this.foodItems= foodItems;
		this.latitude= latitude;
		this.longitude= longitude;
		this.dayHours= dayHours;
		this.status = status;
	}
	public String hashKey()
	{
		return this.applicant + "-" + this.foodItems;
	}

	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getLocationDescription() {
		return locationDescription;
	}
	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getLot() {
		return lot;
	}
	public void setLot(String lot) {
		this.lot = lot;
	}

	public String getFoodItems() {
		return foodItems;
	}
	public void setFoodItems(String foodItems) {
		this.foodItems = foodItems;
	}

	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getDayHours() {
		return dayHours;
	}
	public void setDayHours(String dayHours) {
		this.dayHours = dayHours;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus() {

		return status;
	}
	 
}
