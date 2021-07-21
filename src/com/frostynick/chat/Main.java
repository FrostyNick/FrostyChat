package com.frostynick.chat;

import java.util.Scanner;

// BUGS: chat only works once

public abstract class Main {

	private static User myUser;
	private static Scanner sn;
	
	public static void main(String[] args) {
		sn = new Scanner(System.in);
		
		new Driver(sn);
		
		myUser = new User();
		Display.println("Welcome to FrostyChat :D\n");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			Display.println("Skipped delay.");
		}
		
		do {
			Display.println("\n-- MENU --");
		} while (menu());
		
		
		Display.println("You are leaving FrostyChat. Goodbye!");
		sn.close();	// bad idea
	}

	public static boolean menu() {
		String[] prompts = {"Chat", "Account Info", "Login", "Exit"};
		int response = 
		Display.prompt("What do you want to do?", prompts, sn);
		
		switch (response) {
		case 0:
// this should all be in the chat box element in the future
			Communities.getChatRoomWithUser(myUser, sn);
			break;
		case 1:
			Display.println(DatabaseManager.formatUserInfo(myUser.getId()));
			break;
		case 2:
			// login info doesn't save yet; in progress
			Display.print("WARNING: Account login is still being added. ");
			Display.println("This does nothing.");
			// UPDATE
			
			
			myUser = DatabaseManager.createAccount(sn); // it currently looks for an existing account
			
			
			break;
		default:
			Display.println("Non-existant prompt selected. (Response ID: " + response + ")");
			break;
		case 3:
			return false;
		}
		return true; // don't exit program
	}
}
