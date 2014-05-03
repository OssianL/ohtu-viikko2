package ohtu;

public class TennisGame {
    
	public static final String[] scoreStrings = {"Love", "Fifteen", "Thirty", "Forty"};
	
    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if(playerName == player1Name) player1Score += 1;
		else if(playerName == player2Name) player2Score += 1;
    }

    public String getScore() {
        if(player1Score == player2Score) {
            if(player1Score < 4) return scoreStrings[player1Score] + "-All";
			else return "Deuce";
        }
        else if((player1Score >= 4) || (player2Score >= 4)) {
            if(scoreDifference() == 1) return "Advantage " + winningPlayer();
            else return "Win for " + winningPlayer();
        }
		else return scoreStrings[player1Score] + "-" + scoreStrings[player2Score];
    }
	
	private int scoreDifference() {
		return Math.abs(player1Score - player2Score);
	}
	
	private String winningPlayer() {
		if(player1Score > player2Score) return player1Name;
		return player2Name;
	}
}