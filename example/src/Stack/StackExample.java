package Stack;
public class StackExample {

    public static void main(String[] args) {
        ArrayStack as = new ArrayStack();

        as.pop();
        as.push(12);
        System.out.println();

        as.push(13);


        as.stackLength(as);
        as.stackPrint(as);
        System.out.println("");

        System.out.println("as.pop() 결과 : " + as.pop());
        System.out.println("as.pop() 결과 : " + as.pop());
        as.stackPrint(as);
        as.pop();
    }
}
