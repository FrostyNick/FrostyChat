package com.frostynick.chat;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public abstract class Communities {
	private static ArrayList<Chat> chatRooms = new ArrayList<Chat>();
	private static int size; // FUTURE: size should change automatically
//	private static int[] takenIds = {};
	private static Random rand = new Random();

	
	// return value may be ignored (FIX SOON)
	public static Chat createChatRoom(User owner, Scanner sn) {
		Display.print("Create a group chat name: ");
		String groupName = sn.nextLine();
		return new Chat(owner, groupName, sn);
	}
	
	public static Chat discoverChatRoom(User user, Scanner sn) {
		// create a concise list of chats in the future
		
		int choice;
		for (int i = size - 1; i >= 0; i--) {
			Chat newChatRoom = chatRooms.get(i);
			String name = newChatRoom.getName();
			Display.println("Chat room named " + name + " found!");
			
			
			do {
				String[] c1 = {"Join chat", "Next chat",
						"Chat info", "Exit"};
				choice = Display.prompt("What do you want to do?", c1, sn);
				switch (choice) {
				case 0:
					newChatRoom.joinChat(user, sn);
					return null;
				case 2:
					Display.println(newChatRoom.toString());
					break;
				case 3:
					return null;
				default:
					Display.println("Unknown selection: " + choice);
				case 1:
				}
			} while (choice != 1);
		}
		return null;
	}
	
	public static Chat getChatRoomWithUser(User user, Scanner sn) {
		size = chatRooms.size();
		int choice = -1;
		
		if (size != 0) {
			
			String[] c = {"Discover chat rooms", "Search for a chat room",
					"Create a chat room"};
			choice = Display.prompt("Choose a way to find a chat room:", c, sn);
			switch(choice) {
			case 0:
				discoverChatRoom(user, sn);
				break;
			case 1:
				Display.println("Coming soon.");
				break;
			case 2:
				createChatRoom(user, sn);
			}

			
			Display.println("Chat selection was cancelled.");
			return null;
		} else {
			String[] c = {"Yes", "No"}; // choices
			choice = 
			Display.prompt("There are no chat rooms. Create a chat room?", c, sn);
			if (choice == 0) {
				Chat chat = createChatRoom(user, sn);
				chat.joinChat(user, sn);
				return null;
			}
		}
		return null;
	}
	
	public static void addToCommunity(Chat chat) {
		if (chat.getId() > 0) {
			return;
		}
		chat.setId(DatabaseManager.generateUniqueId());
		chatRooms.add(chat);
		
	}

//	protected abstract int generateId();
	
	
}
