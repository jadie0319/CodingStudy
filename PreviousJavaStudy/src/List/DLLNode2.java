package List;

/**
 * Created by choijaeyong on 2016. 2. 2..
 */
public class DLLNode2 {
    public static void main(String[] args) {
        DLLNode dl1 = new DLLNode(1);
        DLLNode dl2 = new DLLNode(2);
        DLLNode dl3 = new DLLNode(3);
        DLLNode dl4 = new DLLNode(4);
        DLLNode dlInsert = new DLLNode(100);

        dl1.setList(null,dl2);
        dl2.setList(dl1,dl3);
        dl3.setList(dl2,dl4);
        dl4.setList(dl3,null);

        System.out.println("리스트 총 길이 : "+dl1.DLLLength(dl1));
        System.out.print("dl1 참조값 : " + dl1 + "  ");
        System.out.print("dl1 이전 노드 : " + dl1.getPrevious() + "  ");
        System.out.print("dl1 다음 노드 : " + dl1.getNext() + "  ");
        System.out.println("dl1 값 : " + dl1.getData());

        System.out.print("dl2 참조값 : " + dl2 + "  ");
        System.out.print("dl2 이전 노드 : " + dl2.getPrevious() + "  ");
        System.out.print("dl2 다음 노드 : " + dl2.getNext() + "  ");
        System.out.println("dl2 값 : " + dl2.getData());

        System.out.print("dl3 참조값 : " + dl3 + "  ");
        System.out.print("dl3 이전 노드 : " + dl3.getPrevious() + "  ");
        System.out.print("dl3 다음 노드 : " + dl3.getNext() + "  ");
        System.out.println("dl3 값 : " + dl3.getData());

        System.out.print("dl4 참조값 : " + dl4 + "  ");
        System.out.print("dl4 이전 노드 : " + dl4.getPrevious() + "  ");
        System.out.print("dl4 다음 노드 : " + dl4.getNext() + "  ");
        System.out.println("dl4 값 : " + dl4.getData());

        System.out.println("------------ 3번째 위치에 삽입! ------------");
        dl1.DLLInsert(dl1,dlInsert,3);
        System.out.println("리스트 총 길이 : "+dl1.DLLLength(dl1));

        System.out.print("dl1 참조값 : " + dl1 + "  ");
        System.out.print("dl1 이전 노드 : " + dl1.getPrevious() + "  ");
        System.out.print("dl1 다음 노드 : " + dl1.getNext() + "  ");
        System.out.println("dl1 값 : " + dl1.getData());

        System.out.print("dl2 참조값 : " + dl2 + "  ");
        System.out.print("dl2 이전 노드 : " + dl2.getPrevious() + "  ");
        System.out.print("dl2 다음 노드 : " + dl2.getNext() + "  ");
        System.out.println("dl2 값 : " + dl2.getData());

        System.out.print("dlInsert 참조값 : " + dlInsert + "  ");
        System.out.print("dlInsert 이전 노드 : " + dlInsert.getPrevious() + "  ");
        System.out.print("dlInsert 다음 노드 : " + dlInsert.getNext() + "  ");
        System.out.println("dlInsert 값 : " + dlInsert.getData());

        System.out.print("dl3 참조값 : " + dl3 + "  ");
        System.out.print("dl3 이전 노드 : " + dl3.getPrevious() + "  ");
        System.out.print("dl3 다음 노드 : " + dl3.getNext() + "  ");
        System.out.println("dl3 값 : " + dl3.getData());

        System.out.print("dl4 참조값 : " + dl4 + "  ");
        System.out.print("dl4 이전 노드 : " + dl4.getPrevious() + "  ");
        System.out.print("dl4 다음 노드 : " + dl4.getNext() + "  ");
        System.out.println("dl4 값 : " + dl4.getData());

        System.out.println(" ");
        System.out.println("-------------3,4번째 노드 삭제-------------");
        dl3.DLLDelete(dl1,3);
        dl3.DLLDelete(dl1,4);

        System.out.println("리스트 총 길이 : "+dl1.DLLLength(dl1));

        System.out.print("dl1 참조값 : " + dl1 + "  ");
        System.out.print("dl1 이전 노드 : " + dl1.getPrevious() + "  ");
        System.out.print("dl1 다음 노드 : " + dl1.getNext() + "  ");
        System.out.println("dl1 값 : " + dl1.getData());

        System.out.print("dl2 참조값 : " + dl2 + "  ");
        System.out.print("dl2 이전 노드 : " + dl2.getPrevious() + "  ");
        System.out.print("dl2 다음 노드 : " + dl2.getNext() + "  ");
        System.out.println("dl2 값 : " + dl2.getData());


        System.out.print("dl3 참조값 : " + dl3 + "  ");
        System.out.print("dl3 이전 노드 : " + dl3.getPrevious() + "  ");
        System.out.print("dl3 다음 노드 : " + dl3.getNext() + "  ");
        System.out.println("dl3 값 : " + dl3.getData());



        System.out.println("----------삭제된 노드들 ------------");

        System.out.print("dlInsert 참조값 : " + dlInsert + "  ");
        System.out.print("dlInsert 이전 노드 : " + dlInsert.getPrevious() + "  ");
        System.out.print("dlInsert 다음 노드 : " + dlInsert.getNext() + "  ");
        System.out.println("dlInsert 값 : " + dlInsert.getData());

        System.out.print("dl4 참조값 : " + dl4 + "  ");
        System.out.print("dl4 이전 노드 : " + dl4.getPrevious() + "  ");
        System.out.print("dl4 다음 노드 : " + dl4.getNext() + "  ");
        System.out.println("dl4 값 : " + dl4.getData());


    }
}
