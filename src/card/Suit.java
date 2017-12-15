package card;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a Suit of a Card.
 */
public class Suit {
	public static final Suit HEARTS = new Suit("Hearts");
	public static final Suit SPADES = new Suit("Spades");
	public static final Suit CLUBS = new Suit("Clubs");
	public static final Suit DIAMONDS = new Suit("Diamonds");
	
	/**
	 * Returns a list of all possible Suits.
	 */
	public static final List<Suit> ALL_SUITS = Arrays.asList(
			HEARTS, SPADES, CLUBS, DIAMONDS);
	
	private final String NAME;

	/**
	 * Creates a Suit with the given name.
	 * This constructor is private since all possible Suits
	 * are defined in this class.
	 */
	private Suit(String name) {
		this.NAME = name;
	}
	
	/**
	 * Returns the name of this Suit.
	 */
	public String getName() {
		return this.NAME;
	}
	
	@Override
	public boolean equals(Object o) {
		Suit suit2 = (Suit)o;
		return this.NAME.equals(suit2.NAME);
	}
}
