package com.example.demo;

import java.util.Random;

public class RPSBean {

	private RPSPlayerBean human = new RPSPlayerBean();
	private RPSPlayerBean computer = new RPSPlayerBean();
	private int totalGamesPlayed;

	public RPSBean() {
	}

	public int getPlayerWins() {
		return human.getWins();
	}

	public int getComputerWins() {
		return computer.getWins();
	}

	public int getPlayerLosses() {
		return human.getLosses();
	}

	public int getComputerLosses() {
		return computer.getLosses();
	}

	public int getPlayerTies() {
		return human.getTies();
	}

	public int getComputerTies() {
		return computer.getTies();
	}

	public int getGamesPlayed() {
		return this.totalGamesPlayed;
	}

	public void setPlayerMove(String humanMove) {
		this.human.setMove(humanMove);
	}

	public String getPlayerMove() {
		return human.getMove();
	}
	
	public String getComputerMove() {
		return computer.getMove();
	}

	public String getRandomRPS() {
		String computerMove;
		String[] listOfRPS = new String[] { "rock", "paper", "scissors" }; 
																				
		int randomGenerator = new Random().nextInt(3); 
		computerMove = listOfRPS[randomGenerator]; 

		return computerMove;
	}

	public String compareChoises() {
		this.computer.setMove(getRandomRPS());
		String Computer = getComputerMove();
		String player = getPlayerMove();
		String winner = "";

	
		//SPELAREN
		switch (player) {
		case "rock": // 

			switch (Computer) {
			case "rock":
				this.human.addTies();
				this.computer.addTies();
				this.totalGamesPlayed += 1;
				winner = "tie";
				break;
			case "scissors":
				this.human.addWins();
				this.computer.addLosses();
				this.totalGamesPlayed += 1;
				winner = "Player";
				break;
			case "paper":
				this.computer.addWins();
				this.human.addLosses();
				this.totalGamesPlayed += 1;
				winner = "Computer";
				break;
			}

			break;

			//SPELAREN
		case "scissors": 

			switch (Computer) {
			case "rock":
				this.computer.addWins();
				this.human.addLosses();
				this.totalGamesPlayed += 1;
				winner = "Computer";
				break;
			case "scissors":
				this.human.addTies();
				this.computer.addTies();
				this.totalGamesPlayed += 1;
				winner = "tie";
				break;
			case "paper":
				this.human.addWins();
				this.computer.addLosses();
				this.totalGamesPlayed += 1;
				winner = "Player";
				break;
			}
			break;

			//SPELAREN
		case "paper": 
			switch (Computer) {
			case "rock":
				this.human.addWins();
				this.computer.addLosses();
				this.totalGamesPlayed += 1;
				winner = "Player";
				break;
			case "scissors":
				this.computer.addWins();
				this.human.addLosses();
				this.totalGamesPlayed += 1;
				winner = "Computer";
				break;
			case "paper":
				this.human.addTies();
				this.computer.addTies();
				this.totalGamesPlayed += 1;
				winner = "tie";
				break;
			}
			break;

		}

		return winner;
	}

}
