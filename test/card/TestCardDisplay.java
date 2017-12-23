package card;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import card.Deck.EmptyDeckException;

public class TestCardDisplay {
	public static void main(String args[]) {
		Deck deck = new Deck();
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		for (int i = 0; i < 52; i++) {
			try {
				JLabel label = new JLabel(deck.draw().getImage());
				panel.add(label);

			} catch (EmptyDeckException e) {
				e.printStackTrace();
			} 
		}
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
	}
}
