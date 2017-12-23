package card;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a player's Hand of Cards.
 */
public abstract class Hand {
	protected final List<Card> CARDS;
	
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
	
	/**
	 * Empties this Hand and returns the Cards the Hand held.
	 */
	public List<Card> discard() {
		List<Card> discarded = this.CARDS;
		this.CARDS.clear();
		return discarded;
	}
	
	@Override
	public String toString() {
		String result = "";
		
		for (int i = 0; i < this.CARDS.size(); i++) {
			result += this.CARDS.get(i).asVisibleString();
			if (i != (this.CARDS.size() - 1)) {
				result += " + ";
			}
		}
		
		result += " = " + getValue();
		
		return result;
	}
}
