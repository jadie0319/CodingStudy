package CardTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Player {
	private String name;
	private int playerNumber;
	private int result;
	private List<Card> cards;
	public Player(int number) {
		// 카드 경기 재시합할때
		// 기존 플레이어들의 정보중에 이름만 가져오기 위해서 number도 따로 기억하게 만들었습니다.
		this.playerNumber = number;
		this.name = "Player" + number;
		this.cards = new ArrayList<Card>(new HashSet<Card>());
	}
	
	public int getNumber() {
		return this.playerNumber;
	}
	
	
	public void setCard(Card card) {
		this.cards.add(card);
	}
	
	// 플레이어가 보유한 카드들을 출력하는 메소드 입니다.
	public void printCards() {
		System.out.print(this.name + " : ");
		for(int i=0 ; i < cards.size() ; i++) {
			System.out.print(cards.get(i).getCardAlphabet()+""+cards.get(i).getCardNum());
			if(i != cards.size()-1) {
				System.out.print(",");
			}
			
		}
		
		System.out.print( " sum : " + this.sumCardNumber());
	}
	
	// 승자 판단할때 필요한 카드들의 합을 구하는 메소드 입니다. 
	public int sumCardNumber() {
		this.result=0;
		for(int i=0 ; i < cards.size() ; i++) {
			result += cards.get(i).getCardNum();
		}
		
		return result;
	}
	
	// 플레이어 이름 출력하는 메소드 입니다.
	public String getName() {
		return this.name;
	}
	
	
}


class Card {
	private char cardAlphabet;
	private int cardNum;
	
	public Card(char cardAlphabet, int cardNum) {
		this.cardAlphabet = cardAlphabet;
		this.cardNum = cardNum;
	}
	public char getCardAlphabet() {
		return cardAlphabet;
	}
	public int getCardNum() {
		return cardNum;
	}
	
	// HashSet을 이용해 Card클래스의 중복을 제거할때 필요한 코드들 입니다.
	@Override
	public int hashCode() {
		return (int)this.cardAlphabet + this.cardNum;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Card) {
			Card card = (Card)obj;
			if(this.cardAlphabet==card.cardAlphabet && this.cardNum == card.cardNum) {
				return true;
			}
		}
		return false;
	}
	
}

public class CardTest {

	public static void main(String[] args) {

		// 처음 플레이어 4명
		Player player[] = new Player[4];
		for(int i=0 ; i < 4 ; i++) {
			player[i] = new Player(i+1);
		}
		
		List<Card> cards = new ArrayList<Card>(new HashSet<Card>());
		
		
		// 플레이어 수에 딱 맞게 카드 생성합니다. 불필요한 카드 생성을 방지했습니다.
		cards = cardCreate(player.length,cards);
		distributeCard(player,cards);

		// 플레이어들이 보유한 카드와 숫자 계산 총합을 출력합니다.		
		for(int i=0 ; i < player.length ; i++) {
			player[i].printCards();
			System.out.println();
			
		}
		
		
		// winnerPlayer 메소드를 반환했을때 . List의 수가 2 이상이면 동점자가 발생한 것입니다.
		List<Player> winner = winnerPlayer(player);
		
		// 공백.
		System.out.println();
		
		
		
		if(winner.size() ==1) {
			System.out.println("Winner : " + winner.get(0).getName() );
			return;
		}else {
			// 동점자 발생했을 경우 입니다.
			// 위에 코드와 중복되는 코드들이 있어서 하나로 통합하려 했으나
			// 계속 오류가 발생하여 일단은 분리해놨습니다.
			while(winner.size() != 1) {
				Player replayer[] = new Player[winner.size()];
				for(int i=0 ; i < replayer.length ; i++) {
					replayer[i] = new Player(winner.get(i).getNumber());
				}
				cards = new ArrayList<Card>(new HashSet<Card>());
				
				cards = cardCreate(replayer.length,cards);
				distributeCard(replayer,cards); 
				// 플레이어들이 보유한 카드와 숫자 계산 총합을 출력합니다.		
				for(int i=0 ; i < replayer.length ; i++) {
					replayer[i].printCards();
					System.out.println();	
				}
				winner = winnerPlayer(replayer);
				
			}
			
			System.out.println("Winner : " + winner.get(0).getName() );
			
		}
		

	} // 메인메소드 끝입니다.
	
	
	// 카드를 생성하는 메소드 입니다.
	public static List<Card> cardCreate(int playerCount, List<Card> cards) {
		// 플레이어 한명당 카드 개수입니다.
		int countCard = 7;
		
		// 카드 뽑기 위한 범위 설정.
		// 카드 S D H C    1~ 12 로 구성되어 있습니다.
		int min=1; int max=13;
		int alphabetMax=3; int alphabetMin=0;
		char alphabet[] = {'S','D','H','C'};
		
		
		while(cards.size() != playerCount * countCard) {
			Card temp = new Card(alphabet[(int)(Math.random()*(alphabetMax-alphabetMin)+1)], (int)(Math.random() * (max-min+1) +min));
			if(cards.contains(temp)){
				continue;
			}else {
				cards.add(temp);
			}
			
		}
		return cards;
		
	} // cardCreate 끝.
	
	// 플레이어들에게 카드를 분배하는 메소드 입니다.
	public static void distributeCard(Player player[], List<Card> cards) {
		// 카드 생성시 중복된 것을 제거 했으니
		// 플레이어들에게 카드 분배는 순서대로 해도 됩니다.
		
		int cardCount=0;
			
		for(int i=0 ; i < player.length ; i++) {
			for(int j=0 ; j < 7 ; j++) {
				player[i].setCard(cards.get(cardCount));
				cardCount++;
			}
			
			
		}
		
		
	} // 카드 분배 메소드 끝.
	
	
	// 승자를 판단하는 메소드 입니다.
	public static List<Player> winnerPlayer(Player player[]) {
		// 최소값은 큰 값으 초기화 했습니다.
		int sumMin=200;
		List<Player> winners = new ArrayList<Player>();
		
		// 최소값을 구하는 for문 입니다.
		for(int i=0; i < player.length ; i++) {
			if(player[i].sumCardNumber() < sumMin) {
				sumMin = player[i].sumCardNumber();
			}
		}
		
		// 최소값에 해당하는 사람이 몇명인지 판단하고.
		// 동점자를 판단할 수 있게 winners 리스트에 추가하였습니다. 
		for(int i=0 ; i < player.length ; i++) {
			if(player[i].sumCardNumber() == sumMin) {
				winners.add(player[i]);
			}
		}
		
		return winners;
	} 
	// winnerPlayer 메소드 끝.

}
