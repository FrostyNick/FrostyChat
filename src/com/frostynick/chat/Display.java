package com.frostynick.chat;

import java.util.Scanner;

public abstract class Display {
	public static void println(String msg) {
		System.out.println(msg);
	}

	public static void print(String msg) {
		System.out.print(msg);
	}

	public static int prompt(String prompt, String[] responses, Scanner sn) {
		int responseId = -1;
		int len = responses.length;
		
		Display.println("\n" + prompt);
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			
			sb.append('[')
			  .append(i)
			  .append("] ")
			  .append(responses[i])
			  .append('\n');
			
		}
		sb.deleteCharAt(sb.length() - 1); // delete last new line
		
		Display.println(sb.toString());
		String response = null;
		
		// the 1st nextLine was ignored for some reason
		// uncomment below if issue occurs again, find a solution
//		sn.nextLine();
		do {
			response = sn.nextLine();
			try {
				responseId = Integer.parseInt(response); // check for exception
			} catch (NumberFormatException e0) {
				Display.println("Please enter a vaild response that is a number.");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (responseId < len && responseId > -1) {
				break;
			} else {
				Display.println("You chose an invalid number. Review the choice numbers above.");
				responseId = -1;
			}
			
			try {
				Thread.sleep(500); // prevents a laggy infinite loop while testing
			} catch (InterruptedException e1) {
				Display.println("Program interrupted.");
			}
		} while (responseId == -1);
//		System.out.println("TEST!!! " + response.toString());
		
		return responseId;
	}
}
