package blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import card.Card;
import card.Deck;
import card.Deck.EmptyDeckException;

public class BlackjackGame {
	private final Deck DECK;
	private List<Card> DISCARD_PILE;
	private final BlackjackHand PLAYER;
	private final BlackjackHand DEALER;
	
	private int playerCoins;
	
	private GameResult result;
	
	public BlackjackGame() {
		this.DECK = new Deck();
		this.PLAYER = new BlackjackHand();
		this.DEALER = new BlackjackHand();
		this.DISCARD_PILE = new ArrayList<Card>();
		this.playerCoins = 10;
		this.result = GameResult.CONTINUE;
	}
	
	public void play() {
		Scanner scanner = new Scanner(System.in);
		
		boolean continuePlaying = true;
		
		while (continuePlaying && this.playerCoins > 0) {
			newGame();
			
			System.out.println("Player: " + this.PLAYER);
			System.out.println("Dealer: " + this.DEALER);

			boolean hit = true;

			while (hit && this.result == GameResult.CONTINUE) {
				System.out.println("Hit (H) or stay (S)?");
			
				String choice = scanner.nextLine();
				while (!choice.equals("H") && !choice.equals("S")) {
					System.out.println("invalid input");
					choice = scanner.nextLine();
				}	
					
				if (choice.equals("H")) {
					hit();
				} else if (choice.equals("S")) {
					hit = false;
				}
				
				System.out.println("Player: " + this.PLAYER);
				System.out.println("Dealer: " + this.DEALER);
			
				this.result = GameDecider.validateHands(this.DEALER, this.PLAYER);
			}
		
			this.result = GameDecider.showdown(this.DEALER, this.PLAYER);
			
			System.out.println(this.result.getResultMessage());
			
			discardHands();
			
			if (this.result.didPlayerWin()) {
				Random random = new Random();
				int randomReward = random.nextInt(9) + 1;
				this.playerCoins += randomReward;
				System.out.println("You won " + randomReward + " coins");
			}
			
			System.out.println("Keep playing? Yes (Y) or No (N)");
			String keepPlaying = scanner.nextLine();
			while (!keepPlaying.equals("N") && !keepPlaying.equals("Y")) {
				System.out.println("invalid input");
				keepPlaying = scanner.nextLine();
			}
			
			if (keepPlaying.equals("Y")) {
				continuePlaying = true;
			} else {
				continuePlaying = false;
			}
		}
		
		if (this.playerCoins == 0) {
			System.out.println("Out of coins. Game over.");	
		}
		
		scanner.close();
	}
	
	private void discardHands() {
		this.DISCARD_PILE.addAll(this.PLAYER.discard());
		this.DISCARD_PILE.addAll(this.DEALER.discard());
	}

	private void newGame() {
		this.result = GameResult.CONTINUE;
		
		System.out.println();
		System.out.println("NEW GAME");
		System.out.println("COINS: " + this.playerCoins);
		
		this.playerCoins -= 1;
		
		refillDeck();
		this.DECK.shuffle();
		
		// Game starts with two inital hits
		for (int i = 0; i < BlackjackHand.INITIAL_NUM_CARDS; i++) {
			hit();
		}
		
		this.result = GameDecider.validateHands(this.DEALER, this.PLAYER);
	}

	private void hit() {
		try {
			this.PLAYER.addCard(this.DECK.draw());
			this.DEALER.addCard(this.DECK.draw());
		} catch (EmptyDeckException e) {
			refillDeck();
		}
	}

	private void refillDeck() {
		this.DECK.refill(this.DISCARD_PILE);
		this.DISCARD_PILE.clear();
	}
}
