package com.boomaa.jpoker.init;

public class Player {
	private static Card ONE;
	private static Card TWO;
	private static String NAME;
	private static String IP;
	private static boolean[] winCat;
	
	public Player(String name, String ip) {
		this.NAME = name;
		this.IP = ip;
	}
	
	public void setCards(Card one, Card two) {
		this.ONE = one;
		this.TWO = two;
	}
	
	public Card[] getCards() {
		return new Card[] {ONE, TWO};
	}
	
	public boolean equals(Player p) {
		return p.getCards()[0] == ONE && p.getCards()[1] == TWO;
	}
	
	public void setWinCat(boolean[] win) {
		winCat = win;
	}
	
	public boolean[] getWinCat() {
		return winCat;
	}
}
