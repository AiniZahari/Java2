/* Author: Anne-Marie E. CAREY
 * s3267939@student.rmit.edu.au 
 */



import java.io.*;

public class FileHandler { 
	public void writeGame() throws IOException {
		FileWriter writer = new FileWriter("save.dat");
		char a = 'A';
		writer.write(a); 
		writer.close();
	}

	public void readGame() throws IOException {
		FileReader reader = new FileReader("save.dat");
		int next = reader.read();
		char a = 0;
		if (next != -1) {
			a = (char)next;
		}
		reader.close();
	}
}