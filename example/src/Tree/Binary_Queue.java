package Tree;

/**
 * Created by choijaeyong on 2016. 3. 3..
 */
public class Binary_Queue {
    private BinaryTreeNode frontNode;
    private BinaryTreeNode rearNode;
    public Binary_Queue() {
        this.frontNode=null;
        this.rearNode=null;
    }

    public Binary_Queue createQueue() {
        return new Binary_Queue();
    }

    public boolean Queue_IsEmpty() {
        return (frontNode==null);
    }

    public void EnQueue(BinaryTreeNode root) {
        BinaryTreeNode newNode = root;
        if(rearNode != null) {
            rearNode.setNext(newNode);
        }
        rearNode=newNode;
        if(frontNode==null) {
            frontNode=rearNode;
        }

    }

    public BinaryTreeNode DeQueue() {
        BinaryTreeNode tem;
        if(Queue_IsEmpty()) {
            System.out.println("Queue is Empty");
            return null;
        }else {
            tem=frontNode;
            frontNode = frontNode.getNext();
        }
        return tem;
    }

    public void getQueueLength(Binary_Queue lq) {
        BinaryTreeNode ln;
        ln=lq.frontNode;
        int length=0;

        while(ln != null) {
            System.out.print(ln.getData() + "  ");
            length++;
            ln=ln.getNext();
        }
        System.out.println("\n리스트로 구현한 큐의 총 길이는 : " + length);
    }

}
