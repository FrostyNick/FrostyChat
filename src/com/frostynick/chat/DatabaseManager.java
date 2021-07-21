package com.frostynick.chat;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public abstract class DatabaseManager {
	private static ArrayList<User> users = new ArrayList<User>();
	private static ArrayList<Integer> takenIds = new ArrayList<Integer>();
	private static Random rand = new Random();
	
	// is this being used?
	public static void addAccount(User user) {
		users.add(user);
	}
	
//	public static User loginAccount(Scanner sn) {
//		Display.print("Enter your username: ");
//		
//		String username = sn.next();
//		Account acc = new Account(username);
//		addAccount(acc);
//		Display.println(acc.toString());
//		
//		return acc;
//	}
	
	public static Account createAccount(Scanner sn) {
		Display.print("Create a username: ");
		
		String username = sn.next();
		Account acc = new Account(username);
		addAccount(acc);
		Display.println(acc.toString());
		
		return acc;
	}

	public static int getIdByName(String name) {
		// TODO Auto-generated method stub
		int id = -1;
		for (User u : users) {
			if (u.getName().equals(name)) {
				id = u.getId();
				break;
			}
		}
		return id;
	}

	public static String getNameById(int id) {
		// TODO Auto-generated method stub
		String name = null;
		for (User u : users) {
			if (u.getId() == id) {
				name = u.getName();
				break;
			}
		}
		return name;
	}
	
	public static int generateUniqueId() {
		int id;
		
		// 11, 21, 31, ...
		// 
		// 
		if (takenIds.size() == 0) {
			id = rand.nextInt(10) + 1;
			
			takenIds.add(id);
//			Display.println("New ID: " + id);
			return id;
		}
		
		do {
//			Display.print("Looping..");
			id = rand.nextInt(10 * (takenIds.size() + 1)) + 1; // extra unneeded call
			// private char [] password = {'!'};
			for (int pId : takenIds) {
				if (pId == id) { // check if the id is taken
					id = -1;
					break;
				}
//				Display.print(pId + " != " + id + " ");
			}
//			try {
//				Thread.sleep(100); // in case there's an infinite loop
//			} catch(InterruptedException e) {
//				Display.println("Program interrupted");
//			}
		} while (id == -1);
		
//		Display.println("New ID: " + id);
		takenIds.add(id);
		return id;
	}
	
	public static String formatUserInfo(int id) {
		StringBuilder sb = new StringBuilder();
		sb.append(" ---- ACCOUNT INFO ----")
		  .append("\n  USERNAME: ")
		  .append(DatabaseManager.getNameById(id))
		  .append("\n        ID: ")
		  .append(id != 0 ? id : "Guest account (0)");
		
		return sb.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		// never include passwords
		sb.append("{\n\"database\" : \n{");
		for (int i = 0; i < users.size(); i++) {
//			sb.append(u.toString())
			sb.append("\"index\" : \"")
			  .append(i)
			  .append("\", \"user\" : ")
			  .append(users.get(i).toString());
		}
		sb.append("\n}");
		return sb.toString();
	}

	
//	public char[] getPassword() { // remove this later
//	return password;
//}

//public void setPassword() {
//	// send email to set new password
//}
//
}
