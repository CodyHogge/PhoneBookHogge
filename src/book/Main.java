package book;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int z = 0;
		Entry[] entryArray = new Entry[100];
		int selection = showMenu(0);
		while(selection != 11) {
		switch(selection) {
		
		
		case 1: //Add new entries
			System.out.println("You selected option: " + selection + " -Add new entry.");
			System.out.println("Please enter your information below in the format listed.");
			System.out.println("(Name, Street Name, City Name, State, Zipcode, Phone Number.)");
			Scanner inputsc = new Scanner(System.in);
			String input = inputsc.nextLine();
			Entry entry = createEntry(input);
			entryArray[z] = entry;
			z++;
			System.out.print("Would you like to add another entry? ");
			Scanner contsc = new Scanner(System.in);
			char cont = contsc.next().charAt(0);
			while(cont == 'y') {
				System.out.println("Please enter your information below in the format listed.");
				System.out.println("(Name, Street Name, City Name, State, Zipcode, Phone Number.)");
				inputsc = new Scanner(System.in);
				input = inputsc.nextLine();
				entry = createEntry(input);
				entryArray[z] = entry;
				z++;
				System.out.print("Would you like to add another entry? ");
				cont = contsc.next().charAt(0);
			}			
			selection = showMenu(0);			
			break;
			
			
		case 2: //Search for an existing entry
			System.out.print("What entry number would you like to search: ");
			Scanner entsc = new Scanner(System.in);
			int entrynum = entsc.nextInt();
			displayEntry(entrynum, entryArray);
			
			System.out.println();
			System.out.print("Would you like to search another entry? ");
			contsc = new Scanner(System.in);
			cont = contsc.next().charAt(0);
			while(cont == 'y') { 
				System.out.println("What entry number would you like to search: ");
				entsc = new Scanner(System.in);
				entrynum = entsc.nextInt();
				displayEntry(entrynum, entryArray);
				System.out.println();
				System.out.print("Would you like to search another entry? ");
				contsc = new Scanner(System.in);
				cont = contsc.next().charAt(0);				
			}
			selection = showMenu(0);
			break;
			
			
		case 3: //Search by first name
			System.out.print("Please enter the name to search: ");
			Scanner fnamesc = new Scanner(System.in);
			String fname = fnamesc.next();
			for(int i=0;i<entryArray.length;i++) {
				String entFirstName = entryArray[i].getName().getFirstName();
				System.out.println(entFirstName);
				if(fname == entFirstName) {
					displayEntry(i, entryArray);
				}
			}
			System.out.println();
			System.out.print("Would you like to search another name?: ");
			contsc = new Scanner(System.in);
			cont = contsc.next().charAt(0);
			while(cont == 'y') {
				System.out.print("Please enter the name to search: ");
				fnamesc = new Scanner(System.in);
				fname = fnamesc.next();
				for(int i=0;i<entryArray.length;i++) {
					String entFirstName = (String) entryArray[i].getName().getFirstName();
					if(fname == entFirstName) {
						displayEntry(i, entryArray);
					}
				}
				System.out.println();
				System.out.print("Would you like to search another name?: ");
				contsc = new Scanner(System.in);
				cont = contsc.next().charAt(0);
			}
			selection = showMenu(0);
			break;
			
			
		case 4: //Search by last name
			break;
			
			
		case 5: //Search by full name
			break;
			
			
		case 6: //Search by tele number
			break;
			
			
		case 7: //Search by city or state
			break;
			
			
		case 8: //Delete a record for a given tele number
			break;
			
			
		case 9: //Update a record for a given tele number
			break;
			
			
		case 10: //Show all records in ascending order
			break;
			
			
		case 11: //Exit the program
			System.out.println("You selected option: " + selection + ".");
			System.out.println("Thank you for using the phone book.");
			break;
			
			
		default:
			System.out.println("Sorry, you chose an invalid option. Please choose make another selection.");
			selection = showMenu(0);
		}
		}
		if(selection == 11) {
			System.out.println("You selected option: " + selection + ".");
			System.out.println("Thank you for using the phone book.");
		}
	}
	
	public static void displayEntry(int x, Entry[] entry) {
		String fname = (String) entry[x].getName().getFirstName();
		String mname = (String) entry[x].getName().getMiddleName();
		String lname = (String) entry[x].getName().getLastName();
		String name = fname + " " + mname + " " + lname;
		String strname = (String) entry[x].getAddress().getStreetName();
		String cityname = (String) entry[x].getAddress().getCityName();
		String statename = (String) entry[x].getAddress().getStateAbb();
		String zipcode = (String) entry[x].getAddress().getZipcode();
		String address = strname + ", " + cityname + ", " + statename + ", " + zipcode;
		String area = (String) entry[x].getPhone().getArea();
		String loc = (String) entry[x].getPhone().getLocation();
		String num = (String) entry[x].getPhone().getNum();
		String phoneNum = "("+area+") "+loc+"-"+num;
		System.out.println("Entry["+x+"]");
		System.out.print("Name: " + name);
		System.out.println();
		System.out.print("Address: " + address);
		System.out.println();
		System.out.print("Phone Number: " + phoneNum);
		System.out.println();
	}

	
	public static int showMenu(int x) {
		System.out.println("Menu:");
		System.out.println("Option 1: Add new entry.");
		System.out.println("Option 2: Search for existing entry.");
		System.out.println("Option 3: Search by first name.");
		System.out.println("Option 4: Search by last name.");
		System.out.println("Option 5: Search by full name.");
		System.out.println("Option 6: Search by telephone number.");
		System.out.println("Option 7: Search by city or state.");
		System.out.println("Option 8: Delete entry for given telephone number.");
		System.out.println("Option 9: Update a record for given phone number.");
		System.out.println("Option 10: ");
		System.out.println("Option 11: ");
		System.out.print("What would you like to do?: ");
		Scanner selectsc = new Scanner(System.in);
		int select = selectsc.nextInt();
		return select;
		
	}
		
	public static Entry createEntry(String input) {
		String[] inputs = input.split(",");
		String name, street, city, state, zip, phoneNum;
		name = "";
		street = "";
		city = "";
		state ="";
		zip ="";
		phoneNum = "";
		name =inputs[0];
		street = inputs[1].trim();
		city =inputs[2].trim();
		state =inputs[3].trim();
		zip =inputs[4].trim();
		phoneNum =inputs[5].trim();
			
		Name entryName = createName(name);
		Address entryAddress = createAddress(street, city, state, zip);
		Phone entryPhone = createPhone(phoneNum);		
			
		
		Entry entry = new Entry(entryName, entryAddress, entryPhone);			
		return entry;
	}
	
	public static Address createAddress(String street, String city, String state, String zip) {
		Address entryAddress = new Address(street, city, state, zip);
		return entryAddress;
	}
		
	public static Name createName(String input) {
		String fName, mName, lName;
		fName = "";
		mName = "";
		lName = "";
		String[] inputs = input.split(" ");
		if(inputs.length == 3) {
			fName = inputs[0];
			mName = inputs[1];
			lName = inputs[2];
		}
		if(inputs.length == 4) {
			fName = inputs[0];
			mName = inputs[1] + " " + inputs[2];
			lName = inputs[3];
				
		}
		Name name = new Name(fName, mName, lName);
		return name;
	}
		
	public static Phone createPhone(String input) {
		String area, location, num;
		area = input.substring(0, 3);
		location = input.substring(3, 6);
		num = input.substring(6);
			
		Phone phone = new Phone(area, location, num);
		return phone;
	}
		

}

