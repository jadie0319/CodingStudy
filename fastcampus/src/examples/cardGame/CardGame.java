package examples.cardGame;

import java.util.ArrayList;
import java.util.List;

public class CardGame {

	public static void main(String[] args) {
		List<Card> cards = CardFactory.createCards();
		
		Dealer dealer = new Dealer("심판");
		dealer.setCardList(cards);
		
		List<Player> playerList = new ArrayList<Player>();
		playerList.add(new Player("고니"));
		playerList.add(new Player("짝귀"));
		playerList.add(new Player("아귀"));
		
		dealer.setPlayerList(playerList);
		
		dealer.mix();

		// 5장씩 나누어 준다.
		for(int i=0; i < 5 ; i++) {
			for(Player player : playerList) {
				player.addCard(dealer.getCard());
			}
		}
			
		dealer.result();
		
		System.out.println("================   승자 : " + dealer.winner().getName());

	}

}
