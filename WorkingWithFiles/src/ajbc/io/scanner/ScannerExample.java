package ajbc.io.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Scanner;

public class ScannerExample {

	public static void readerDemo() {

		File file = new File("myFiles/output3.txt");

		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNext()) {
				int num;
				float fNum;
				String text = sc.next();
				try {
					num = Integer.parseInt(text);
					System.out.println(num);
				} catch (NumberFormatException e) {
					try {
						fNum = Float.parseFloat(text);
						System.out.println(fNum);
					} catch (NumberFormatException e1) {
						System.out.println(text);
					}
				}

			}

		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
