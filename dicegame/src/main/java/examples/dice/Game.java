package examples.dice;

import java.util.List;

public class Game {
    // 여기서 setPlayer 해줄 필요가 없다.
    // xml에서 데이터를 넣을꺼야!
    private List<Player> playerList;

    public Game() {

    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    // 플레이어들의 주사위 값중 최대값을 출력해라~~~~~~~
    public void play() {
        System.out.println("Game play()~~~");

        int temp=0;
        int max=0;

        for(Player player : playerList) {
            System.out.print("print player.play()");
            temp=player.play();
            System.out.println("max : " + max + " temp : " + temp);
            if(temp > max){
                max = temp;
            }

        }
        System.out.println("주사위 최대값은 " + max + " 입니당~");


    }
}
