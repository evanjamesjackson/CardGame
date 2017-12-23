package blackjack;

/**
 * Represents the result of a game of Blackjack.
 */
public class GameResult {
	public static final GameResult DEALER_BUST = new GameResult(true, "Dealer bust! You win!");
	public static final GameResult DEALER_BLACKJACK = new GameResult(false, "Dealer blackjack. You lose...");
	public static final GameResult PLAYER_BUST = new GameResult(false, "Bust! You lose...");
	public static final GameResult PLAYER_BLACKJACK = new GameResult(true, "Blackjack! You win!");
	public static final GameResult DEALER_WIN = new GameResult(false, "You lose...");
	public static final GameResult PLAYER_WIN = new GameResult(true, "You win!");
	public static final GameResult DRAW = new GameResult(false, "Draw. House rules, you lose");
	public static final GameResult CONTINUE = new GameResult(false, "Game continues");
	
	private final boolean DID_PLAYER_WIN;
	private final String RESULT_MESSAGE;
	
	private GameResult(boolean didPlayerWin, String resultMessage) {
		this.DID_PLAYER_WIN = didPlayerWin;
		this.RESULT_MESSAGE = resultMessage;
	}

	/**
	 * Returns a String detailing this game result.
	 */
	public String getResultMessage() {
		return this.RESULT_MESSAGE;
	}
	
	/**
	 * Returns true if this result indicates the player won the game, 
	 * and false if the dealer won.
	 */
	public boolean didPlayerWin() {
		return this.DID_PLAYER_WIN;
	}
}
