package Queueue;

/**
 * Created by choijaeyong on 2016. 2. 19..
 */
public class Queue_ex {
    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(10);

        aq.createQueue(10); //초기값으로 array[0] 에 0값 들어가있다.

        System.out.println("Queue의 길이 : " + aq.getQueueSize());
        System.out.println("aq.isEmpty -> " + aq.isEmpty());
        System.out.println("");

        aq.enQueue(1);
        aq.enQueue(2);
        aq.enQueue(3);
        aq.enQueue(4);
        aq.enQueue(5);
        System.out.println("enQueue 후 Queue의 길이 : " + aq.getQueueSize());
        aq.printQueue(aq);
        System.out.println("");

        System.out.println("aq.deQueue() 결과 : " + aq.deQueue());
        System.out.println("aq.deQueue() 결과 : " + aq.deQueue());

        System.out.println("deQueue 후 Queue의 길이 : " + aq.getQueueSize());
        aq.printQueue(aq);
        System.out.println("");



    }
}
