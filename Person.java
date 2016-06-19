/* Author: Anne-Marie E. CAREY
 * s3267939@student.rmit.edu.au 
 */


import java.util.*;

public abstract class Person {
	private String personID;
	private String name;
	private String age;
	private String state;
	public Person() {
	}
	
	//constructor for person object which cannot be instantiated
	public Person(String pID, String pName, String pAge, String pState) {
		this.personID = pID;
		this.name = pName;
		this.age = pAge;
		this.state = pState;
	}

	public String getPersonID() {
		return personID;
	}

	public String getName() {
		return name;
	}

	public String getAge() {
		return age;
	}

	public String getState() {
		return state;
	}
}

	