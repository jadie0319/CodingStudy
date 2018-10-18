package examples.dice;

public class Player {
    private Dice dice;
    private String name;

    public Player() {

    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int play() {
        int diceNumber = this.dice.getNumber();
        System.out.println(this.name + "님의 주사위 수는?  "  + diceNumber + " 입니다.");
        return diceNumber;
    }
}
