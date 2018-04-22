package Chapter7.Question1;

import java.util.ArrayList;

/*
 * 7-1 카드 한 벌 : 카드 게임에 쓰이는 카드 한 벌을 나타내는 자료구조를 설계하라. 그리고
 * 블랙잭 게임을 구현하려면 이 자료구조의 하위 클래스를 어떻게 만들어야 하는지 설명하라.
 */


public class Question {

	public static void main(String[] args) {
int numHands = 5;
		
		BlackJackGameAutomator automator = new BlackJackGameAutomator(numHands);
		automator.initializeDeck();
		boolean success = automator.dealInitial();
			if (!success) {
				System.out.println("Error. Out of cards.");
			} else {
			System.out.println("-- Initial --");
			automator.printHandsAndScore();
			ArrayList<Integer> blackjacks = automator.getBlackJacks();
			if (blackjacks.size() > 0) {
				System.out.print("Blackjack at ");
				for (int i : blackjacks) {
					System.out.print(i + ", ");
				}
				System.out.println("");
			} else {
				success = automator.playAllHands();
				if (!success) {
					System.out.println("Error. Out of cards.");
				} else {
					System.out.println("\n-- Completed Game --");
					automator.printHandsAndScore();
					ArrayList<Integer> winners = automator.getWinners();
					if (winners.size() > 0) {
						System.out.print("Winners: ");
						for (int i : winners) {
							System.out.print(i + ", ");
						}
						System.out.println("");
					} else {
						System.out.println("Draw. All players have busted.");
					}
				}
			}
		}
	}

}
