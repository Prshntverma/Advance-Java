package com.rays.bean;

public class CricketPlayerBean{

	

	private int id;
	private String playerName;
    private String team;
    private String role;
    private int runs;
	
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getRole() { 
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
}
