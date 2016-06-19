/* Author: Anne-Marie E. CAREY
 * s3267939@student.rmit.edu.au 
 */


import java.util.*;

public class Game {
	private ArrayList<Athlete> gameParticipants = new ArrayList<Athlete>();
	private Official gameOfficial;
	private String gameID;
	private String gameType;
	private String gameStatus;
	private Athlete pos1, pos2, pos3;

	public Game() {
	}
	
	public Game(String ID, String type) {
		this.gameID = ID;
		this.gameType = type;
		this.gameStatus = "Active";
		this.gameParticipants = new ArrayList<Athlete>();
		this.gameOfficial = null;
	}
	
	public ArrayList<Athlete> getAthletes() {
		return gameParticipants;
	}
	
	public void setAthletes(Athlete a) {
		this.gameParticipants.add(a);
	}
	
	public Official getOfficial() {
		return gameOfficial;
	}

	public void setOfficial(Official offSelect) {
		this.gameOfficial = offSelect;
	}

	public Athlete getPos1() {
		return pos1;
	}

	public void setPos1(Athlete pos1) {
		this.pos1 = pos1;
	}

	public Athlete getPos2() {
		return pos2;
	}

	public void setPos2(Athlete pos2) {
		this.pos2 = pos2;
	}

	public Athlete getPos3() {
		return pos3;
	}

	public void setPos3(Athlete pos3) {
		this.pos3 = pos3;
	}

	public String getGameID() {
		return gameID;
	}

	public String getGameType() {
		return gameType;
	}
	
	public String getGameStatus() {
		return gameStatus;
	}
	
	public void setGameStatus(String status) {
		this.gameStatus = status;
	}
}