package Queueue;

/**
 * Created by choijaeyong on 2016. 2. 19..
 */
public class LLNode2 {
    private int data;
    private LLNode2 next;
    public LLNode2(int data) {
        this.data=data;
    }
    public void setData(int data) {
        this.data=data;
    }
    public int getData() {
        return this.data;
    }
    public void setNext(LLNode2 next) {
        this.next = next;
    }
    public LLNode2 getNext() {
        return this.next;
    }
}
