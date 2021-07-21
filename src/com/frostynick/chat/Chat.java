package com.frostynick.chat;

import java.util.ArrayList;
import java.util.Scanner;

// chat needs to be automatically added to communities
public class Chat {
	private ArrayList<User> users;
	private String name;
	private User owner;
//	private int ownerId = -1;
	private int id = -1;
	
	public Chat(User user, String name, Scanner sn) {
		users = new ArrayList<User>();
		// make sure all users are verified
		
		
		Communities.addToCommunity(this);
		
		this.name = name;
		
		owner = user;
//		ownerId = user.getId();
		if (!(user instanceof Account)) {
			Display.println("You must create an account to create a chat.");
//		} else if (user.getId() == ownerId) {
//			users.add((Account)user);
//			joinChat(user, sn);
		} else {
			Display.println("You do not have permissions to join this chat.");
		}
	}
	
	public void joinChat(User user, Scanner sn) {
		Display.print("[SYSTEM]: You have joined " + name + " chat. ");
		Display.println("Total users online: " + getNumberOfUsers());
		Display.println("IMPORTANT! Type /exit to exit chat");
		Display.println("/help for more options");
		
		// change command prefix in future???
		String msg = "";
		
		do {
			// FUTURE: chat objects
			// Don't use Display, use ChatBox
			Display.print("[" + user.getName() + "]: ");
			msg = sn.nextLine();
			// erase message if text is empty
			if (msg.equals("")) { // ensures charAt method doesn't break
				continue;
			}
			if (msg.charAt(0) == '/') {
				if (msg.length() < 2) {
					Display.println("it ain't breaking today");
					continue;
				}
				
				// add /clear
				// msg cannot equal /exit, causing an infinite loop
				String cmd = msg.substring(1).toLowerCase();
				if (cmd.equals("id")){
					Display.println("Chat ID: " + this.getId());
				} else if (cmd.equals("help")) {
					// read from a text file in the future?
					Display.println("/exit    leave the chat");
					Display.println("/help    list of commands");
					Display.println("-------  - - - - - - - -");
					
					Display.println("/id      chat ID");
					Display.println("/name    chat name");
					Display.println("/status  chat status");
					Display.println("/users   list of users");
					
				} else if (cmd.equals("name")) {
					Display.println("Chat name: " + getName());
				} else if (cmd.equals("users")) {
					Display.println("Users online: ");
					for (User u : users) {
						Display.println(u.toString());
					}
				} else if (cmd.equals("clear")) {
					Display.println("/clear doesn't work on Windows nor in Eclipse.");
					Display.print("\033\143");
				} else if (cmd.equals("status")) {
					Display.println("Chat name: " + getName());
					Display.println("Total users online: " + getNumberOfUsers());
					Display.println("Type /users for more details on users.");
				}
				// add options to change group attributes and stuff
			}
		} while (!msg.equals("/exit"));
	}
	
	public int getNumberOfUsers() {
		return users.size();
	}
	public ArrayList<User> getUsers() {
		return users;
	}
	public User getOwner() {
		return owner;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
}
