package examples.cardGame;

import java.util.ArrayList;
import java.util.List;

public class CardFactory {
	private CardFactory() {}
	
	public static List<Card> createCards() {
		List<Card> cardList = new ArrayList<Card>();
		
		String[] types = new String[] {"클로버" , "다이아", "스페이드", "하트"};
	
		for(String type : types) {
			for(int i=1 ; i <= 13 ; i++) {
				Card card = new Card(type,i);
				cardList.add(card);
			} // for
		} // for types
		
		return cardList;
	} // create()

}
