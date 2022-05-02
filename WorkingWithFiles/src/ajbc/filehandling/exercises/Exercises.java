package ajbc.filehandling.exercises;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Exercises {

	public static void main(String[] args) {
		exe1();
	}

	public static void exe1() {

		int wordCounter = 0, lineCounter = 0;
		String word = "", sentence = "";
		try (FileReader reader = new FileReader("myFiles/alice.txt");) {
			int intCh;
			do {
				intCh = reader.read();
				char ch = (char) intCh;
				if (ch == '\n') {
					lineCounter++;
					wordCounter++;
				}
				else if (ch == ' ')
					wordCounter++;
				if (wordCounter == 577)
					word += ch;
				if (lineCounter == 17)
					sentence += ch;
			} while (intCh != -1);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("word count : " + wordCounter);
		System.out.println("line count : " + lineCounter);
		System.out.println("word 578 : " + word);
		System.out.println("sentence 18 : " + sentence);
	}

}
