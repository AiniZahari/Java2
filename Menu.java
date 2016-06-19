/* Author: Siti Nur Aini ZAHARI
 * Student Number: s3460603
 */


import java.util.*;
import java.io.*;

public class Menu {
	GameController gameConObj = new GameController();
	PersonController personConObj = new PersonController();
	FileHandler file = new FileHandler();
	Scanner reader = new Scanner(System.in);
	String sportChoice;
	boolean preCheck;
	Person offSelect = null;
	Game gameSelect = null;
	Athlete athSelect = null;
	String offSel = null;
	String gamSel = null;
	String athSel = null;
	
	//basic main menu controls
	public Menu() throws IOException {
		//initialisation 
		initialise();
		int choice = 0;
		do {
			mainMenu();
			choice = numCheck(1, 6);
			if(choice==1) {
				subMenu1();
			}
			else if(choice==2) {
				subMenu2();
			}
			else if(choice==3) {
				gameConObj.runGames();
			}
			else if(choice==4) {
				gameConObj.printGameResults();
			}
			else if(choice==5) {
				printPoints();
			}
		}
		while(choice!=6);
		System.out.println("Thank you");
		file.writeGame();
		file.readGame();
	}

	//Used to fill the model with fake data.
	private void initialise(){
		Game game = new Game("1", "Running");
		Athlete at;
		for (int i = 0; i<7; i++){
			at = new Athlete("p"+i,"test "+i,"12","VIC", "Running");
			personConObj.addPeople(at);
			game.setAthletes(at);
		}
		Official of = new Official("official", "oficial name", "14", "VIC");
		personConObj.addPeople(of);
		game.setOfficial(of);
		gameConObj.addGame(game);
	}

	//print main selection items
	private void mainMenu() {
		System.out.println("Ozlympic Game");
		System.out.println("==============");
		System.out.println("1. Add an athlete");
		System.out.println("2. Appoint officials");
		System.out.println("3. Start the games");
		System.out.println("4. Display the final results");
		System.out.println("5. Display the points of athletes");
		System.out.println("6. Exit");
		System.out.println();
		System.out.println("Enter an option:");
	}

	//print submenu items for option 1
	private void subMenu1() throws IOException {
		System.out.println("Please select from the following options: ");
		System.out.println("1. Create an athlete");
		System.out.println("2. Add an athlete to a game");
		System.out.println("3. Create a game");
		int MIN_CH = 1, MAX_CH = 3;
		int choice2 = numCheck(MIN_CH, MAX_CH);
		if (choice2 == 1) {
			createAthlete();			
		}
		else if (choice2 == 2) {
			addAthleteInstructions();
		}
		else if (choice2 == 3) {
			createGame();
		}
	}

	//print submenu items for option 2
	private void subMenu2() throws IOException {
		System.out.println("Please select from the following options: ");
		System.out.println("1. Create an official");
		System.out.println("2. Add an official to a game");
		System.out.println("3. Create a game");
		int MIN_CH = 1, MAX_CH = 3;
		int choice2 = numCheck(MIN_CH, MAX_CH);
		if (choice2 == 1) {
			createOfficial();
		}
		else if (choice2 == 2) {
			addOfficialInstructions();
		}
		else if (choice2 == 3) {
			createGame();
		}
	}

	private void addOfficialInstructions() throws IOException {
		preCheck = true;
		//checks there are officials to allocate to a game
		if (personConObj.checkNoOffs() == true) {
			preCheck = false;
			System.out.println("You must create an official first!");
			System.out.println();
		}
		//checks there are games to allocate the official to
		else if (gameConObj.checkNoGames() == true) {
			preCheck = false;
		}
		else if (preCheck == true){
			preCheck = personConObj.findOfficials();
			if (preCheck == true) {
				System.out.println("Please type the ID of the official "
						+ "you would like to add from the list above: ");
				offSel = reader.next();
				preCheck = gameConObj.findGamesNoOfficial();
			}
			if (preCheck == true) {
				System.out.println("Please type the ID of the game you "
						+ "would like to add from the list above: ");
				gamSel = reader.next();
				preCheck = false;
				for (Person y : personConObj.getPeople()) {
					if (y.getPersonID().equals(offSel)) {
						offSelect = y;
						for (Game x : gameConObj.getGames()) {
							if (x.getGameID().equals(gamSel)) {
								x.setOfficial((Official)offSelect);
								preCheck = true;
							}
						}
					}
				}
				if (preCheck == false) {
					System.out.println("Sorry, your input does not match "
							+ "the data. Please try again.");
					System.out.println();
				}
				if (preCheck == true) {
					System.out.println("Official assigned to game successfully.");
					System.out.println();
				}
			}
		}
	}

