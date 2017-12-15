package card;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player's Hand of Cards.
 */
public abstract class Hand {
	private final List<Card> CARDS;
	
	/**
	 * Creates a new empty Hand.
	 */
	public Hand() {
		this.CARDS = new ArrayList<Card>();
	}
	
	/**
	 * Adds the given Card to this Hand.
	 */
	public void addCard(Card toAdd) {
		this.CARDS.add(toAdd);
	}

	/**
	 * Returns the number of Cards in this Hand.
	 */
	public int getNumCards() {
		return this.CARDS.size();
	}
	
	/**
	 * Returns the sum of the default values of all Cards 
	 * in this Hand. This can be overriden for the specific
	 * game that is being played (for example, in Blackjack
	 * Aces will represent 1 or 11 based on the other cards
	 * in the Hand).
	 */
	public int getValue() {
		int handValue = 0;
		for (Card card : this.CARDS) {
			handValue += card.getDefaultValue();
		}
		return handValue;
	}
}