package com.boomaa.jpoker.init;

public class Card {
	private final String suit;
	private final String rank;
	private final int value;
	
	public Card(String rank, String suit, int value) {
		this.suit = suit;
		this.rank = rank;
		this.value = value;
	}

	public String getSuit() {
		return suit;
	}

	public String getRank() {
		return rank;
	}

	public int getValue() {
		return value;
	}
	
}
