package blackjack;

import card.Card;
import card.Face;
import card.Hand;

public class BlackjackHand extends Hand {
	private static final int HIGH_ACE_VALUE = 11; 
	private static final int PERFECT_HAND = 21;
	
	public BlackjackHand() {
		super();
	}
	
	/**
	 * Returns the best possible value for this hand 
	 * (ie: all Aces are valued as highly as possible 
	 * without exceeding {@value #PERFECT_HAND}.
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

	private int countAces() {
		int numAces = 0;
		for (Card card : this.CARDS) {
			if (card.getFace().equals(Face.ACE)) {
				numAces++;
			}
		}
		return numAces;
	}
}
