package List;

/**
 * Created by choijaeyong on 2016. 2. 2..
 */
public class DLLNode {
    private int data;
    private DLLNode next;
    private DLLNode previous;
    public DLLNode(int data) {
        this.data=data;
    }

    public void setData(int data) {
        this.data=data;
    }
    public int getData() {
        return data;
    }
    public void setNext(DLLNode next) {
        this.next=next;
    }
    public DLLNode getNext() {
        return this.next;
    }
    public void setPrevious(DLLNode previous) {
        this.previous = previous;
    }
    public DLLNode getPrevious() {
        return this.previous;
    }

    public void setList(DLLNode prep, DLLNode nex) {
        this.setPrevious(prep);
        this.setNext(nex);
    }


    int DLLLength(DLLNode headNode) {
        int length=0;
        DLLNode currentNode=headNode;
        while(currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
        }
        return length;
    }

    DLLNode DLLInsert(DLLNode headNode, DLLNode nodeToInsert, int position) {
        if(headNode==null){
            return nodeToInsert;
        }
        int size = DLLLength(headNode);

        if(position > size+1 || position <1 ) {
            System.out.println("유효한 position값이 아닙니다.");
            return headNode;
        }
        if(position==1) {
            nodeToInsert.setNext(headNode);
            headNode.setPrevious(nodeToInsert);
            return nodeToInsert;
        } else {
            DLLNode previousNode = headNode;
            int count=1;
            while(count < position-1) {
                previousNode = previousNode.getNext();
                count++;
            }
            DLLNode currentNode=previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            if(currentNode != null) {
                currentNode.setPrevious(nodeToInsert);
            }
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setPrevious(previousNode);
        }
        return headNode;
    }

    DLLNode DLLDelete (DLLNode headNode, int position) {
        int size=DLLLength(headNode);
        if(position > size+1 || position <1) {
            System.out.println("유효한 position값이 아닙니다.");
            return headNode;
        }
        if(position==1) {
            DLLNode currentNode = headNode;
            headNode=null;
            currentNode.setPrevious(null);
            return currentNode;
        } else {
            DLLNode previousNode = headNode;
            int count=1;
            while(count < position-1) {
                previousNode=previousNode.getNext();
                count++;
            }
            DLLNode currentNode = previousNode.getNext();
            DLLNode laterNode = currentNode.getNext();
            previousNode.setNext(laterNode);
            if(laterNode!=null) {
                laterNode.setPrevious(previousNode);
            }
            currentNode=null;
        }
        return headNode;
    }
}

