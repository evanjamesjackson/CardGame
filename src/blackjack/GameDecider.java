package blackjack;

/**
 * Decides the result of a game of Blackjack.
 */
public class GameDecider {
	/**
	 * Returns a game result based on the two given hands, at the end of a typical round.
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
	 * Returns a game result based on the two given hands, at the end of the game (when 
	 * the player has the max amount of cards in their hand).
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
}
