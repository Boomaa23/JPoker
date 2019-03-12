package com.boomaa.jpoker.util;

import java.util.Arrays;

import com.boomaa.jpoker.init.Card;
import com.boomaa.jpoker.init.Flop;
import com.boomaa.jpoker.init.Player;

public class GameLogic {
	private static Player[] PLAYER_LIST;
	private static Flop F;
	private static Player CURR_WINNER = null;
	private static Player CURR_PLAYER;
	private static Card[] CURR_CARDS;
	private static int WINNING_METHOD = 0;
	
	//TODO change CURR_CARDS so that it is sorted by Arrays.sort whenever it is set
	//TODO change pair finding and threeofakind methods to reflect ^^ ascending order sorting
	public static Player determineWinner(Player[] playerList, Flop f) {
		PLAYER_LIST = playerList;
		F = f;
		
		for(Player p : PLAYER_LIST) {
			CURR_PLAYER = p;
			setCurrentCards();
			boolean[] winMethod = new boolean[10];
				winMethod[0] = highCard();
				winMethod[1] = pair();
				winMethod[2] = twoPair();
				winMethod[3] = threeOfAKind();
				winMethod[4] = straight();
				winMethod[5] = flush();
				winMethod[6] = fullHouse();
				winMethod[7] = fourOfAKind();
				winMethod[8] = straightFlush();
				winMethod[9] = royalFlush();
			p.setWinCat(winMethod);
			
			for(int i = p.getWinCat().length;i >= 0;i--) {
				if(p.getWinCat()[i]) {
					if(i > WINNING_METHOD) {
						WINNING_METHOD = i;
						CURR_WINNER = p;
					} else if(i == WINNING_METHOD) {
						
					}
				}
			}
		}
		return CURR_WINNER;
	}
	
	private static boolean highCard() {
		Player held0 = CURR_PLAYER, held1 = CURR_PLAYER;
		int highCard0 = CURR_PLAYER.getCards()[0].getValue();
		int highCard1 = CURR_PLAYER.getCards()[1].getValue();
		for(Player tp : PLAYER_LIST) {
			if(!tp.equals(CURR_PLAYER)) {
				if(highCard0 <= tp.getCards()[0].getValue()) {
					highCard0 = tp.getCards()[0].getValue();
					held0 = tp;
				}
				
				if(highCard1 <= tp.getCards()[1].getValue()) {
					highCard1 = tp.getCards()[1].getValue();
					held1 = tp;
				}
			}
		}
		
		return ((held0.equals(CURR_PLAYER) && held1.equals(CURR_PLAYER))
				|| (highCard0 > highCard1 && held0.equals(CURR_PLAYER))
				|| (highCard1 > highCard0 && held1.equals(CURR_PLAYER)));
	}
	
	private static boolean pair() {
		return findDuplicates(1);
	}

	private static boolean twoPair() {
		return findDuplicates(2);
	}
	
	private static boolean threeOfAKind() {
		for(int i = 0; i < CURR_CARDS.length;i++) {
			for(int j = i + 1;j < CURR_CARDS.length;j++) {
				for(int k = j + 1;k < CURR_CARDS.length;j++) {
					if(CURR_CARDS[i].getRank().equals(CURR_CARDS[j].getRank()) && CURR_CARDS[j].getRank().equals(CURR_CARDS[k].getRank())) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	private static boolean straight() {
		Card[] orderedCards = CURR_CARDS;
		Arrays.sort(orderedCards);
		for(int i = 0;i < orderedCards.length - 4;i++) {
			if(orderedCards[i].getValue() == orderedCards[i + 1].getValue() - 1 
					&& orderedCards[i + 1].getValue() == orderedCards[i + 2].getValue() - 1
					&& orderedCards[i + 2].getValue() == orderedCards[i + 3].getValue() - 1
					&& orderedCards[i + 3].getValue() == orderedCards[i + 4].getValue() - 1) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean flush() {
		
	}
	
	private static boolean fullHouse() {
		
	}
	
	private static boolean fourOfAKind() {
		
	}
	
	private static boolean straightFlush() {
		
	}
	
	private static boolean royalFlush() {
		
	}
	
	private static boolean findDuplicates(int reqAmt) {
		int foundPairs = 0;
		for(int i = 0; i < CURR_CARDS.length;i++) {
			for(int j = i + 1;j < CURR_CARDS.length;j++) {
				if(CURR_CARDS[i].equals(CURR_CARDS[j])) {
					if(((CURR_CARDS[i].equals(p.getCards()[i])) || (CURR_CARDS[i].equals(F.getFlop()[i - p.getCards().length]))) && !CURR_CARDS[i].isPaired()) {
						CURR_CARDS[i].setPaired(true);
						CURR_CARDS[j].setPaired(true);
						foundPairs++;
					}
				}
			}
		}
		return foundPairs == reqAmt;
	}
	
	private static void setCurrentCards() {
		Card[] cards = new Card[CURR_PLAYER.getCards().length + F.getFlop().length];
		for(int i = 0;i < cards.length;i++) {
			if(i < CURR_PLAYER.getCards().length) {
				cards[i] = CURR_PLAYER.getCards()[i];
			} else if(i < F.getFlop().length) {
				cards[i] = F.getFlop()[i];
			}
		}
		CURR_CARDS = cards;
	}
}
