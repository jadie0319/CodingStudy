package Heap;

/**
 * Created by choijaeyong on 2016. 3. 15..
 */
public class new_Heap {
    private int heapSize;
    private int itemHeap[];

    public new_Heap() {
        heapSize=0;
        itemHeap = new int[50];
    }

    public void insertHeap(int item) {
        int i= ++heapSize;

        while((i != 1) && (item > itemHeap[i/2])) {
            itemHeap[i] = itemHeap[i/2];
            i /=2;
        }
        itemHeap[i] = item;
    }

    public int getHeapSize() {
        return this.heapSize;
    }

    public int deleteHeap() {   //item은 root 값. temp는 유효 힙에서 제일 마지막 leaf를 가리킨다.
        int parent, child;  // parent는
        int item, temp;
        item=itemHeap[1];
        temp = itemHeap[heapSize--];
        parent=1;
        child=2;

        while(child <= heapSize) {
            if((child < heapSize) && (itemHeap[child] < itemHeap[child+1])) {
                child++;
            }
            if(temp >= itemHeap[child])
                break;

            itemHeap[parent] = itemHeap[child];
            parent=child;
            child *= 2;

        }
        itemHeap[parent] = temp;
        return item;

    }

}
