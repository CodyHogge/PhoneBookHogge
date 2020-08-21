package book;

public class Entry {
	
	protected int entryCount;
	protected Name name;
	protected Address address;
	protected Phone phoneNumber;
	
	//Default constructor
	public Entry() {}
	
	//Parameterized constructor
	public Entry(Name name, Address address, Phone phoneNumber) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	//Getter's
	public Name getName() {
		return this.name;
	}
	
	public Address getAddress() {
		return this.address;
	}
	public Phone getPhone() {
		return this.phoneNumber;
	}
	
	//Setter's
	
	public void setName(Name name) {
		this.name = name;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setPhoneNumber(Phone phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
