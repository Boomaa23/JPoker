package com.boomaa.jpoker.display;

import com.boomaa.jpoker.init.Deck;
import com.boomaa.jpoker.init.Player;
import com.boomaa.jpoker.network.Server;

public class Main {
	private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king", "ace"};
	private static final String[] SUITS = {"spades", "hearts", "diamonds", "clubs"};
	private static final int[] POINT_VALUES = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
	private static final Player[] PLAYERS = Server.getPlayers();
	
	public static void main(String[] args) {
		Deck deck = new Deck(RANKS, SUITS, POINT_VALUES);
		
		for(Player p : PLAYERS) {
			p.setCards(deck.getRandomCard(), deck.getRandomCard());
		}
	}

}
