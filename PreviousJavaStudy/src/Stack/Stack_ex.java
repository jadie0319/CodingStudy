package Stack;

/**
 * Created by choijaeyong on 2016. 2. 15..
 */
public class Stack_ex {
    public static void main(String[] args) {
        LLStack ls = new LLStack(1);
        LLStack Sort_ls = new LLStack(99);


        ls.push(3);
        ls.push(2);
        ls.push(6);
        ls.push(8);
        ls.push(7);
        ls.push(9);
        ls.push(5);
        System.out.println("pop 하기 전 스택의 top = " + ls.top());

        ls.pop();
        ls.pop();
        System.out.println("현재 스택의 top = " + ls.top());

        ls.stack_length(ls);

        System.out.println("스택 reverse 시도하기!");
        ls.reverseStack(ls);
        System.out.println("현재 스택의 top = " + ls.top());
        ls.stack_length(ls);

        System.out.println("스택 오름차순 정렬하기!!");
        Sort_ls=ls.StackSorter(ls);

        Sort_ls.pop();
        ls.stack_length(Sort_ls);
        System.out.println("Sort_ls의 top = " + Sort_ls.top());
    }
}
