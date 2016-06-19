/* Author: Anne-Marie E. CAREY
 * s3267939@student.rmit.edu.au 
 */


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonController {
	Scanner reader = new Scanner(System.in);
	private int athNum = 1;
	private int offNum = 1;
	private ArrayList<Person> people = new ArrayList<Person>();

	public ArrayList<Person> getPeople() {
		return people;
	}

	public void addPeople(Person person) {
		this.people.add(person);
	}
	
	public String createAthID() {
		String athID = "A" + athNum;
		athNum++;
		return athID;
	}
	
	public String createOffID() {
		String offID = "O" + offNum;
		offNum++;
		return offID;
	}
	
	public String enterName() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Please enter person's name: ");
		String newName = reader.nextLine();
		charOnlyCheck(newName);
        return newName;
	}

	public String enterAge() {
		System.out.println("Please enter the person's age: ");
		String x = reader.nextLine();
		while (x.matches("[a-zA-Z ]+")) {   
			System.out.println("Please enter numbers only: ");
			x = reader.nextLine();
		}
		int y = Integer.parseInt(x);
		while (y < 18 || y > 110) {
			System.out.println("Please enter a number between 18 and 110");
			x = reader.next();
			y = Integer.parseInt(x);	
		}
		return x;
	}

	public String selectState() throws IOException {
		final int MIN_CH = 1, MAX_CH = 8;
		System.out.println("What is the person's home state: ");
		System.out.println("Press 1 for VIC");
		System.out.println("Press 2 for NSW"); 
		System.out.println("Press 3 for SA");
		System.out.println("Press 4 for WA");
		System.out.println("Press 5 for ACT");
		System.out.println("Press 6 for NT");
		System.out.println("Press 7 for QLD");
		System.out.println("Press 8 for TAS");
		int choice = numCheck(MIN_CH, MAX_CH);
		String s = null;
		if (choice == 1 ) {
			s = "VIC";
		}
		else if (choice == 2) {
			s = "NSW";
		}
		else if (choice == 3) {
			s = "SA";
		}
		else if (choice == 4) {
			s = "ACT";
		}
		else if (choice == 5) {
			s = "WA";
		}
		else if (choice == 6) {
			s = "NT";
		}
		else if (choice == 7) {
			s = "QLD";
		}
		else if (choice == 8) {
			s = "TAS";
		}
		return s;
	}

	public String selectSport() throws IOException {
		System.out.println("Press 1 for Swimming");
		System.out.println("Press 2 for Cycling"); 
		System.out.println("Press 3 for Running");
		System.out.println("Press 4 for SuperAthlete");
		int MIN_CH = 1, MAX_CH = 4;
		int choice = numCheck(MIN_CH, MAX_CH);
		String sport = null;
		if (choice == 1 ) {
			sport = "Swimming";
		}
		else if (choice == 2) {
			sport = "Cycling";
		}
		else if (choice == 3) {
			sport = "Running";
		}
		else if (choice == 4) {
			sport = "SuperAthlete";
		}
		return sport;
	}

	public boolean checkNoAths() {
		boolean check = true;
		for (Person p : getPeople()) {
			if (p instanceof Athlete) {
				check = false;
			}
		}
		return check;
	}
	
	public boolean checkNoOffs() {
		boolean check = true;
		for (Person p : getPeople()) {
			if (p instanceof Official) {
				check = false;
			}
		}
		return check;
	}

	
	public boolean findFreeAthletes(String sportChoice) throws IOException {
		boolean ok = false;
		System.out.println("Free Athletes: ");
		System.out.println("==============");
		for (Person p : getPeople()) {
			if (p instanceof Athlete) {
				if (((Athlete)p).getSport().equals(sportChoice) || 
						((Athlete)p).getSport() == "SuperAthlete") {
					if (((Athlete)p).getStatus() == "Unassigned") {
						System.out.println(p.getPersonID() + " " + p.getName());
						ok = true;
					}
				}
			}
		}
		if (ok == false) {
			System.out.println("Sorry, no athletes match this criteria. "
					+ "Please create a new athlete.");
		}
		System.out.println("==============");
		System.out.println();
		return ok;
	}
	
	public boolean findOfficials() throws IOException {
		boolean ok = false;
		System.out.println("Officials: ");
		System.out.println("==============");
		for (Person p : getPeople()) {
			if (p instanceof Official){
				System.out.println(p.getPersonID());
				ok = true;
			}
		}
		if (ok == false) {
				System.out.println("Sorry, no games are without an officials.");
				System.out.println("Please create a new game.");
		}
		System.out.println("==============");
		System.out.println();
		return ok;
	}
	
	//check input is within min and max num boundaries
	private int numCheck(int min, int max) throws IOException {
		int num = noCharCheck();
		final int MIN = min;
		final int MAX = max;
		while (num < MIN || num > MAX) {
			System.out.println("Please enter a number between " 
					+ min + " and " + max + ".");
			num = noCharCheck();
		}
		return num;
	}   

	private String charOnlyCheck(String newName) {
		while (!newName.matches("[a-zA-Z ]+")) {   
			System.out.println("Please enter a valid name: ");
			newName = reader.nextLine();
		}
		return newName;
	}

	//check for String characters in numeric input
	private int noCharCheck() throws IOException {
		boolean test = false;
		String input;
		int string1 = -1;
		do {
			try {
				BufferedReader stdin = new BufferedReader
						(new InputStreamReader(System.in));
				input = stdin.readLine();
				string1 = Integer.parseInt (input);
			}
			catch (NumberFormatException nfe) {
				System.out.println("Invalid input format.");
			}
			return string1;
		}
		while (!test);
	}
}
