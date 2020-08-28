package book;

import java.util.Scanner;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) { 
		int z = 0; 							//not sure what i'm doing with these lines, i'll have to clean them up. I know they're how i created the entry[]
		Entry[] entryArray = new Entry[100];
		Entry[] sortedArray = new Entry[100];
		int selection = showMenu(0); //selection will be an int that is used in the switch below, the scanner is held within the showMenu method
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
			System.out.print("Would you like to add another entry? (Yes/No) "); //lines 24-27 will ask the user if they want to add another entry
			Scanner contsc = new Scanner(System.in);					//this is instead of returning to the base menu and doing another cycle
			char cont = contsc.next().charAt(0);
			while(cont == 'y') { 										//lines 27-38 will just repeat the add entry process until the user
																		//responds with a "no" to the add another user prompt
				System.out.println("Please enter your information below in the format listed.");
				System.out.println("(Name, Street Name, City Name, State, Zipcode, Phone Number.)");
				inputsc = new Scanner(System.in);
				input = inputsc.nextLine();
				entry = createEntry(input);
				entryArray[z] = entry;
				z++;
				System.out.print("Would you like to add another entry? (Yes/No) ");
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
			System.out.print("Would you like to search another entry? (Yes/No) "); //similar to the add entry, this will prompt the user to cycle the process
			contsc = new Scanner(System.in);								// again without returning to the main menu
			cont = contsc.next().charAt(0);
			while(cont == 'y') { 
				System.out.println("What entry number would you like to search: ");
				entsc = new Scanner(System.in);
				entrynum = entsc.nextInt();
				displayEntry(entrynum, entryArray);
				System.out.println();
				System.out.print("Would you like to search another entry? (Yes/No) ");
				contsc = new Scanner(System.in);
				cont = contsc.next().charAt(0);				
			}
			selection = showMenu(0);
			break;
			
			
		case 3: //Search by first name
			System.out.print("Please enter the name to search: "); //option 3 isn't working currrently, I'm having trouble with the "searching"
			Scanner fnamesc = new Scanner(System.in);				// I get an error because in because i believe that the for loop is looking 
			String fname = fnamesc.next().trim().toLowerCase();							// outside of the index/array.
			for(int i=0;i<z;i++) {
				String entFirstName = (String) entryArray[i].getName().getFirstName();
				entFirstName = entFirstName.trim().toLowerCase();
				if(entFirstName.contains(fname)) {
					displayEntry(i, entryArray);
				}
				
			}
			System.out.println();
			System.out.print("Would you like to search another name?: (Yes/No) "); //78-97 cycle through the process again without returning to main menu
			contsc = new Scanner(System.in);
			cont = contsc.next().charAt(0);
			while(cont == 'y') {
				System.out.print("Please enter the name to search: ");
				fnamesc = new Scanner(System.in);
				fname = fnamesc.next();
				for(int i=0;i<z;i++) {
					String entFirstName = (String) entryArray[i].getName().getFirstName();
					if(entFirstName.contains(fname)) {
						displayEntry(i, entryArray);
					}
				}
				System.out.println();
				System.out.print("Would you like to search another name?: (Yes/No) ");
				contsc = new Scanner(System.in);
				cont = contsc.next().charAt(0);
			}
			selection = showMenu(0);
			break;
			
			
		case 4: //Search by last name
			System.out.print("Please enter the name to search: "); //copied from case 3 and replaced variables/ getter's
			Scanner lnamesc = new Scanner(System.in);				
			String lname = lnamesc.next().trim().toLowerCase();							
			for(int i=0;i<z;i++) {
				String entLastName = (String) entryArray[i].getName().getLastName();
				entLastName = entLastName.trim().toLowerCase();
				if(entLastName.contains(lname)) {
					displayEntry(i, entryArray);
				}
				
			}
			System.out.println();
			System.out.print("Would you like to search another name?: (Yes/No) "); //cycle through the process again without returning to main menu
			contsc = new Scanner(System.in);
			cont = contsc.next().charAt(0);
			while(cont == 'y') {
				System.out.print("Please enter the name to search: ");
				lnamesc = new Scanner(System.in);
				lname = lnamesc.next();
				for(int i=0;i<z;i++) {
					String entLastName = (String) entryArray[i].getName().getLastName();
					if(entLastName.contains(lname)) {
						displayEntry(i, entryArray);
					}
				}
				System.out.println();
				System.out.print("Would you like to search another name?: (Yes/No) ");
				contsc = new Scanner(System.in);
				cont = contsc.next().charAt(0);
			}
			selection = showMenu(0);
			break;
			
			
			
		case 5: //Search by full name	
			System.out.print("Please enter the name to search: "); //copied from case 3 and replaced variables/ getter's
			Scanner fullnamesc = new Scanner(System.in);				
			String fullname = fullnamesc.nextLine().trim().toLowerCase();	
			String[] fullnamespl = fullname.split(" ");
			if(fullnamespl.length == 2) {
				for(int i=0; i<z;i++) {
					String entFull2Name = (String) entryArray[i].getName().toString();
					if(entFull2Name.equals(fullname)) {
						displayEntry(i,entryArray);
					}
				}
			}
			if(fullnamespl.length>2) {
				for(int i=0;i<z;i++) {
					String entFullName = entryArray[i].getName().toString();
					if(entFullName.equals(fullname)) {
						displayEntry(i,entryArray);
					}
				}
			}
			System.out.println();
			System.out.print("Would you like to search another name?: (Yes/No) "); //cycle through the process again without returning to main menu
			contsc = new Scanner(System.in);
			cont = contsc.next().charAt(0);
			while(cont == 'y') {
				System.out.print("Please enter the name to search: "); //copied from case 3 and replaced variables/ getter's
				fullnamesc = new Scanner(System.in);				
				fullname = fullnamesc.nextLine().trim().toLowerCase();	
				fullnamespl = fullname.split(" ");
				if(fullnamespl.length == 2) {
					for(int i=0; i<z;i++) {
						String entFull2Name = (String) entryArray[i].getName().toString();
						if(entFull2Name.equals(fullname)) {
							displayEntry(i,entryArray);
						}
					}
				}
				if(fullnamespl.length>2) {
					for(int i=0;i<z;i++) {
						String entFullName = (String) entryArray[i].getName().toString();
						if(entFullName.equals(fullname)) {
							displayEntry(i,entryArray);
						}
					}
				}
				System.out.println();
				System.out.print("Would you like to search another name?: (Yes/No) "); //cycle through the process again without returning to main menu
				contsc = new Scanner(System.in);
				cont = contsc.next().charAt(0);
			}
			selection = showMenu(0);
			break;
			
			
		case 6: //Search by tele number
			System.out.print("Please enter the phone number to search: ");
			Scanner phonesc = new Scanner(System.in);
			String phoneSearch = phonesc.next().trim();
			for(int i=0;i<z;i++) {
				String entNumber = (String) entryArray[i].getPhone().getNumber();
				if(entNumber.equals(phoneSearch)) {
					displayEntry(i, entryArray);
				}
			}
				System.out.println();
				System.out.print("Would you like to search another number? (Yes/No) ");
				contsc = new Scanner(System.in);
				cont = contsc.next().charAt(0);
				System.out.println(cont);
				while(cont == 'y') {					//repeat search by phone number option
					System.out.print("Please enter the phone number to search: ");
					phonesc = new Scanner(System.in);
					phoneSearch = phonesc.next().trim();
					for(int i=0;i<z;i++) {
						String entNumber = (String) entryArray[i].getPhone().getNumber();
						System.out.println(entNumber);
						if(entNumber.equals(phoneSearch)) {
							displayEntry(i, entryArray);
						}
						
						System.out.println();
						System.out.print("Would you like to search another number? (Yes/No) ");
						contsc = new Scanner(System.in);
						cont = contsc.next().charAt(0);
				}
				}
				selection = showMenu(0);
			break;
			
			
		case 7: //Search by city or state
			System.out.print("Would you like to search by City or State?: ");
			Scanner startsc = new Scanner(System.in);
			char start7 = startsc.next().trim().charAt(0);
			if(start7 == 's') { //State option
				System.out.print("Please enter the two letter state abbreviation to search: ");
				Scanner statesc = new Scanner(System.in);
				String stateSearch = statesc.next().trim();
				for(int i=0;i<z;i++) {
					String entState = entryArray[i].getAddress().getStateAbb();
					if(entState.equalsIgnoreCase(stateSearch)) {
						displayEntry(i, entryArray);
					}
				}
			}
			if(start7 == 'c') { //City option
				System.out.print("Please enter the city to search: ");
				Scanner citysc = new Scanner(System.in);
				String citySearch = citysc.next().trim();
				for(int i=0;i<z;i++) {
					String entCity = entryArray[i].getAddress().getCityName();
					if(entCity.equalsIgnoreCase(citySearch)) {
						displayEntry(i, entryArray);
					}
				}
			}
			System.out.println();
			System.out.print("Would you like to search again? (Yes/No) ");
			contsc = new Scanner(System.in);
			cont = contsc.next().charAt(0);
			while(cont=='y') { 														//repeat search by city or state option
				System.out.print("Would you like to search by City or State?: ");
				startsc = new Scanner(System.in);
				start7 = startsc.next().trim().charAt(0);
				if(start7 == 's') { //State option
					System.out.print("Please enter the two letter state abbreviation to search: ");
					Scanner statesc = new Scanner(System.in);
					String stateSearch = statesc.next().trim();
					for(int i=0;i<z;i++) {
						String entState = entryArray[i].getAddress().getStateAbb();
						if(entState.equalsIgnoreCase(stateSearch)) {
							displayEntry(i, entryArray);
						}
					}
				}
				if(start7 == 'c') { //City option
					System.out.print("Please enter the city to search: ");
					Scanner citysc = new Scanner(System.in);
					String citySearch = citysc.next().trim();
					for(int i=0;i<z;i++) {
						String entCity = entryArray[i].getAddress().getCityName();
						if(entCity.equalsIgnoreCase(citySearch)) {
							displayEntry(i, entryArray);
						}
					}
				}
				System.out.println();
				System.out.print("Would you like to search again? (Yes/No) ");
				contsc = new Scanner(System.in);
				cont = contsc.next().charAt(0);
			}
			selection = showMenu(0);
			break;
			
			
		case 8: //Delete a record for a given tele number
			System.out.print("Please enter a telephone number to search: ");
			Scanner step8sc = new Scanner(System.in);
			String step8inp = step8sc.next().trim();
			for(int i=0;i<z;i++) {
				if(entryArray[i].getPhone().phonetoString().equals(step8inp)) {
					displayEntry(i,entryArray);
					System.out.println("Are your sure you want to delete this entry?: ");
					Scanner deletesc = new Scanner(System.in);
					char delete = deletesc.next().toLowerCase().trim().charAt(0);
					if(delete == 'y') {
						entryArray=deleteEntry(entryArray, z, step8inp);
					}
					z--;
				}
			}
			for(int i=0;i<z;i++) {
				displayEntry(i,entryArray);
			}
			System.out.println();
			System.out.print("Would you like to delete another entry?: (Yes/No) ");
			Scanner step8contsc= new Scanner(System.in);
			char step8cont = step8contsc.next().trim().charAt(0);
			while(step8cont == 'y') {
				System.out.print("Please enter a telephone number to search: ");
				step8sc = new Scanner(System.in);
				step8inp = step8sc.next().trim();
				for(int i=0;i<z;i++) {
					if(entryArray[i].getPhone().phonetoString().equals(step8inp)) {
						displayEntry(i,entryArray);
						System.out.println("Are your sure you want to delete this entry?: ");
						Scanner deletesc = new Scanner(System.in);
						char delete = deletesc.next().toLowerCase().trim().charAt(0);
						if(delete == 'y') {
							entryArray=deleteEntry(entryArray, z, step8inp);
						}
						z--;
					}
				}
				for(int i=0;i<z;i++) {
					displayEntry(i,entryArray);
				}
				System.out.println();
				System.out.print("Would you like to delete another entry?: (Yes/No) ");
				step8contsc= new Scanner(System.in);
				step8cont = step8contsc.next().trim().charAt(0);
			}
			selection = showMenu(0);
			
			break;
			
			
		case 9: //Update a record for a given tele number
			System.out.println("Please enter the old phone number: ");
			Scanner phoneUpdatesc = new Scanner(System.in);
			String phoneUpdateSearch = phoneUpdatesc.next().trim();
			for(int i=0;i<z;i++) {
				if((entryArray[i].getPhone().getNumber().equalsIgnoreCase(phoneUpdateSearch))) {
					displayEntry(i, entryArray);
					System.out.println();
					System.out.print("Please enter the new number for this contact: ");
					Scanner phoneNewNumsc = new Scanner(System.in);
					String phoneUpdate = phoneNewNumsc.next().trim();
					entryArray[i].setPhoneNumber(createPhone(phoneUpdate));
					System.out.println();
					System.out.println("The new contact information is: ");
					displayEntry(i,entryArray);
				}
			}
			System.out.println();
			System.out.println("Would you like to update another contact?: (Yes/No) ");
			contsc = new Scanner(System.in);
			cont = contsc.next().charAt(0);
			while(cont == 'y') {					//repeat update phone number
				System.out.println("Please enter the old phone number: ");
				phoneUpdatesc = new Scanner(System.in);
				phoneUpdateSearch = phoneUpdatesc.next().trim();
				for(int i=0;i<z;i++) {
					if((entryArray[i].getPhone().getNumber().equalsIgnoreCase(phoneUpdateSearch))) {
						displayEntry(i, entryArray);
						System.out.println();
						System.out.print("Please enter the new number for this contact: ");
						Scanner phoneNewNumsc = new Scanner(System.in);
						String phoneUpdate = phoneNewNumsc.next().trim();
						entryArray[i].setPhoneNumber(createPhone(phoneUpdate));
						System.out.println();
						System.out.println("The new contact information is: ");
						displayEntry(i,entryArray);
					}
				}
				System.out.println();
				System.out.println("Would you like to update another contact?: (Yes/No) ");
				contsc = new Scanner(System.in);
				cont = contsc.next().charAt(0);
			}
			selection = showMenu(0);
			break;
			
			
		case 10: //Show all records in ascending order by first name
			
				sortedArray = sortFName(entryArray, z);
				for(int i=0;i<z;i++) {
					displayEntry(i,sortedArray);
				}
				
				System.out.print("Ready to return to menu?: (Yes/No) ");
				Scanner contsc10 = new Scanner(System.in);
				char cont10 = contsc10.next().toLowerCase().trim().charAt(0);
				if(cont10=='y') {
					selection=showMenu(0);
				}
			break;
			
			
		case 11: //Exit the program
			System.out.println("You selected option: " + selection + ".");
			System.out.println("Thank you for using the phone book.");
			break;
			
			
		default: //if the user enters a value that is outside of the menu options
			System.out.println("Sorry, you chose an invalid option. Please choose make another selection.");
			selection = showMenu(0);
		}
		}
		if(selection == 11) {
			System.out.println("You selected option: " + selection + ".");
			System.out.println("Thank you for using the phone book.");
		}
	}
	//deleteEntry method
	public static Entry[] deleteEntry(Entry[] entry, int z, String phonesc) {
		int x = 0;
		Entry[] result = new Entry[z-1];
		Entry[] throwAway = new Entry[++x];
		for(int i=0;i<z-1;i++) {
			for(int j=0;j<z-1;j++) {
				if(entry[i].getPhone().toString() != phonesc) {
					result[i] = entry[i+1];
				}
			}
		}
		
		return result;
	}
	
	//swap method is unused
	public static Entry[] swapOrder(Entry x, Entry y) {
		Entry a,b,c;
		a = x;
		b = y;
		c=a;
		a=b;
		b=c;
		x=b;
		y=a;
		Entry[] retArray = new Entry[2];
		retArray[0]=x;
		retArray[1]=y;
		return retArray;
	}
	
	//dislayEntry method will display the information for the entry a Entry[x]
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
	
	//sortFName
	public static Entry[] sortFName(Entry[] entry, int z) {
		Entry temp;
		for(int i=0;i<z;i++) {
			for(int j=i+1;j<z;j++) {
				if(entry[i].toString().compareTo(entry[j].toString())>0) {
					temp = entry[i];
					entry[i]=entry[j];
					entry[j]=temp;
				}
			}
		}
		return entry;
	}

	//showMenu method will display the main menu
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
		System.out.println("Option 10: Sort entries.");
		System.out.println("Option 11: Exit application.");
		System.out.print("What would you like to do?: ");
		Scanner selectsc = new Scanner(System.in);
		int select = selectsc.nextInt();
		return select;
		
	}
	
	//createEntry will essentially create an Entry() object that can be input to the Entry[]
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
	
	//createAddress will create an Address() that can be used in the constructor for Entry()
	public static Address createAddress(String street, String city, String state, String zip) {
		Address entryAddress = new Address(street, city, state, zip);
		return entryAddress;
	}
	
	//createName will create a Name() that can be used in the constructor for Entry()
	public static Name createName(String input) {
		Name name = new Name();
		String fName, mName, lName;
		fName = "";
		mName = "";
		lName = "";
		String[] inputs = input.split(" ");
		if(inputs.length == 3) {
			fName = inputs[0];
			mName = inputs[1];
			lName = inputs[2];
			name = new Name(fName, mName, lName);
			return name;
		}
		if(inputs.length == 4) {
			fName = inputs[0];
			mName = inputs[1] + " " + inputs[2];
			lName = inputs[3];
			name = new Name(fName, mName, lName);
			return name;
		}
		if(inputs.length == 2) {
			fName = inputs[0];
			lName = inputs[1];
			name = new Name(fName, lName);
			return name;
		}
		return name;
	}
	
	//createPhone will create a Phone() that can be used in the constructor for Entry()
	public static Phone createPhone(String input) {
		String area, location, num;
		area = input.substring(0, 3);
		location = input.substring(3, 6);
		num = input.substring(6);
			
		Phone phone = new Phone(area, location, num);
		return phone;
	}
		

}


