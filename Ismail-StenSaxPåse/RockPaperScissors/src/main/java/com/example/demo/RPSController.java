package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/RPS")
public class RPSController {
	
	private RPSBean theGameBean = new RPSBean();

	@RequestMapping(method = RequestMethod.POST)
	public String gameMode(String userInput) {
		
		theGameBean.setPlayerMove(userInput.toLowerCase());
		String result = theGameBean.compareChoises();
		
		return 
				"Player: " + theGameBean.getPlayerMove() + "<br>" + 
				"Computer: " + theGameBean.getComputerMove() + "<br>" +
				"Winner: " + result;
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String score(){
		
		return JsonObjectRPS();
	}
	
	private String JsonObjectRPS() {
		
		return "{"+ 
				"\"Games\": \"" + theGameBean.getGamesPlayed() + 
				"\"," +
				
				"\"Player\":" + 
					"[{"+
						"\"Wins\":" + "\"" + theGameBean.getPlayerWins() + "\""+ 
						"," +
						"\"Losses\":" + "\"" + theGameBean.getPlayerLosses() + "\""+ 
						"," +
						"\"Ties\":" + "\"" + theGameBean.getPlayerTies() + "\""+
					"}]"+
				"," +
				
				"\"Computer\":" + 
					"[{"+
						"\"Wins\":" + "\"" + theGameBean.getComputerWins() + "\""+ 
						"," +
						"\"Losses\":" + "\"" + theGameBean.getComputerLosses() + "\""+ 
						"," +
						"\"Ties\":" + "\"" + theGameBean.getComputerTies() + "\""+
					"}]"+
				"}";
	}
}
