package com.example.demo;

public class RPSPlayerBean {

	//States
	private String theMove;
	private int theWins;
	private int theLosses;
	private int theDraws;

	//Constructor
	public RPSPlayerBean() {
	}

	//Behaviors
	public String getMove() {
		return theMove;
	}

	public void setMove(String theSelectedMove) {
		this.theMove = theSelectedMove;
	}

	public void addWins() {
		this.theWins += 1;
	}

	public int getWins() {
		return theWins;
	}

	public void addLosses() {
		this.theLosses += 1;
	}

	public int getLosses() {
		return this.theLosses;
	}

	public void addTies() {
		this.theDraws += 1;
	}

	public int getTies() {
		return this.theDraws;
	}
}
