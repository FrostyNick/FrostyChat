package com.frostynick.chat;

import java.util.Date;
import java.util.Random;

public class Account extends User {
	private Date age;
	// private char [] password = {'!'};
	
	
	
	/**
	 * kinda hot ngl
	 * @param username duhh
	 */
	
//	public Account(int id) {
////		super(id); not defined
//		Display.print("Created account with id (might be broken)");
//		this.id = id;
//		this.name = DatabaseManager.generateUniqueId(); // for logging in: DatabaseManager.getNameById(id);
//	}

	
	public Account(String username) { // may require password in the future
		super(username);
//		Display.print("Created account with username");
		this.age = new Date();
		
		DatabaseManager.addAccount(this); // may cause problems later if 
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unused")
	private Date getAccountAge() {
		// TODO Auto-generated method stub
		return age;
	}
	
	
}
