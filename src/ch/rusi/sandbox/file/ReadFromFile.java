package ch.rusi.sandbox.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ReadFromFile {

	@SuppressWarnings("SpellCheckingInspection")
	File file = new File("files/namegen/lastnames.txt");
	Date timeStart = null;
	Date timeEnd = null;

	public static void main(String[] args) throws IOException {
		
		ReadFromFile reader = new ReadFromFile();
		reader.readBufferedReader();
		reader.readFileReader();
		reader.readScanner();

	}
	
	private void readBufferedReader() throws IOException {

		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Reading file with BufferedReader");
		System.out.println("--------------------------------------------------------------------------------");

		ArrayList<String> names = new ArrayList<>();

		timeStart = new Date();

		FileReader fr;
		BufferedReader br;

		fr = new FileReader(file);
		br = new BufferedReader(fr);
		
		String name;
		while ((name = br.readLine()) != null) {
			names.add(name);
		}
		br.close();
		fr.close();

		timeEnd = new Date();
		
		System.out.println("Number of names read from file: " + names.size());
		System.out.print("Duration: ");
		System.out.println(timeEnd.getTime() - timeStart.getTime());

	}
	
	private void readFileReader() throws IOException {
		
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Reading file with FileReader");
		System.out.println("--------------------------------------------------------------------------------");

		// Reading one character after the other out of the FileReader ---------------------
		
		System.out.println("One character after the other:");
		
		timeStart = new Date();

		FileReader fr;
		
		timeStart = new Date();
		fr = new FileReader(file);

		int count = 0;
		int charVal;
		while (( charVal = fr.read()) != -1 && count < 100 ) {
			count++;
            System.out.printf("%-3d : %s%n", charVal, (char)charVal);

		}
		fr.close();
		
		timeEnd = new Date();
		
		System.out.println("Number of chars read from file: " + count);
		System.out.print("Duration: ");
		System.out.println(timeEnd.getTime() - timeStart.getTime());
		
		// Read a specified number of chars directly into char array ----------------------------

		System.out.println("Read a specified number of chars directly into char array:");

		fr = new FileReader(file);
		char[] charBuffer = new char[500];
		int numberOfCharsRead = fr.read(charBuffer, 0, 100);

		System.out.println("Number of chars read from file " + file + " : " + numberOfCharsRead);
		System.out.println(charBuffer);
		
		fr.close();

	}
	
	private void readScanner() throws IOException {
		
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Reading file with Scanner");
		System.out.println("--------------------------------------------------------------------------------");
		
		Scanner scan = new Scanner(file);
		
		int count = 0;
		
		Pattern pattern = Pattern.compile(".*Meier.*");
		while(scan.hasNext()) {
			if (scan.hasNext(pattern)) {
				System.out.println(scan.next());
				count++;
			} else {
				scan.next();
			}
		}
		
		scan.close();
		
		System.out.println("Number of patterns found : " + count);
		
	}

}
