package Tree;


import java.util.EmptyStackException;

/**
 * Created by choijaeyong on 2016. 3. 2..
 * LLStack를 Interface로 만들어서 그냥 패키지마다 implements 해서 만들까...?
 */
public class LLStack {
    private LLNode headNode;

    private BinaryTreeNode BT;
    public LLStack(int data) {
        this.headNode = new LLNode(data);
    }

    public void push(int data) {    //비재귀적 전위탐색에서 root를 푸쉬하기 위해 파라미터값을 노드로.???
        if(headNode==null) {
            headNode = new LLNode(data);
        } else if(headNode.getData()==0) {
            headNode.setData(data);
        } else {
            LLNode llnode = new LLNode(data);
            llnode.setNext(headNode);
            headNode = llnode;
        }
    }


    public boolean isEmpty() {
        if(headNode==null) {
            return true;
        } else {
            return false;
        }
    }

    public int top() {
        if(headNode == null) {
            return 0;
        }else {
            return headNode.getData();
        }
    }

    public int pop() {
        if(headNode == null) {
            throw new EmptyStackException();
        } else {
            int data = headNode.getData();
            headNode = headNode.getNext();
            return data;
        }
    }

    public void Stack_Length(LLStack ls) {
        LLNode ln = new LLNode(123);
        ln=ls.headNode;
        int length=0;

        while(ln!=null) {
            System.out.println(ln.getData() + " ");
            length++;
            ln=ln.getNext();
        }
        System.out.println("스택의 길이는 : " + length);
    }
}
