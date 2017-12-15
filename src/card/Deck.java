package card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a standard Deck of {@value #MAX_NUM_CARDS} Cards.
 */
public class Deck {
	private static final int MAX_NUM_CARDS = 52;
	
	/**
	 * The deck is read in ascending order of indices, with 0 being the "top".
	 */
	private static final int TOP_CARD_INDEX = 0;
	
	private final List<Card> CARDS;
	
	/**
	 * Creates a Deck of 52 Cards.
	 */
	public Deck() {
		this.CARDS = new ArrayList<Card>(MAX_NUM_CARDS);
		populateDeck();
	}
	
	/**
	 * Fills this deck with all 52 possible Cards.
	 */
	private void populateDeck() {
		for (Face face : Face.ALL_FACES) {
			for (Suit suit : Suit.ALL_SUITS) {
				this.CARDS.add(new Card(suit, face));
			}
		}
	}

	/**
	 * Shuffles this Deck.
	 */
	public void shuffle() {
		Collections.shuffle(this.CARDS);
	}
	
	/**
	 * Removes and returns the top Card from this Deck.
	 */
	public Card draw() throws EmptyDeckException {
		if (!this.CARDS.isEmpty()) {
			return this.CARDS.get(TOP_CARD_INDEX);
		} else {
			throw new EmptyDeckException();
		}
	}
	
	/**
	 * If this Deck is empty, refills it with the given list.
	 * @param cards cards to add to this Deck
	 * @throws NonEmptyDeckException if this Deck is not empty
	 */
	public void refill(List<Card> cards) throws NonEmptyDeckException {
		if (this.CARDS.isEmpty()) {
			this.CARDS.addAll(cards);
		} else {
			throw new NonEmptyDeckException();
		}
	}
	
	private class EmptyDeckException extends Exception {
		private static final long serialVersionUID = 3355183511028995388L;

		public EmptyDeckException() {
			super("Deck is empty");
		}
	}
	
	private class NonEmptyDeckException extends Exception {
		private static final long serialVersionUID = 9204020132201411745L;
		
		public NonEmptyDeckException() {
			super("Cannot add cards. Deck is not empty.");
		}
	}
}
