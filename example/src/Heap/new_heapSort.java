package Heap;

/**
 * Created by choijaeyong on 2016. 3. 15..
 */
public class new_heapSort {
    public static void heapSort(int[] arr) {
        new_Heap heap = new new_Heap();
        System.out.println("Heap Insert");
        for(int i=0 ; i < arr.length ; i++) {
            heap.insertHeap(arr[i]);
        }
        System.out.println("Heap Insert 결과 ");
        for(int i=0 ; i < arr.length ; i++) {
            System.out.print(arr[i] + "  ");
        }

        System.out.println("\nHeap deleteHeap() 실행");
        for(int i=arr.length -1 ; i>=0; --i) {
            arr[i] = heap.deleteHeap();
        }

        System.out.println("힙 정렬 결과");
        for(int i=0 ; i < arr.length ; i++) {
            System.out.print(arr[i] + "  ");
        }

    }
}
