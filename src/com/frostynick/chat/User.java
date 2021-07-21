package com.frostynick.chat;

// user vs account
// user is local info and is publicly visible
// account includes password
// account extends username?
// add account verification

public class User {
	protected String name;

	// Password will be handled by database
	protected int id; // 
	
//	private boolean verified;
	
	public User() {
//		Display.print("Created guest user");
		this.id = 0;
		this.name = "Guest";
	}
	
	public User(String name) {
//		Display.print("Created user with username");
		this.name = name;
		this.id = DatabaseManager.generateUniqueId(); //  DatabaseManager.getIdByName(name);
		Display.print("Generated ID: " + this.id);
	}
	
//	public boolean verifyAccount() {
//		verified = false;
//		return false;
//	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{\n\"user\" : {\n\"name\" : ")
		  .append(name)
		  .append(",\n\"id\" : ")
		  .append(id)
		  .append("}\n}");
		return sb.toString();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	// generate id when account gets created
	
}
