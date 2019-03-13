package com.boomaa.jpoker.init;

public class Card implements Comparable<Card> {
	private static String SUIT;
	private static String RANK;
	private static int VALUE;
	private static boolean PAIRED;
	
	public Card(String rank, String suit, int value) {
		SUIT = suit;
		RANK = rank;
		VALUE = value;
	}

	public String getSuit() {
		return SUIT;
	}

	public String getRank() {
		return RANK;
	}

	public int getValue() {
		return VALUE;
	}
	
	public void setPaired(boolean state) {
		PAIRED = state;
	}
	
	public boolean isPaired() {
		return PAIRED;
	}

	@Override
	public int compareTo(Card c) {
		return super.compareTo(c);
	}
	
}
