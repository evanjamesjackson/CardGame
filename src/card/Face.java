package card;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a Face value for a Card.
 */
public class Face {
	public static final Face KING = new Face("King", 10);
	public static final Face QUEEN = new Face("Queen", 10);
	public static final Face JACK = new Face("Jack", 10);
	public static final Face ACE = new Face("Ace", 1);
	public static final Face TWO = new Face("Two", 2);
	public static final Face THREE = new Face("Three", 3);
	public static final Face FOUR = new Face("Four", 4);
	public static final Face FIVE = new Face("Five", 5);
	public static final Face SIX = new Face("Six", 6);
	public static final Face SEVEN = new Face("Seven", 7);
	public static final Face EIGHT = new Face("Eight", 8);
	public static final Face NINE = new Face("Nine", 9);
	public static final Face TEN = new Face("Ten", 10);
	
	/**
	 * Returns a list of all possible Face values.
	 */
	public static final List<Face> ALL_FACES = Arrays.asList(
			KING, QUEEN, JACK, ACE, TWO, THREE, FOUR, FIVE,
			SIX, SEVEN, EIGHT, NINE, TEN);
	
	private final String NAME;
	private final int DEFAULT_VALUE;
	
	/**
	 * Creates a Face value with the given name and default value.
	 * This constructor is private since all possible Face values
	 * are defined in this class.
	 */
	private Face(String name, int defaultValue) {
		this.NAME = name;
		this.DEFAULT_VALUE = defaultValue;
	}
	
	/**
	 * Returns the default value of this Face.
	 */
	public int getDefaultValue() {
		return this.DEFAULT_VALUE;
	}
	
	/**
	 * Returns the name of this Face value.
	 */
	public String getName() {
		return this.NAME;
	}
	
	@Override
	public boolean equals(Object o) {
		Face face2 = (Face)o;
		return this.NAME.equals(face2.NAME)
				&& this.DEFAULT_VALUE == face2.DEFAULT_VALUE;
	}
}
