package book;

public class Name extends Entry{
	
	private String firstName;
	private String lastName;
	private String middleName;
	private String fullName;
	private String full2Name;
	
	//default constructor
	public Name() {}
	
	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	//Parameterized constructor
	public Name(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	
	//Getter's
	public String getFullName() {
		return this.fullName;
	}
	public String getFirstName() {
		return this.firstName;
	}
	public String getMiddleName() {
		return this.middleName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public String getFull2Name() {
		return this.full2Name;
	}
	
	//Setter's
	public void setFullName(String firstName, String middleName, String lastName) {
		this.fullName = this.firstName + " " + this.middleName + " " + this.lastName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	public void setFull2Name(String firstName, String lastName) {
		this.full2Name = firstName + " " + this.lastName;
	}
	

	public String toString() {
		return firstName + " " + middleName + " " + lastName;
	}

}
