package Stack;

/**
 * Created by choijaeyong on 2016. 2. 15..
 */
public class LLNode {
    private int data;
    private LLNode next;

    public LLNode(int data) {
        this.data = data;
    }
    public void setData(int data) {
        this.data=data;
    }
    public int getData() {
        return data;
    }
    public void setNext(LLNode next) {
        this.next=next;
    }
    public LLNode getNext() {
        return this.next;
    }


}
