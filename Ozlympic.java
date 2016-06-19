/* Author: Siti Nur Aini ZAHARI
 * Student Number: s3460603
 */


import java.io.*;
import java.util.*;

public class Ozlympic 
{
 Scanner reader = new Scanner(System.in);
 public static void main(String[] args) throws IOException 
 {
  if(args.length>0)
  {
   if(args[0].equals("-gui"))
   { 
	OzlympicGUI ui = new OzlympicGUI();
	ui.setVisible(true);
   }
  }
  Menu menu = new Menu();
 }
}


