/* Author: Anne-Marie E. CAREY
 * s3267939@student.rmit.edu.au 
 */


import java.util.*;

public class Athlete extends Person {
	private Random randomTime = new Random();
	private int points;
	private String sport;
	private String status;
	
	public Athlete() {
	}
	
	//Person constructor with two new parameters for athlete
	public Athlete(String pID, String pName, String pAge, 
			String pState, String aSport) {
		super(pID, pName, pAge, pState);
		this.points = 0;
		this.sport = aSport;
		this.setStatus("Unassigned");
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int newPoints) {
		this.points = points + newPoints;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSport() {
		return sport;
	}

	//generates a random time for a single, given type of athlete
	public int compete(String type) {
		int max = 0, min = 0;
		int time;
		if (type == "Running") {
			min = 10;
			max = 20;
		}
		else if (type == "Swimming") {
			min = 100;
			max = 200;
		}
		else if (type == "Cycling") {
			min = 500;
			max = 800;
		}
		time = randomTime.nextInt((max-min) + 1) + min;
		return time;
	}
}