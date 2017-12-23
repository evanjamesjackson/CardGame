package blackjack;

public class GameDecider {
	/**
	 * Returns a game result based on the two given hands during normal play.
	 */
	public static GameResult validateHands(BlackjackHand dealer, BlackjackHand player) {
		if (player.getValue() > BlackjackHand.PERFECT_HAND) {
			return GameResult.PLAYER_BUST;
		} else if (dealer.getValue() > BlackjackHand.PERFECT_HAND) {
			return GameResult.DEALER_BUST;
		} else if (dealer.getValue() == BlackjackHand.PERFECT_HAND) {
			return GameResult.DEALER_BLACKJACK;
		} else if (player.getValue() == BlackjackHand.PERFECT_HAND) {
			return GameResult.PLAYER_BLACKJACK;
		} else {
			return GameResult.CONTINUE;
		}
	}
	
	/**
	 * Returns a game result based on the two given hands at the end of a game.
	 * @param dealer
	 * @param player
	 * @return
	 */
	public static GameResult showdown(BlackjackHand dealer, BlackjackHand player) {
		GameResult result = validateHands(dealer, player);
		
		if (result == GameResult.CONTINUE) {
			if (player.getValue() > dealer.getValue()) {
				result = GameResult.PLAYER_WIN;
			} else if (dealer.getValue() > player.getValue()) {
				result = GameResult.DEALER_WIN;
			} else {
				result = GameResult.DRAW;
			}
		}
		
		return result;
	}
	
	
	public static class GameResult {
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

		public String getResultMessage() {
			return this.RESULT_MESSAGE;
		}
		
		public boolean didPlayerWin() {
			return this.DID_PLAYER_WIN;
		}
	}
}
