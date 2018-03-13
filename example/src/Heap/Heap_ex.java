package Heap;

/**
 * Created by choijaeyong on 2016. 3. 14..
 */
public class Heap_ex {
    public static void main(String[] args) {
        Heap heap1 = new Heap(7,1);

//        heap1.HeapArray[2]=3;
//        heap1.HeapArray[3]=4;
//        heap1.HeapArray[4]=5;
//        heap1.HeapArray[5]=6;
//        heap1.HeapArray[6]=7;

        heap1.HeapPrint();
//        System.out.println(" ");
        System.out.println("왼쪽자식값 : " + heap1.LeftChildValue(1));
        heap1.Insert(1);
        heap1.Insert(2);
        heap1.Insert(5);
        heap1.Insert(6);
        heap1.Insert(3);
        heap1.Insert(11);
        heap1.Insert(15);
        heap1.HeapPrint();System.out.println(" ");
        System.out.println("트리구조에서 data 5, array[1]의 왼쪽 자식 : " + heap1.LeftChildValue(1));
        System.out.println("트리구조에서 data 5, array[1]의 오른쪽 자식 : " + heap1.RightChildValue(1));
        heap1.Insert(8);
        heap1.Insert(7);
        heap1.Insert(4);
        heap1.Insert(20);
        heap1.Insert(19);
        heap1.Insert(16);
        heap1.Insert(17);
        heap1.HeapPrint();System.out.println(" ");
//        heap1.PercolateDown(0);
//        heap1.HeapPrint();System.out.println(" ");

        // 배열을 힙으로 만들기
        System.out.println("배열을 힙으로 만들기!! ");
        Heap heap2 = new Heap(7,1);
        int[] temp_array = new int[7];
        for(int i=0 ; i< temp_array.length ; i++) {
            temp_array[i] = i;
            System.out.print(temp_array[i] + "  ");
        }
        System.out.println(" ");

        heap2.BuildHeap(heap2,temp_array,7);
        heap2.HeapPrint();



    }
}
