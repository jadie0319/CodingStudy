package Hasing;

/**
 * Created by choijaeyong on 2016. 3. 28..
 */
public class HashTableOperations {
    private int dddad;
    public final static int LOADFACTOR = 20;
    public static HashTable createHashTable(int size) {
        HashTable h = new HashTable();
        //최초에는 1로 설정된다??

        h.setTSize(size/LOADFACTOR);
        for(int i=0; i<h.getTSize() ; i++) {
            h.getTable()[i].setStartNode(null);
        }
        return h;
    }
    //해쉬함수 임의로 내가 구현을 해 놓은것. data값들로 숫자만 받으니까 가능한것
    //문자 키값은 다르게 생각. 문자열을 받으면 이것의 아스키값을 더해서 저장하면 되지 않을까?
    public static int Hash(int data, int table_size) {
        int nodeNum = data % 5;
        return nodeNum;
    }

    public static int hashSearch(HashTable h, int data) {
        ListNode temp;
        temp=h.getTable()[Hash(data,h.getTSize())].getStartNode();
        while(temp != null) {
            if(temp.getData() == data) {
                return 1;
            }
            temp=temp.getNext();
        }
        return 0;  //값이 없으면 0 리턴한다.
    }

    public static void hashInsert(HashTable h,int data) {
        int index;
        ListNode temp,newNode;
        if(hashSearch(h,data) != 0) {   //값이 없을때 0을 리턴함. 이 테이블에 이미 data가 있으면 0 리턴?
            return;  // search값이 0이 아니면 값이 있다는거고 그것은 걍 리턴한다.
        }
        index = Hash(data,h.getTSize());
        temp = h.getTable()[index].getStartNode(); //이 부분 책과 다름. 오류시 검토 필요!
        newNode = new ListNode();
        if(newNode !=null) {
            System.out.println("Memory Error");
            return;
        }
        newNode.setKey(index);
        newNode.setData(data);
        newNode.setNext(h.getTable()[index].getStartNode());
        h.getTable()[index].getStartNode().setNext(newNode);
        h.getTable()[index].setBlockCount(h.getTable()[index].getBlockCount()+1);
        h.setCount(h.getCount()+1);
//        if(h.getCount() / h.getTSize() >LOADFACTOR) {
//            Rehash(h);
//        }
        return;
    }

    //일단 중지
    public static void Rehash(HashTable h) {
        int oldsize,i,index;
        ListNode p, temp, temp2;
        HashTableNode[] oldTable;
        oldsize = h.getTSize();
        oldTable=h.getTable();
        h.setTSize(h.getTSize()*2);
        h=new HashTable();
    }

    public static boolean hashDelete(HashTable h, int data) {
        ListNode temp,prev;
        int index = Hash(data,h.getTSize());

        return true;
    }
}
