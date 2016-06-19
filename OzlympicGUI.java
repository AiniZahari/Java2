/*Author: Siti Nur Aini ZAHARI
Student Number: s3460603
This is the GUI class for Ozlympic*/


import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class OzlympicGUI extends JFrame
{
 JPanel participantPanel = new JPanel();
 JPanel officialPanel = new JPanel();
 JPanel gamePanel = new JPanel();
 JPanel runPanel = new JPanel();
 JPanel resultPanel = new JPanel();
 JPanel pointsPanel = new JPanel();
 JPanel ozlympicPanel = new JPanel();
 private ArrayList<Person> people = new ArrayList<Person>();
 private ArrayList<Game> games = new ArrayList<Game>();
 ArrayList<Official> officials = new ArrayList<Official>();
 
 public static void main(String[] args)throws IOException // set main 
 {
  OzlympicGUI gui = new OzlympicGUI();
  gui.setVisible(true); 
 }
 Game game = new Game();
 Athlete athlete = new Athlete();
 Official official = new Official();
 PersonController personConObj = new PersonController();
 GameController gameConObj = new GameController();
 
 public OzlympicGUI()throws IOException
 {
  super("-= Welcome to Ozlympic =-"); //set title
  setSize(600, 750); //set frame size
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit completely when program close
  setVisible(true);
  
  ozlympicPanel.setPreferredSize(new Dimension(600, 750));
  participantPanel.setPreferredSize(new Dimension(600, 750));
  officialPanel.setPreferredSize(new Dimension(600, 750));
  gamePanel.setPreferredSize(new Dimension(600, 750));
  runPanel.setPreferredSize(new Dimension(600, 750));
  resultPanel.setPreferredSize(new Dimension(600, 750));
  pointsPanel.setPreferredSize(new Dimension(600, 750));
  
  JMenu ozlympicMenu = new JMenu("Click for option"); // instantiate from JMenu class (main menu)
  JMenuBar bar = new JMenuBar(); //instantiate from JMenuBar(great menu)
  bar.add(ozlympicMenu);
  setJMenuBar(bar); 
  
  JMenuItem participantMenu = new JMenuItem("Create athlete"); // instantiate from JMenuItem class (sub menu)
  JMenuItem officialMenu = new JMenuItem("Create official");
  JMenuItem gameMenu = new JMenuItem("Create a game");
  JMenuItem runMenu = new JMenuItem("Run all unfinished games");
  JMenuItem resultMenu = new JMenuItem("Display final results of finished games");
  JMenuItem pointsMenu = new JMenuItem("Display athlete's accumulated points");
  JMenuItem QuitMenu = new JMenuItem("Quit Ozlympic");
 
  ozlympicMenu.add(participantMenu); // plug all sub menu to main menu
  ozlympicMenu.add(officialMenu);
  ozlympicMenu.add(gameMenu);
  ozlympicMenu.add(runMenu);
  ozlympicMenu.add(resultMenu);
  ozlympicMenu.add(pointsMenu);
  ozlympicMenu.add(QuitMenu);
  
  //Create Athlete Object 
  Container cParticipant = getContentPane();
  cParticipant.setLayout(new FlowLayout());
  ButtonGroup participant = new ButtonGroup();
  JLabel labelParticipant = new JLabel("Create Athlete                                                                    ");
  JLabel labelIDparticipant = new JLabel("                   ID Number :");
  JLabel labelName = new JLabel("                                                                  Name :");
  JLabel labelAge = new JLabel("Age :");
  JLabel labelState = new JLabel("  State :");
  final JComboBox states = new JComboBox();
  states.addItem("VIC"); states.addItem("QLD");
  states.addItem("NSW"); states.addItem("NT");
  states.addItem("SA"); states.addItem("TAS");
  states.addItem("WA"); states.addItem("ACT");
  final JLabel labelsport = new JLabel("          Sports:");
  final JComboBox sports = new JComboBox();
  sports.addItem("Swimming"); sports.addItem("Cycling");
  sports.addItem("Running"); sports.addItem("SuperAthlete");
  final JTextArea textPart = new JTextArea(10, 50);
  final JTextField textIDparticipant = new JTextField(7);
  textIDparticipant.setText(personConObj.createAthID());
  final JTextField textName = new JTextField(15);
  final JTextField textAge = new JTextField(2);
  JTextField textState = new JTextField(3);
  final JTextArea textAthlete = new JTextArea(1, 50);
  JButton addAthlete = new JButton("Add Athlete");
  JButton newAthlete = new JButton("New Athlete");
  
  //Create Official Object
  JLabel labelOfficial = new JLabel("Create Official                                                                    ");
  JLabel labelIDOfficial = new JLabel("                   ID Number :");
  JLabel labelOfficialName = new JLabel("                                                                  Name :");
  JLabel labelOfficialAge = new JLabel("Age :");
  JLabel labelOfficialState = new JLabel("  State :");
  final JComboBox Officialstates = new JComboBox();
  Officialstates.addItem("VIC"); Officialstates.addItem("QLD");
  Officialstates.addItem("NSW"); Officialstates.addItem("NT");
  Officialstates.addItem("SA"); Officialstates.addItem("TAS");
  Officialstates.addItem("WA"); Officialstates.addItem("ACT");
  final JTextField textIDOfficial = new JTextField(7);
  textIDOfficial.setText(personConObj.createOffID());
  final JTextField textOfficialName = new JTextField(15);
  final JTextField textOfficialAge = new JTextField(2);
  JTextField textOfficialState = new JTextField(3);
  final JTextArea textOfficialPart = new JTextArea(1, 50);
  JButton addOfficial = new JButton("Add Official");
  JButton newOfficial = new JButton("New Official");
  
  //Create Game Object
  JLabel labelGame = new JLabel("Create Game                                                                      ");
  JLabel labelType = new JLabel("Game Type:");
  JLabel labelAthleteList = new JLabel("Athlete's List:");
  final JComboBox sports1 = new JComboBox();
  sports1.addItem("Swimming"); sports1.addItem("Cycling");
  sports1.addItem("Running");
  JLabel labelGameID = new JLabel("ID Number :");
  final JTextArea textGame1 = new JTextArea(10, 50);
  textGame1.setText("Please click Athlete List button.");
  final JComboBox officials = new JComboBox();
  officials.addItem("");
  JLabel labelAthlete1 = new JLabel("                                 Athlete 1:");
  JLabel labelAthlete2 = new JLabel("Athlete 2 ID:");
  JLabel labelAthlete3 = new JLabel("Athlete 3 ID:");
  JLabel labelAthlete4 = new JLabel("Athlete 4 ID:");
  JLabel labelAthlete5 = new JLabel("Athlete 5 ID:");
  JLabel labelAthlete6 = new JLabel("Athlete 6 ID:");
  JLabel labelAthlete7 = new JLabel("Athlete 7 ID:");
  JLabel labelAthlete8 = new JLabel("Athlete 8 ID:");
  
  final JTextField textGameID = new JTextField(7);
  JTextField textAthlete1 = new JTextField(5);
  JTextField textAthlete2 = new JTextField(5);
  JTextField textAthlete3 = new JTextField(5);
  JTextField textAthlete4 = new JTextField(5);
  JTextField textAthlete5 = new JTextField(5);
  JTextField textAthlete6 = new JTextField(5);
  JTextField textAthlete7 = new JTextField(5);
  JTextField textAthlete8 = new JTextField(5);
  JButton createGame = new JButton("Create Game");
  JButton AthleteList = new JButton("Athlete List");
 
  //Run Unfinished Game Object
  JLabel labelRunGame = new JLabel("Run Unfinished Game           ");
  final JTextArea textGame = new JTextArea(10, 50);
  JTextField textFinishRun = new JTextField(5);
  JButton getGame = new JButton("Get Unfinished Game List");
  JButton runGame = new JButton("Run Game");
  
  //Create Display Final Results Object  
  JLabel labelFinalResult = new JLabel("Display Final Results           ");
  final JTextArea textResult = new JTextArea(10, 50);
  JButton displayResult = new JButton("Display Results");
  
  //Display Athlete's Points Object
  JLabel labelAthletePoints = new JLabel("Display Athlete's Points       "); 
  final JTextArea textAthletePoints = new JTextArea(10, 50);
  JButton displayAthletePoints = new JButton("Display Athlete's Points");
  
  add(ozlympicPanel);
  
 //Create Athlete Panel 
  participantPanel.add(labelParticipant);
  participantPanel.add(labelIDparticipant); participantPanel.add(textIDparticipant); 
  participantPanel.add(labelsport);participantPanel.add(sports);participantPanel.add(labelName); participantPanel.add(textName); 
  participantPanel.add(labelAge); participantPanel.add(textAge);
  participantPanel.add(labelState); participantPanel.add(states);
  participantPanel.add(addAthlete);participantPanel.add(newAthlete);
  participantPanel.add(textAthlete);  
  
  addAthlete.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent ae)
   {   
	String aID, name, sport, age;
	String state;
	
	aID = textIDparticipant.getText();
	name = textName.getText();
	age =textAge.getText();
	//age = Integer.parseInt(age1);
	state = (String) states.getSelectedItem();
	sport = (String) sports.getSelectedItem();
	
	Athlete athlete = new Athlete(aID, name, age, state, sport);
	personConObj.addPeople(athlete);
	textAthlete.setText("Athlete entered successfully.");
   }
  }); 
  
  newAthlete.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent ae)
   {   
	textAthlete.setText(" ");
    textName.setText(" ");
	textAge.setText(" ");
	textIDparticipant.setText(personConObj.createAthID());
   }
  }); 
  
  //Create Official Panel 
  officialPanel.add(labelOfficial);
  officialPanel.add(labelIDOfficial); officialPanel.add(textIDOfficial); 
  officialPanel.add(labelOfficialName); officialPanel.add(textOfficialName); 
  officialPanel.add(labelOfficialAge); officialPanel.add(textOfficialAge);
  officialPanel.add(labelOfficialState); officialPanel.add(Officialstates);
  officialPanel.add(addOfficial);officialPanel.add(newOfficial);
  officialPanel.add(textOfficialPart);
  
  addOfficial.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent ae)
   {   
    String oID, oName, oAge1;
    int oAge;
	String oState;
		
	oID = textIDOfficial.getText();
	oName = textOfficialName.getText();
	oAge1 = textOfficialAge.getText();
	oState = (String)Officialstates.getSelectedItem();
		
	Official official = (new Official(oID, oName, oAge1, oState));
	personConObj.addPeople(official);	
	textOfficialPart.setText("Official entered successfully.");
   }	 
  });
 
  newOfficial.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent ae)
   {   
	textOfficialPart.setText(" ");
	textOfficialName.setText(" ");
	textOfficialAge.setText(" ");
	textIDOfficial.setText(personConObj.createOffID());
   }
  }); 
  
  //Create Game Object
  gamePanel.add(labelGame); 
  gamePanel.add(labelGameID ); gamePanel.add(textGameID ); gamePanel.add(sports1); 
  gamePanel.add(labelAthleteList);gamePanel.add(AthleteList);gamePanel.add(textGame1);
  gamePanel.add(officials); 
  gamePanel.add(labelAthlete1 ); gamePanel.add(textAthlete1 );
  gamePanel.add(labelAthlete2 ); gamePanel.add(textAthlete2 );
  gamePanel.add(labelAthlete3 ); gamePanel.add(textAthlete3 );
  gamePanel.add(labelAthlete4 ); gamePanel.add(textAthlete4 );
  gamePanel.add(labelAthlete5 ); gamePanel.add(textAthlete5 );
  gamePanel.add(labelAthlete6 ); gamePanel.add(textAthlete6 );
  gamePanel.add(labelAthlete7 ); gamePanel.add(textAthlete7 );
  gamePanel.add(labelAthlete8 ); gamePanel.add(textAthlete8 );
  gamePanel.add(createGame); 
 
  AthleteList.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent ae)
   {   
	String athletes = "";
	String sportChoice = (String) sports1.getSelectedItem();
	for (Person p : personConObj.getPeople()) 
	{
	 if (p instanceof Athlete) 
	 {
	  if (((Athlete)p).getSport().equals(sportChoice) || ((Athlete)p).getSport() == "SuperAthlete") 
	  {
	   if (((Athlete)p).getStatus() == "Unassigned") 
	   {
		athletes +=(p.getPersonID() + " " + p.getName())+ "\n";
	   }
	  }
	 }
	}
	textGame1.setText(athletes);
   } 
  }); 
 
  createGame.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent ae)
   {   
	  String gID, gType;
	  gID = textGameID.getText(); 
	  gType = (String) sports1.getSelectedItem(); 
	  Game game = (new Game(gID, gType));
	  games.add(game); 
   } 
  }); 
  
  //Run Unfinished Game Panel
  runPanel.add(labelRunGame);
  runPanel.add(textGame);
  runPanel.add(getGame);
  runPanel.add(runGame);
  textGame.setText("Please click the 'Get Unfinished Game List' button");
  
  getGame.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent ae)
   {   
	gameConObj.getGames(); 
   }	 
  });
  
  runGame.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent ae)
   {   
	   Athlete pos1 = null, pos2 = null, pos3 = null;
		int time1 = 800, time2 = 800, time3 = 800; 
		for (Game y : gameConObj.getGames()) {
			for (int z = 0; z < gameConObj.getGames(z).getAthletes().size(); z++) {
				int time = 0;// = getGames(b).getAthletes(b).compete(getGames(a).getGameType());
				if (time < time1) {
					time1 = time;
					//pos1 = getGames(b).getAthletes(b));
				}
				else if (time < time2) {
					time2 = time1;
					//pos2 = getGames(b).getAthletes(b));
				}	
				else if (time < time3) {
					time3 = time2;
					//pos3 = getGames(b).getAthletes(b));
				}
			}
		}
   }	 
  });
  textFinishRun.setText("All games have now run!");
  
  //Create Display Final Results Panel
  resultPanel.add(labelFinalResult);
  resultPanel.add(textResult);
  resultPanel.add(displayResult);
  textResult.setText("Please click the 'Display Results' button");
  
  displayResult.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent ae)
   {   
	String athletes1 = "";
    for (Game y : gameConObj.getGames()) {
	 for (Athlete z : y.getAthletes()) {
	  athletes1 += z.getName()+ z.getPersonID()+ z.getSport()+ z.getAge()+ z.getState() + z.getPoints()+ "\n";
	  }
	}
	textResult.setText(athletes1);
   }	 
  });
  
