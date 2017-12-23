package card;

import javax.swing.ImageIcon;

/**
 * Represents a single playing Card.
 */
public class Card {
	private static final String CARD_NAME_FACE_DOWN = "XXXXX";
	private static final ImageIcon FACE_DOWN_IMAGE = new ImageIcon("back.jpg");
	
	private boolean isFaceUp;
	
	private final Suit SUIT;
	private final Face FACE;
	
	private final ImageIcon IMAGE;

	/**
	 * Creates a Card with the given Suit and Face value.
	 */
	public Card(Suit suit, Face face) {
		this.isFaceUp = true;
		this.SUIT = suit;
		this.FACE = face;
		this.IMAGE = new ImageIcon(this.FACE.getName() + this.SUIT.getName());
	}
	
	/**
	 * Returns this Card's Suit.
	 */
	public Suit getSuit() {
		return this.SUIT;
	}
	
	/**
	 * Returns this Card's Face value.
	 */
	public Face getFace() {
		return this.FACE;
	}
	
	/**
	 * Returns this Card's default value (based on the 
	 * default value of it's Face).
	 */
	public int getDefaultValue() {
		return this.FACE.getDefaultValue();
	}

	public ImageIcon getImage() {
		if (isFaceUp) {
			return this.IMAGE;	
		} else {
			return FACE_DOWN_IMAGE;
		}
	}

	/**
	 * Flips this Card.
	 */
	public void flip() {
		this.isFaceUp = !isFaceUp;
	}
	
	/**
	 * Returns the name of this Card (eg: King of Spades).
	 */
	public String getName() {
		return this.FACE.getName() + " of " + this.SUIT.getName();
	}
	
	/**
	 * Returns the name of this Card if it is face-up, otherwise
	 * returns {@value #CARD_NAME_FACE_DOWN}.
	 */
	public String asVisibleString() {
		if (this.isFaceUp) {
			return getName();
		} else {
			return CARD_NAME_FACE_DOWN;
		}
	}
	
	/**
	 * Returns true if the given Card has the same Suit and Face
	 * values as this Card.
	 */
	@Override
	public boolean equals(Object o) {
		Card card2 = (Card)o;
		return this.SUIT.equals(card2.SUIT)
				&& this.FACE.equals(card2.FACE);
	}
}