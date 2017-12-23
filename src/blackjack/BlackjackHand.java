package blackjack;

import card.Card;
import card.Face;
import card.Hand;

public class BlackjackHand extends Hand {
	/**
	 * Value for a perfect hand.
	 */
	public static final int PERFECT_HAND = 21;
	
	/**
	 * Number of cards a hand contains at the start of a game.
	 */
	public static final int INITIAL_NUM_CARDS = 2;
	
	public static final int MAX_NUM_CARDS = 5;
	
	private static final int HIGH_ACE_VALUE = 11; 
	
	public BlackjackHand() {
		super();
	}
	
	@Override
	public void addCard(Card toAdd) {
		if (getNumCards() <= MAX_NUM_CARDS) {
			super.addCard(toAdd);
		} else {
			throw new MaxCardsExceededException();
		}
	}
	
	/**
	 * Returns the best possible value for this hand 
	 * (ie: all Aces are valued as highly as possible 
	 * without exceeding {@value #PERFECT_HAND}).
	 */
	@Override
	public int getValue() {
		int numAces = countAces();
		 
		int valuesWithAcesValuedHigh = 
				(super.getValue() - numAces) + (numAces * HIGH_ACE_VALUE);
		
		// Go through all Aces in the Hand and reduce where necessary
		int reducedValue = valuesWithAcesValuedHigh;
		for (int i = 0; i < numAces; i++) {
			if (reducedValue > PERFECT_HAND) {
				/* If the reduced value exceeds 21, value the current
				 * Ace as 1 rather than 11.
				 */
				reducedValue -= HIGH_ACE_VALUE;
				reducedValue += Face.ACE.getDefaultValue();
			}
		}
		
		return reducedValue;
	}

	/**
	 * Returns the number of Aces in this hand.
	 */
	private int countAces() {
		int numAces = 0;
		for (Card card : this.CARDS) {
			if (card.getFace().equals(Face.ACE)) {
				numAces++;
			}
		}
		return numAces;
	}
	
	public class MaxCardsExceededException extends IllegalArgumentException {
		private static final long serialVersionUID = 8047540573063045375L;
	}
}
