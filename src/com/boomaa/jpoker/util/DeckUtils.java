package com.boomaa.jpoker.util;

import java.util.ArrayList;

import com.boomaa.jpoker.init.Card;

public class DeckUtils {
	public static ArrayList<Card> shuffle(ArrayList<Card> deck) {
		ArrayList<Card> tempDeck = new ArrayList<Card>(deck.size());
		for(Card c : deck) {
			int index = (int) (Math.random() * deck.size());
			while(tempDeck.get(index) != null) {
				index = (int) (Math.random() * deck.size());
			}
			tempDeck.set(index, c);
		}
		return tempDeck;
	}
}
