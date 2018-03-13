package List;

/**
 * Created by choijaeyong on 2016. 1. 27..
 */
public class ListNode {
    private int data;
    private ListNode next;
    private String name;

    public ListNode(String name, int data) {
        this.data= data;
        this.name=name;
    }

    public void setData(int data) {
        this.data=data;
    }

    public int getData() {
        return data;
    }

    public void setNext(ListNode next) {
        this.next=next;
    }
    public ListNode getNext() {
        return this.next;
    }

    public String getName() {
        return this.name;
    }

    int ListLength(ListNode headNode) { //default 접근제어자.해당 패키지 내에서만 접근이 가능하다
        int length=0;
        ListNode currentNode = headNode;
        while(currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
        }
        return length;
    }


    ListNode InsertInLinkedList(ListNode headNode, ListNode nodeToInsert, int position) {
        if(headNode == null) { //최초로 설정
            return nodeToInsert;
        }
        int size = ListLength(headNode);
        if(position > size+1 || position <1) {
            System.out.println("여기엔 삽입이 안되요!");
            return headNode;
        }
        if(position ==1 ) {
            nodeToInsert.setNext(headNode); //첫 노드를 삽입한다.
            return nodeToInsert;
        }else { // 중간과 끝에 노드를 삽입한다.
            ListNode previousNode = headNode;
            int count=1;
            while(count < position-1) {
                previousNode = previousNode.getNext();
                count++;
            }
            ListNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            previousNode.setNext(nodeToInsert);
        }

        return headNode;

    }


    ListNode DeleteNodeFromLinkedList(ListNode headNode, int position) {
        int size=ListLength(headNode);
        if(position > size || position <1) {
            System.out.println("유효한 position 이 아닙니다.");
            return headNode;
        }
        if(position==1) {
            ListNode currentNode = headNode.getNext();
            headNode = null;
            return currentNode;
        }else {
            ListNode previousNode=headNode;
            int count=1;
            while(count < position-1) {
                previousNode = previousNode.getNext();
                count++;
            }
            ListNode currentNode = previousNode.getNext();
            previousNode.setNext(currentNode.getNext());
            currentNode=null;
        }

        return headNode;
    }


    ListNode searchNode(ListNode headNode, int data) {
        ListNode temp = headNode;
        while(temp != null) {
            if(data == temp.getData()) {
                return temp;
            } else {
                temp=temp.getNext();
            }
        }
        return temp;
    }


    void DeleteLinkedList(ListNode head) {
        ListNode auxilaryNode=null;
        ListNode iterator = head;

        while(iterator != null) {
            auxilaryNode = iterator.getNext();
            iterator.setNext(null);
            iterator.setData(0);
            iterator=null;
            iterator = auxilaryNode;
        }
    }

    ListNode ReverseList(ListNode head) { //리스트를 그림으로 그려서 화살표 방향만 바뀐다고 생각하면 쉽다.
        ListNode temp=null;
        ListNode nextNode=null;
        while(head !=null) {
            nextNode = head.getNext();
            head.setNext(temp);
            temp=head;  // 이전의 헤드를 임시 템프에 넣는다고 생각
            head=nextNode;
        }
        return temp;
    }
}
