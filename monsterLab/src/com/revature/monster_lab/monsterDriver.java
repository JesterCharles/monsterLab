package com.revature.monster_lab;

//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.InvalidClassException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.security.InvalidAlgorithmParameterException;
//import java.util.Scanner;
//
//import com.revature.monster_lab.models.Scientist;
import com.revature.monster_lab.util.AppState;

/*
 * MonsterLab is a place for Mad Scientists to come together and create powerful
 * and intelligent monsters. 
 */

public class monsterDriver {

	public static void main(String[] args) {
		AppState app = new AppState();
		app.startup();
	}
}

//	public static void register() throws IOException {
//
//		System.out.println("The user selected register! ");
//
//		System.out.println("Please provide us with some basic information");
//		System.out.print("First Name: ");
//		String fname = consoleReader.readLine();
//
//		System.out.print("Last Name: ");
//		String lname = consoleReader.readLine();
//
//		System.out.print("Email: ");
//		String email = consoleReader.readLine();
//
//		System.out.print("Username: ");
//		String username = consoleReader.readLine();
//
//		System.out.print("Password: ");
//		String password = consoleReader.readLine();
//
//		// System.out.printf("Provided input: First Name: %s, Last Name: %s!, Email: %s, Username: %s, Password: %s", fname, lname, email, username, password);
//
//		// Scientist scientist = new Scientist("Charles", "Jester", "JesterCharles@mail.com", "jestchar", "superPassword");
//		Scientist scientist = new Scientist(fname, lname, email, username, password);
//		File scientistsPersistance = new File("resources/data.txt");
//		
//		// Try-with-resources, usable with any class that implements Closeable
//		try(FileWriter fileWriter = new FileWriter(scientistsPersistance, true); ){// Include true to append the data	
//			fileWriter.write(scientist.toFileString() + "\n");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		
//		// Serialization Example
//		try(FileOutputStream fileOut = new FileOutputStream("resources/scientists.ser");
//			ObjectOutputStream scientistOut = new ObjectOutputStream(fileOut)){
//			
//			scientistOut.writeObject(scientist);
//				
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		try(FileInputStream fileIn = new FileInputStream("resources/scientists.ser");
//				ObjectInputStream scientistIn = new ObjectInputStream(fileIn)){
//			
//			Scientist returnedScientist = (Scientist) scientistIn.readObject();
//			
//			System.out.println("Serialized Scientist has returned: " + returnedScientist);
//		} catch (IOException | ClassNotFoundException e) {
//			e.printStackTrace();
//			System.out.print(e.getMessage());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	
//	}

//	public static void ScannerDemo() {
//		System.out.println("quick scanner demo, input value: ");
//
//		Scanner consoleScanner = new Scanner(System.in);
//		String userInput = consoleScanner.next();
//		consoleScanner.close();
//		System.out.println("User also selected: " + userInput);
//	}

