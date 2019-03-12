package com.boomaa.jpoker.init;
import java.util.ArrayList;

import com.boomaa.jpoker.util.DeckUtils;

public class Deck {
	ArrayList<Card> deck = new ArrayList<Card>();
	
	public Deck(String[] ranks, String[] suits, int[] values) {
		for(int i = 0;i < ranks.length;i++) {
			deck.add(new Card(ranks[i], suits[i], values[i]));
		}
		DeckUtils.shuffle(deck);
	}
	
	public ArrayList<Card> getDeck() {
		return deck;
	}
	
	public void shuffleDeck() {
		deck = DeckUtils.shuffle(deck);
	}
	
	public void removeCard(int index) {
		deck.remove(index);
	}
	
	public Card getRandomCard() {
		int index = (int) (Math.random() * deck.size());
		Card temp = deck.get(index);
		removeCard(index);
		return temp;
	}
	
}
