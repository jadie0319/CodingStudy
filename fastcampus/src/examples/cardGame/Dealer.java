package examples.cardGame;

import java.util.Collections;
import java.util.List;

public class Dealer {
	private String name;
	private List<Card> cardList;
	private List<Player> playerList;
	private int index;
	
	public Dealer(String name) {
		this.name = name;
		this.index = 0;
	}
	
	public void setCardList(List<Card> cardList) {
		this.cardList = cardList;
	}
	
	public void setPlayerList(List<Player> playerList) {
		this.playerList = playerList;
	}
	
	public Card getCard() {
		Card card = cardList.get(index);
		index++;
		return card;
	}
	
	public void mix() {
		Collections.shuffle(cardList);
	}
	
	public void newGame() {
		index = 0;
		for(Player player : playerList) {
			player.clear();
		}
	}
	
	public void result() {
		for(Player player : playerList) {
			System.out.println(player.getName() + "님의 카드 목록 : " + player.getCards());
		}
	}
	
	public Player winner() {
		int maxScore=0;
		Player winner = new Player("우승자");
		for(Player player : playerList) {
			List<Card> playerCardList = player.getCards();
			int score =0 ;
			for(Card card : playerCardList) {
				score += card.getNumber();
			}
			System.out.println(player.getName() + "  님의 점수는 : " + score);
			
			if(score > maxScore) {
				maxScore = score;
				winner = player;
			}
		} // for
		
		return winner;
	}

}
