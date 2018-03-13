package Stack;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by choijaeyong on 2016. 2. 15..
 */
public class LLStack{
    private LLNode headNode;
    public LLStack(int data) {
        this.headNode = new LLNode(data);
    }
    public void push(int data) {
        if(headNode==null) {
            headNode = new LLNode(data);
        }else if(headNode.getData() == 0) {
            headNode.setData(data);
        } else {
            LLNode llNode = new LLNode(data);
            llNode.setNext(headNode);
            headNode = llNode;
        }
    }

    public int top() {
        if(headNode == null) {
            return 0;
        } else {
            return headNode.getData();
        }
    }

    public int pop() {
        if(headNode == null) {
            throw new EmptyStackException();
        }else {
            int data = headNode.getData();
            headNode = headNode.getNext();
            return data;
        }
    }

    public boolean isEmpty() {
        if(headNode == null) {
            return true;
        }else{
            return false;
        }
    }

    public void deleteStack() {
        headNode=null;
    }

    public void stack_length(LLStack ls) {
        LLNode ln = new LLNode(1234);
        ln=ls.headNode;
        int length=0;

        while(ln != null) {
            System.out.println(ln.getData() + " ");
            length++;
            ln=ln.getNext();

        }

        System.out.println("스택의 길이는 : "+length);
    }

    public void reverseStack(LLStack ls) {  // 스택 역순으로 출력하기. 재귀 사용.
        if(ls.isEmpty()) return;
        int temp= ls.pop();
        reverseStack(ls); //재귀함수
        insertAtBottom(ls,temp);
    }
    private void insertAtBottom(LLStack ls, int data) {
        if(ls.isEmpty()) {
            ls.push(data);
            return;
        }
        int temp = ls.pop();
        insertAtBottom(ls,data);
        ls.push(temp);
    }

    public LLStack StackSorter(LLStack ls) {
        LLStack ls2 = new LLStack(999);
        while(!ls.isEmpty()) {
            int tmp = (Integer)ls.pop();
            while(!ls2.isEmpty() && (Integer)ls2.top() > tmp) {
                                ls.push(ls2.pop());
            }
            ls2.push(tmp);
        }
        return ls2;
    }



}
