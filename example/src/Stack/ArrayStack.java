package Stack;

public class ArrayStack {
    private int top;
    private int capacity;
    private int[] array;
    public ArrayStack() {
        capacity=3;
        array=new int[capacity];
        top=-1;
    }

    public boolean isEmpty() {
        //이 조건이 참이면 1이 리턴되고 아니면 0이 리턴된다.
        return (top==-1);
    }

    public boolean isStackFull() {
        return (top==capacity-1);
    }

    public void push(int data) {
        if(isStackFull()) {
            System.out.println("Stack Overflow");
        } else {
            array[++top] = data;	

        }
    }

    public int pop() {
        if(isEmpty()) {
            System.out.println("Stack is Empty");
            return 0;
        } else {
            return (array[top--]);
        }
    }

    public void deleteStack() {
        top=-1;
    }

    public void stackLength(ArrayStack as) {
        System.out.println("스택의 길이는 : "+as.array.length);
    }

    public void stackPrint(ArrayStack as) {
        int length=0;
        System.out.print("스택에 들어있는 데이터는 : ");
        while(as != null) {
            if(length < array.length) {
                System.out.print(as.array[length] + " ");
                length++;
            } else {
                return;
            }
        }
    }
}
