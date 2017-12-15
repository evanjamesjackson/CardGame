package blackjack;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import blackjack.BlackjackHand;
import card.Card;
import card.Face;
import card.Suit;

public class TestBlackjackHand {
	private static final int PERFECT_BLACKJACK_HAND = 21;

	@Test
	public void fourAcesAndOneTenSumsTo14() {
		BlackjackHand hand = new BlackjackHand();
		hand.addCard(new Card(Suit.CLUBS, Face.ACE));
		hand.addCard(new Card(Suit.HEARTS, Face.ACE));
		hand.addCard(new Card(Suit.SPADES, Face.ACE));
		hand.addCard(new Card(Suit.DIAMONDS, Face.ACE));
		hand.addCard(new Card(Suit.CLUBS, Face.TEN));
		assertEquals(14, hand.getValue());
	}

	@Test
	public void fourAcesAddsTo14() {
		BlackjackHand hand = new BlackjackHand();
		hand.addCard(new Card(Suit.CLUBS, Face.ACE));
		hand.addCard(new Card(Suit.HEARTS, Face.ACE));
		hand.addCard(new Card(Suit.SPADES, Face.ACE));
		hand.addCard(new Card(Suit.DIAMONDS, Face.ACE));
		assertEquals(14, hand.getValue());
	}

	@Test
	public void twoTensAndOneAceSumsTo21() {
		BlackjackHand hand = new BlackjackHand();
		hand.addCard(new Card(Suit.CLUBS, Face.TEN));
		hand.addCard(new Card(Suit.HEARTS, Face.TEN));
		hand.addCard(new Card(Suit.CLUBS, Face.ACE));
		assertEquals(PERFECT_BLACKJACK_HAND, hand.getValue());
	}

	@Test
	public void handWithTenAndAceSumsTo21() {
		BlackjackHand hand = new BlackjackHand();
		hand.addCard(new Card(Suit.CLUBS, Face.TEN));
		hand.addCard(new Card(Suit.CLUBS, Face.ACE));
		assertEquals(PERFECT_BLACKJACK_HAND, hand.getValue());
	}
}
