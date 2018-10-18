package examples.dice;

public class Dice {
    private int face;

    public Dice(int face) {
        this.face = face;
    }

    // 주사위 숫자야~
    public int getNumber() {
        return (int)(Math.random() * face) +1;
    }

}
