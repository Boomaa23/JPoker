package com.boomaa.jpoker.util;

import com.boomaa.jpoker.init.Card;
import com.boomaa.jpoker.init.Flop;
import com.boomaa.jpoker.init.Player;

public class GameLogic {
	private static Player[] PLAYER_LIST;
	private static Flop F;
	private static Player CURR_WINNER = null;
	private static int WINNING_METHOD = 0;
	
	public static Player determineWinner(Player[] playerList, Flop f) {
		PLAYER_LIST = playerList;
		F = f;
		for(Player p : PLAYER_LIST) {
			boolean[] winMethod = new boolean[10];
				winMethod[0] = highCard(p);
				winMethod[1] = pair(p);
				winMethod[2] = twoPair(p);
				winMethod[3] = threeOfAKind(p);
				winMethod[4] = straight(p);
				winMethod[5] = flush(p);
				winMethod[6] = fullHouse(p);
				winMethod[7] = fourOfAKind(p);
				winMethod[8] = straightFlush(p);
				winMethod[9] = royalFlush(p);
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
	
	private static boolean highCard(Player p) {
		Player held0 = p, held1 = p;
		int highCard0 = p.getCards()[0].getValue();
		int highCard1 = p.getCards()[1].getValue();
		for(Player tp : PLAYER_LIST) {
			if(!tp.equals(p)) {
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
		
		return ((held0.equals(p) && held1.equals(p))
				|| (highCard0 > highCard1 && held0.equals(p))
				|| (highCard1 > highCard0 && held1.equals(p)));
	}
	
	private static boolean pair(Player p) {
		return findPairs(p, 1);
	}

	private static boolean twoPair(Player p) {
		return findPairs(p, 2);
	}
	
	private static boolean threeOfAKind(Player p) {
		
	}
	
	private static boolean straight(Player p) {
		
	}
	
	private static boolean flush(Player p) {
		
	}
	
	private static boolean fullHouse(Player p) {
		
	}
	
	private static boolean fourOfAKind(Player p) {
		
	}
	
	private static boolean straightFlush(Player p) {
		
	}
	
	private static boolean royalFlush(Player p) {
		
	}
	
	private static boolean findPairs(Player p, int reqPairs) {
		int foundPairs = 0;
		Card[] cards = new Card[p.getCards().length + F.getFlop().length];
		for(int i = 0;i < cards.length;i++) {
			if(i < p.getCards().length) {
				cards[i] = p.getCards()[i];
			} else if(i < F.getFlop().length) {
				cards[i] = F.getFlop()[i];
			}
			
			for(int j = i + 1;j < cards.length;j++) {
				if(cards[i].equals(cards[j])) {
					foundPairs++;
				}
			}
		}
		return foundPairs == reqPairs;
	}
}
