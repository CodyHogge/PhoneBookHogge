package book;

public class Phone{
	private String type;
	private String number;
	private String area;
	private String location;
	private String num;
	
	//def constructor
	public Phone() {}
	
	//param constructor basic
	public Phone(String number) {
		this.number = number;
	}
	
	public Phone(String area, String location, String num) {
		this.area = area;
		this.location = location;
		this.num = num;
		this.number = area+location+num;
	}
	
	//param constructor for further practice "adding work/cell/home"
	public Phone(String type, String number) {
		this.type = type;
		this.number = number;
	}
	
	//getter's
	public String getType() {
		return this.type;
	}
	public String getNumber() {
		return this.number;
	}
	public String getArea() {
		return this.area;
	}
	public String getLocation() {
		return this.location;
	}
	public String getNum() {
		return this.num;
	}
	
	//setter's
	public void setType(String type) {
		this.type = type;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
	public String phonetoString() {
		return area+location+num;
	}
}
