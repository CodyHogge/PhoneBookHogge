package book;

public class Address {
	
	private String streetName;
	private String cityName;
	private String stateAbb;
	private String zipcode;
	
	//Default constructor
	public Address() {}
	
	//Parameterized constructor
	public Address(String streetName, String cityName, String stateAbb, String zipcode) {
		this.streetName = streetName;
		this.cityName = cityName;
		this.stateAbb = stateAbb;
		this.zipcode = zipcode;
	}
	
	//Getter's
	public String getStreetName() {
		return this.streetName;
	}
	public String getCityName() {
		return this.cityName;
	}
	public String getStateAbb() {
		return this.stateAbb;
	}
	public String getZipcode() {
		return this.zipcode;
	}
	
	//Setter's
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public void setStateAbb(String stateAbb) {
		this.stateAbb = stateAbb;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
