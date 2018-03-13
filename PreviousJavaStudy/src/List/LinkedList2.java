package List;

/**
 * Created by choijaeyong on 2016. 1. 27..
 */
public class LinkedList2 {
    public static void main(String[] args) {
        ListNode ln = new ListNode("list1",1);
        ListNode ln2 = new ListNode("list2",2);
        ListNode ln3 = new ListNode("list3",3);
        ListNode insertNode = new ListNode("list_insert",4);

        ln.setNext(ln2);
        ln2.setNext(ln3);
        ln3.setData(123);
        insertNode.InsertInLinkedList(ln,insertNode,3);

        System.out.println("총 노드의 길이 : " + ln.ListLength(ln));
        System.out.println("-----------------");

        System.out.print("ln 노드의 값 : "+ln.getData() + "  ");
        System.out.print("ln 노드의 주소: "+ln + "  ");
        System.out.println("ln 노드의 getNext : "+ln.getNext());


        System.out.print("ln2 노드의 값 : "+ln2.getData() + "  ");
        System.out.print("ln2 노드의 주소 : "+ln2+ "  ");
        System.out.println("ln2 노드의 getNext : "+ln2.getNext());

        System.out.print("ln3 노드의 값 : "+ln3.getData() + "  ");
        System.out.print("ln3 노드의 주소 : "+ln3+ "  ");
        System.out.println("ln3 노드의 getNext : "+ln3.getNext());

        System.out.print("insertNode 노드의 값 : "+insertNode.getData() + "  ");
        System.out.print("insertNode 노드의 주소 : "+insertNode+ "  ");
        System.out.println("insertNode 노드의 getNext : "+insertNode.getNext());

        System.out.println("-----------------");
        ln.DeleteNodeFromLinkedList(ln,3);

        System.out.println("삭제 후!!!");
        System.out.println("총 노드의 길이 : " + ln.ListLength(ln));
        System.out.println("-----------------");

        System.out.print("ln 노드의 값 : "+ln.getData() + "  ");
        System.out.print("ln 노드의 주소: "+ln + "  ");
        System.out.println("ln 노드의 getNext : "+ln.getNext());


        System.out.print("ln2 노드의 값 : "+ln2.getData() + "  ");
        System.out.print("ln2 노드의 주소 : "+ln2+ "  ");
        System.out.println("ln2 노드의 getNext : "+ln2.getNext());

        System.out.print("ln3 노드의 값 : "+ln3.getData() + "  ");
        System.out.print("ln3 노드의 주소 : "+ln3+ "  ");
        System.out.println("ln3 노드의 getNext : "+ln3.getNext());

        System.out.print("insertNode 노드의 값 : "+insertNode.getData() + "  ");
        System.out.print("insertNode 노드의 주소 : "+insertNode+ "  ");
        System.out.println("insertNode 노드의 getNext : "+insertNode.getNext());

        System.out.println("");
        System.out.println("Search Test : 123 검색 ");
        System.out.println(ln.searchNode(ln,123).equals(ln2));  // 여기에서 ln3 라는 값을 출력하고싶은데!!!! 안된다.
        System.out.println(ln.searchNode(ln,123).getName());

        System.out.println("-------- 리스트삭제 ---------");  // 객체를 삭제하는 방법이 없나???????
        ln.DeleteLinkedList(ln);
        System.out.println("총 노드의 길이 : " + ln.ListLength(ln));

        System.out.print("ln 노드의 값 : "+ln.getData() + "  ");
        System.out.print("ln 노드의 주소: "+ln + "  ");
        System.out.println("ln 노드의 getNext : "+ln.getNext());


        System.out.print("ln2 노드의 값 : "+ln2.getData() + "  ");
        System.out.print("ln2 노드의 주소 : "+ln2+ "  ");
        System.out.println("ln2 노드의 getNext : "+ln2.getNext());

        System.out.print("ln3 노드의 값 : "+ln3.getData() + "  ");
        System.out.print("ln3 노드의 주소 : "+ln3+ "  ");
        System.out.println("ln3 노드의 getNext : "+ln3.getNext());

    }

}
