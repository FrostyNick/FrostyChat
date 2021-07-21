package com.frostynick.chat;

import java.util.Scanner;

public class Driver {
//	public static Driver driver = null;
	Driver(Scanner sn) {
		new Chat(new Account("gokumaster1000"), "anime is so anime", sn);
		new Chat(new Account("Troy"), "planter mansion", sn);
		new Chat(new Account("poopdump9"), "click here nd i find u HOT sigles in ur area", sn);
		new Chat(new Account("thanos"), "I will personally kill people for you with a snap of my fingers", sn);
		
	}
}
