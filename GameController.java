/* Author: Anne-Marie E. CAREY
 * s3267939@student.rmit.edu.au 
 */


import java.io.*;
import java.util.*;

public class GameController {
	private int gameNum = 1;
	private ArrayList<Game> games = new ArrayList<Game>();
	private Scanner reader = new Scanner(System.in);

	public ArrayList<Game> getGames() {
		return games;
	}

	public Game getGames(int i) {
		return games.get(i);
	}

	public void addGame(Game game) {
		games.add(game);
	}

	public String createGameID(String gType) {
		String gameID = null;
		if (gType == "Swimming") {
			gameID = "S";
		}
		else if (gType == "Cycling") {
			gameID = "C";
		}
		else if (gType == "Running") {
			gameID = "R";
		}
		gameID = gameID + gameNum;
		gameNum++;
		return gameID;
	}

	public String selectGameType() throws IOException {
		int choice;
		String gType = null;
		System.out.println("Press 1 for Swimming");
		System.out.println("Press 2 for Cycling");
		System.out.println("Press 3 for Running");
		choice = numCheck(1, 3);
		if (choice == 1 ) {
			gType = "Swimming";
		}
		else if (choice == 2) {
			gType = "Cycling";
		}
		else if (choice == 3) {
			gType = "Running";
		}
		return gType;
	}

	public boolean findAvailGames(String sportChoice) throws IOException {
		boolean ok = false;
		System.out.println("Suitable Games: ");
		System.out.println("==============");
		for (Game g : getGames()) {
			if (g.getGameType().equals(sportChoice) && g.getGameStatus() == "Active"
					&& g.getAthletes().size() < 8) {
				System.out.println(g.getGameID() + " " + g.getGameType());
				ok = true;
			}
		}
		if (ok == false) {
			System.out.println("Sorry, there are either no available games for this ");
			System.out.println("sport or there are no free athletes to assign.");
		}
		System.out.println("==============");
		System.out.println();
		return ok;
	}

	public boolean findGamesNoOfficial() {
		boolean ok = false;
		System.out.println("Games without Officials: ");
		System.out.println("==============");
		for (Game g : getGames()) {
			if (g.getOfficial() == null) {
				ok = true;
				System.out.println(g.getGameID() + " " + g.getGameType());
			}
		}
		if (ok == false) {
			System.out.println("Sorry, no games are without an "
					+ "officials. Please create a new game.");
		}
		System.out.println("==============");
		System.out.println();
		return ok;
	}

	public void runGames() throws IOException {
		boolean keepgoing = true;	 
		for (Game g : getGames()) {
			if (g.getGameStatus().equals("Active") && g.getAthletes().size() < 4) {
				System.out.println("WARNING: " + g.getGameID() + " does not have at ");
				System.out.println("least 4 participants.");
				System.out.println("If you would like to go back, please press 1.");
				System.out.println("To cancel this games and continue, press 2");
				int MIN_CH = 1, MAX_CH = 2;
				int choice = numCheck(MIN_CH, MAX_CH);
				if (choice == 1) {
					keepgoing = false;
				}
				else if (choice == 2){
					g.setGameStatus("Cancelled");
				}
			}
		}
		if (keepgoing == true) {
			for (Game x : getGames()) {
				if (x.getGameStatus().equals("Active") && x.getOfficial() == null) {
					System.out.println("WARNING: " + x.getGameID() 
							+ " does not have an official.");
					System.out.println("If you would like to go back, please press 1.");
					System.out.println("To cancel these games and continue, press 2: ");
					int MIN_CH = 1, MAX_CH = 2;
					int choice = numCheck(MIN_CH, MAX_CH);
					if (choice == 1) {
						keepgoing = false;
					}
					else if (choice == 2){
						x.setGameStatus("Cancelled");
					}
				}
			}
		}
		if (keepgoing == true) {
			positionCalculation();
			System.out.println("All games have now run!");
			System.out.println();
		}
	}

	public void positionCalculation() {
		Athlete pos1 = null, pos2 = null, pos3 = null;
		int time1 = 1000, time2 = 1000, time3 = 1000; 
		int time = 0;
		int tempTime, tempTime2;
		Athlete tempAthlete, tempAthlete2 = null;
		for (Game y : getGames()) {
			int gameNum = 1;
			System.out.println("GAME " + gameNum);
			if (y.getGameStatus().equals("Active")) {
				for (Athlete z : y.getAthletes()) {
					time = z.compete(y.getGameType());
					if (time1 > time) {
						tempTime = time1;
						tempAthlete = pos1;
						time1 = time;
						pos1 = z;
						if (time2 > tempTime) {
							if (time2 == 1000) {
								continue;
							}
							tempTime2 = time2;
							tempAthlete2 = pos2;
							time2 = tempTime;
							pos2 = tempAthlete;
							if (time3 > tempTime2) {
								time3 = tempTime2;
								pos3 = tempAthlete2;
							}
						}
					}
					else if (time2 > time) {
						tempTime = time2;
						tempAthlete = pos2;
						time2 = time;
						pos2 = z;
						if (time3 > tempTime) {
							time3 = tempTime;
							pos3 = tempAthlete;
						}
					}	
					else if (time3 > time) {
						time3 = time;
						pos3 = z;
					}
				}
			}
			System.out.println("First place: " + pos1.getPersonID() 
					+ " - " + time1 + " seconds");
			pos1.setPoints(5);
			System.out.println("Second place: " + pos2.getPersonID() 
					+ " - " + time2 + " seconds");
			pos2.setPoints(2);
			System.out.println("Third place: " + pos3.getPersonID() 
					+ " - " + time3 + " seconds");
			pos3.setPoints(1);
			System.out.println("==============");
			gameNum++;
		}	
	}

	public void printGameResults() {
		System.out.println("ATHLETES AND RESULTS: ");
		for (Game y : getGames()) {
				for (Athlete z : y.getAthletes()) {
					System.out.println("Name: " + z.getName() 
							+ " Person ID: " + z.getPersonID() 
							+ "Sport: " + z.getSport() + " Age: " 
							+ z.getAge() + " State: " 
							+ z.getState() + " Total points: " 
							+ z.getPoints());
				}
		}
		System.out.println();
	}

	public boolean checkNoGames() {
		boolean check;
		if (games.isEmpty()) {
			check = true;
			System.out.println("You must create a game first!");
			System.out.println();
		}
		else {
			check = false;
		}
		return check;
	}

	//check input is within min and max num boundaries
	private int numCheck(int min, int max) throws IOException {
		int num = charCheck();
		final int MIN = min;
		final int MAX = max;
		while (num < MIN || num > MAX) {
			System.out.println("Please enter a number between " 
					+ min + " and " + max + ".");
			num = charCheck();
		}
		return num;
	}   

	//check for String characters in numeric input
	private int charCheck() throws IOException {
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
