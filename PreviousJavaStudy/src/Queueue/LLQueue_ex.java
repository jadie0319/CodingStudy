package Queueue;

/**
 * Created by choijaeyong on 2016. 2. 19..
 */
public class LLQueue_ex {
    public static void main(String[] args) {
        LLQueue lq = new LLQueue();
        lq.createQueue();

        lq.enQueue(1);
        lq.enQueue(2);
        lq.enQueue(3);
        lq.enQueue(4);
        lq.enQueue(5);

        lq.getQueueLength(lq);
        System.out.println("deQueue() 실행 값 : " + lq.deQueue());
        System.out.println("deQueue() 실행 값 : " + lq.deQueue());
        System.out.println("\n디큐 두번 실행 !!!!");
        lq.getQueueLength(lq);



    }
}
