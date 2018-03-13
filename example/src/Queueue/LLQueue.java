package Queueue;

/**
 * Created by choijaeyong on 2016. 2. 19..
 */
public class LLQueue{
    private LLNode2 frontNode; //headNode에 해당
    private LLNode2 rearNode; //lastNode에 해당
    public LLQueue() {
        this.frontNode=null;
        this.rearNode=null;
    }
    public LLQueue createQueue() {
        return new LLQueue();
    }

    public boolean isEmpty() {
        return (frontNode == null) ;
    }

    public void getQueueLength(LLQueue lq) {
        LLNode2 ln;
        ln=lq.frontNode;
        int length=0;

        while(ln != null) {
            System.out.print(ln.getData() + "  ");
            length++;
            ln=ln.getNext();
        }
        System.out.println("\n리스트로 구현한 큐의 총 길이는 : " + length);
    }


    public void enQueue(int data) {
        LLNode2 newNode = new LLNode2(data);
        if(rearNode != null) {
            rearNode.setNext(newNode);
        }
        rearNode = newNode;
        if(frontNode ==null) {
            frontNode = rearNode;
        }
    }

    public int deQueue() {
        int data=0;
        if(isEmpty()) {
            System.out.println("Queue empty");
            return 0;
        } else{
            data=frontNode.getData();
            frontNode = frontNode.getNext();
        }
        return data;
    }
}
