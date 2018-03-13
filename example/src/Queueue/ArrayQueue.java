package Queueue;

/**
 * Created by choijaeyong on 2016. 2. 19..
 */
public class ArrayQueue {
    public int qqqqq;
    private int front;
    private int rear;
    private int capacity;
    private int[] array;
    public ArrayQueue() {}
    public ArrayQueue(int size) {
        capacity = size;
        front=-1;
        rear=-1;
        array = new int[size];
    }

    public ArrayQueue createQueue(int size) {
        return new ArrayQueue(size);
    }
    public boolean isEmpty() {
        return (front==-1);
    }
    public boolean isFull() {
        return ((rear+1)%capacity == front);
    }
    public int getQueueSize() {
        return ((capacity - front + rear +1)%capacity);
    }

    public void printQueue(ArrayQueue aq) {
        for(int i=front; i <= rear ; i++) {
            System.out.print(aq.array[i] + " ");
        }
    }

    public void enQueue(int data) {
        if(isFull()) {
            System.out.println("Queue overflow");
            return;
        } else {
            rear = (rear+1)%capacity;
            array[rear] = data;
            if(front == -1) {
                front = rear;
            }
        }
    }

    public int deQueue() {
        int data = 0;
        if(isEmpty()) {
            System.out.println("Queue Empty");
            return -1;
        } else {
            data=array[front];
            if(front == rear) {
                front = rear = -1;
            } else {
                front=(front+1)%capacity;
            }
        }
        return data;
    }
}