//Display Athlete's Points Panel
  pointsPanel.add(labelAthletePoints);
  pointsPanel.add(textAthletePoints);
  pointsPanel.add(displayAthletePoints);
  textAthletePoints.setText("Please click the 'Display Athlete's Points' button");
 
  displayAthletePoints.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent ae)
   {   
	String athletes2 = "";
	for (Game y : gameConObj.getGames()) {
	 for (Athlete z : y.getAthletes()) {
	  athletes2 += z.getName() + z.getPersonID()+ z.getPoints()+ "\n";;
	  }
	 }
	 textAthletePoints.setText(athletes2);
   }	 
  });
  
  participantMenu.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent ae)
   {   
    if (ozlympicPanel.isShowing())
    {
     remove(ozlympicPanel);
     add(participantPanel, BorderLayout.CENTER);  
    }
    if (officialPanel.isShowing())
    {
     remove(officialPanel);
     add(participantPanel, BorderLayout.CENTER);  
    }
    if (gamePanel.isShowing())
    {
     remove(gamePanel);
     add(participantPanel, BorderLayout.CENTER);  
    }
    if (runPanel.isShowing())
    {
     remove(runPanel);
     add(participantPanel, BorderLayout.CENTER);  
    }
    if (resultPanel.isShowing())
    {
     remove(resultPanel);
     add(participantPanel, BorderLayout.CENTER);  
    }
    if (pointsPanel.isShowing())
    {
     remove(pointsPanel);
     add(participantPanel, BorderLayout.CENTER);  
    }
    validate();
    repaint();
   }
  });
  
  officialMenu.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent ae)
   {   
    if (ozlympicPanel.isShowing())
    {
     remove(ozlympicPanel);
     add(officialPanel, BorderLayout.CENTER);  
    }
    if (participantPanel.isShowing())
    {
     remove(participantPanel);
     add(officialPanel, BorderLayout.CENTER);  
    }
    if (gamePanel.isShowing())
    {
     remove(gamePanel);
     add(officialPanel, BorderLayout.CENTER);  
    }
    if (runPanel.isShowing())
    {
     remove(runPanel);
     add(officialPanel, BorderLayout.CENTER);  
    }
    if (resultPanel.isShowing())
    {
     remove(resultPanel);
     add(officialPanel, BorderLayout.CENTER);  
    }
    if (pointsPanel.isShowing())
    {
     remove(pointsPanel);
     add(officialPanel, BorderLayout.CENTER);  
    }
    validate();
    repaint();
   }
  });
  
  gameMenu.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent ae)
   {   
    if (ozlympicPanel.isShowing())
    {
     remove(ozlympicPanel);
     add(gamePanel, BorderLayout.CENTER);  
    }
    if (participantPanel.isShowing())
    {
     remove(participantPanel);
     add(gamePanel, BorderLayout.CENTER);  
    }
    if (officialPanel.isShowing())
    {
     remove(officialPanel);
     add(gamePanel, BorderLayout.CENTER);  
    }
    if (runPanel.isShowing())
    {
     remove(runPanel);
     add(gamePanel, BorderLayout.CENTER);  
    }
    if (resultPanel.isShowing())
    {
     remove(resultPanel);
     add(gamePanel, BorderLayout.CENTER);  
    }
    if (pointsPanel.isShowing())
    {
     remove(pointsPanel);
     add(gamePanel, BorderLayout.CENTER);  
    }
    validate(); 
    repaint();
   }
  });
  
  runMenu.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent ae)
   {   
    if (ozlympicPanel.isShowing())
    {
     remove(ozlympicPanel);
     add(runPanel, BorderLayout.CENTER);  
    }
    if (participantPanel.isShowing())
    {
     remove(participantPanel);
     add(runPanel, BorderLayout.CENTER);  
    }
    if (officialPanel.isShowing())
    {
     remove(officialPanel);
     add(runPanel, BorderLayout.CENTER);  
    }
    if (gamePanel.isShowing())
    {
     remove(gamePanel);
     add(runPanel, BorderLayout.CENTER);  
    }
    if (resultPanel.isShowing())
    {
     remove(resultPanel);
     add(runPanel, BorderLayout.CENTER);  
    }
    if (pointsPanel.isShowing())
    {
     remove(pointsPanel);
     add(runPanel, BorderLayout.CENTER);  
    }
    validate(); 
    repaint();
   }
  });
  
  resultMenu.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent ae)
   {   
    if (ozlympicPanel.isShowing())
    {
     remove(ozlympicPanel);
     add(resultPanel, BorderLayout.CENTER);  
    }
    if (participantPanel.isShowing())
    {
     remove(participantPanel);
     add(resultPanel, BorderLayout.CENTER);  
    }
    if (officialPanel.isShowing())
    {
     remove(officialPanel);
     add(resultPanel, BorderLayout.CENTER);  
    }
    if (gamePanel.isShowing())
    {
     remove(gamePanel);
     add(resultPanel, BorderLayout.CENTER);  
    }
    if (runPanel.isShowing())
    {
     remove(runPanel);
     add(resultPanel, BorderLayout.CENTER);  
    }
    if (pointsPanel.isShowing())
    {
     remove(pointsPanel);
     add(resultPanel, BorderLayout.CENTER);  
    }
    validate(); 
    repaint();
   }
  });
  
  pointsMenu.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent ae)
   {   
    if (ozlympicPanel.isShowing())
    {
     remove(ozlympicPanel);
     add(pointsPanel, BorderLayout.CENTER);  
    }
    if (participantPanel.isShowing())
    {
     remove(participantPanel);
     add(pointsPanel, BorderLayout.CENTER);  
    }
    if (officialPanel.isShowing())
    {
     remove(officialPanel);
     add(pointsPanel, BorderLayout.CENTER);  
    }
    if (gamePanel.isShowing())
    {
     remove(gamePanel);
     add(pointsPanel, BorderLayout.CENTER);  
    }
    if (resultPanel.isShowing())
    {
     remove(resultPanel);
     add(pointsPanel, BorderLayout.CENTER);  
    }
    if (runPanel.isShowing())
    {
     remove(runPanel);
     add(pointsPanel, BorderLayout.CENTER);  
    }
    validate();    
    repaint();
   }
  });
  
  QuitMenu.addActionListener(new ActionListener()
  {
   public void actionPerformed(ActionEvent ae)
   {   
	System.exit(0); 
   }	 
  });
 }

private String createGameID(String string) {
	// TODO Auto-generated method stub
	return null;
}

protected String getSelectedItem(JComboBox sports1) {
	// TODO Auto-generated method stub
	return null;
}
}