	private void addAthleteInstructions() throws IOException {
		preCheck = true;
		if (personConObj.checkNoAths() == true) {
			preCheck = false;
			System.out.println("You must create an athlete first!");
			System.out.println();
		}
		else if (gameConObj.checkNoGames() == true) {
			preCheck = false;
		}
		else if (preCheck == true){
			System.out.println("Please enter the game type: ");
			sportChoice = gameConObj.selectGameType();
			preCheck = personConObj.findFreeAthletes(sportChoice);
			if (preCheck == true) {
				System.out.println("Please type the ID of the athlete "
						+ "you would like to add from the list above: ");
				athSel = reader.next();
				preCheck = gameConObj.findAvailGames(sportChoice);
				if (preCheck == true) {
					System.out.println("Please type the ID of the game "
							+ "you would like to add from the list above: ");
					gamSel = reader.next();
					preCheck = false;
					for (Person y : personConObj.getPeople()) {
						if (((Person) y).getPersonID().equals(athSel)) {
							((Athlete) y).setStatus("Assigned");
							for (Game x : gameConObj.getGames()) {
								if (((Game) x).getGameID().equals(gamSel)) {
									((Game) x).setAthletes(athSelect);
									preCheck = true;
								}
							}
						}
						if (preCheck == true) {
							System.out.println("Athlete assigned successfully "
									+ "to game.");
							System.out.println();
						}
						if (preCheck == false) {
							System.out.println("Sorry, your input does not "
									+ "match existing data. Please try again.");
							System.out.println();
						}
					}
				}
			}
		}
	}

	private void createAthlete() throws IOException {
		String aID = personConObj.createAthID();
		String aName = personConObj.enterName();
		String aAge = personConObj.enterAge();
		String aState = personConObj.selectState();
		System.out.println("Please select the athlete's sport: ");
		String athSport = personConObj.selectSport();
		Athlete athlete = new Athlete(aID, aName, aAge, aState, athSport);
		personConObj.addPeople(athlete);
		System.out.println("Athlete entered successfully.");
		System.out.println();
	}

	private void createOfficial() throws IOException {
		String oID = personConObj.createOffID();
		String oName = personConObj.enterName();
		String oAge = personConObj.enterAge();
		String oState = personConObj.selectState();
		Official official = new Official(oID, oName, oAge, oState);
		personConObj.addPeople(official);
		System.out.println("Official entered successfully.");
		System.out.println();
	}

	private void createGame() throws IOException {
		System.out.println("What game would you like to create?");
		String gameType = gameConObj.selectGameType();
		String gID = gameConObj.createGameID(gameType);
		Game game = new Game (gID, gameType);
		gameConObj.addGame(game);
		System.out.println("Game entered successfully.");
		System.out.println();
	}

	public void printPoints() {
		System.out.println("FINAL SCORES: ");
		for (Game y : gameConObj.getGames()) {
			for (Athlete z : y.getAthletes()) {
				System.out.println("Name: " + z.getName() + " Person ID: " 
			+ z.getPersonID() + "Total points: " + z.getPoints());
			}
		}
	}
	
	//check input is within min and max num boundaries
	private int numCheck(int min, int max) throws IOException {
		int num = charCheck();
		final int MIN = min;
		final int MAX = max;
		while (num < MIN || num > MAX) {
			System.out.println("Please enter a number between " + min 
					+ " and " + max + ".");
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
