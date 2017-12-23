package card;

import javax.swing.ImageIcon;

/**
 * Fetches image files for Cards.
 */
public class CardImageLocator {
	private static final String IMAGE_DIRECTORY = "images/"; 
	private static final String JPEG_EXTENSION = ".jpg";
	private static final ImageIcon FACE_DOWN_IMAGE = 
			new ImageIcon(IMAGE_DIRECTORY + "back" + JPEG_EXTENSION);
	
	/**
	 * Returns an image showing the back of a card.
	 */
	public static ImageIcon getFaceDownImage() {
		return FACE_DOWN_IMAGE;
	}
	
	/**
	 * Returns an image for the card with the given face and suit.
	 */
	public static ImageIcon getFaceUpImage(Face face, Suit suit) {
		return new ImageIcon(getImageFileName(face, suit));
	}

	/**
	 * Returns the file name of the image of the card for the given 
	 * face and suit. Image files are named by combining the card's
	 * face name, followed by the suit name.
	 */
	private static String getImageFileName(Face face, Suit suit) {
		return new String(
				IMAGE_DIRECTORY 
				+ face.getName() + suit.getName() 
				+ JPEG_EXTENSION);
	}
}
