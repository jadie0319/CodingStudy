package Heap;

/**
 * Created by choijaeyong on 2016. 3. 14..
 */

// 최대힙으로 구현
public class Heap {
    private int[] HeapArray;
    private int count; // 힙안의 요소의 수
    private int capacity; // 힙의 크기
    private int heap_type; // 최저 힙인지 최대 힙인지
    public Heap(int capacity, int heap_type) {
        this.heap_type = heap_type;
        this.capacity = capacity;
        this.count=0;
        this.HeapArray = new int[capacity];
    }
    public void HeapPrint() {
        for(int i=0 ; i<HeapArray.length ; i++) {
            System.out.print(HeapArray[i] + "  ");
        }
    }
    public int Parent(int i) {
        if(i<=0 || i >= this.count) {
            return -1;
        }
        return (i-1)/2;
    }
    public int LeftChildValue(int i) {
        int left= 2*i +1;
        if(left >= this.count) {
            return -1;
        }
        return this.HeapArray[left];
    }

    public int RightChildValue(int i) {
        int right = 2*i +2;
        if(right >= this.count) {
            return -1;
        }
        return this.HeapArray[right];
    }

    public int LeftChild(int i) {
        int left= 2*i +1;
        if(left >= this.count) {
            return -1;
        }
        return left;
    }

    public int RightChild(int i) {
        int right = 2*i +2;
        if(right >= this.count) {
            return -1;
        }
        return right;
    }

    // 최대힙에서 최대값은 배열의 맨 처음에 위치해 있다.
    public int GetMaximum() {
        if(this.count ==0) {
            return -1;
        }
        return this.HeapArray[0];
    }

    public void PercolateDown(int i) {
        int l=0;
        int r=0;
        int max=0;
        int temp=0;
        l=LeftChild(i);  // 왼쪽자식
        r=RightChild(i); // 오른쪽자식
        if(l != -1 && this.HeapArray[l] > this.HeapArray[i]) {
            max =l;
        }else {
            max=i;
        }

        if( r != -1 && this.HeapArray[r] > this.HeapArray[i]) {
            max=r;
        }
        if(max != i) {
            temp=this.HeapArray[i];
            this.HeapArray[i]= this.HeapArray[max];
            this.HeapArray[max] = temp;

        }
//        PercolateDown(max);

    }

    public void Insert(int data) {
        int i=0;
        if(this.count == this.capacity) {
            System.out.println(" ResizeHeap 작동!! ");
            ResizeHeap();
        }
        this.count++;
        i=this.count-1;
        while(i >=0 && data > this.HeapArray[(i-1)/2]) {
            this.HeapArray[i]=this.HeapArray[(i-1)/2];

            if(i==0) {
                this.HeapArray[i]=data;
                return;
            }
            i= (i-1)/2;
        }
        this.HeapArray[i]=data;

    }

    // 기존에 capacity를 초과하게 되면 capacity의 두배로 늘린다.
    // 2배로 확장시키기 전에 제일 마지막 값인 0이 다음 트리에 추가된다.??
    public void ResizeHeap() {
        int[] array_old= new int[this.capacity];
        System.arraycopy(this.HeapArray, 0, array_old , 0, capacity-1);
        this.HeapArray = new int[this.capacity *2];
        if(this.HeapArray == null) {
            System.out.println("Memory Error");
            return;
        }
        for(int i=0; i< this.capacity ; i++) {
            this.HeapArray[i] = array_old[i];
        }

        this.capacity *= 2;
        array_old=null;
    }

    //최대힙은 어차피 root가 최대임
    public int deleteMax() {
        if(this.count ==0) {
            return -1;
        }
        int data=this.HeapArray[0];
        this.HeapArray[0] = this.HeapArray[this.count-1];
        this.count--;
        PercolateDown(0);
        return data;
    }

    public void destroyHeap() {
        this.count=0;
        this.HeapArray=null;
    }

    public void BuildHeap(Heap h, int A[], int n) {
        if(h==null) {
            return;
        }
        while(n > this.capacity) {
            h.ResizeHeap();
        }
        for(int i=0 ; i < n ; i++) {
//            h.HeapArray[i] = A[i];
            h.Insert(A[i]);
        }
//        this.count=n;
//        for(int i = (n-1)/2 ; i >= 0 ; i--) {
//            h.PercolateDown(i);
//        }
//        h.PercolateDown(2); // 이거 왜 두번 더 돌려주니까 결과가 제대로 나오냐???????????
//        h.PercolateDown(2); // 여기까지만 돌리고 아래에 더 추가해줘도 값 안변한다.
    }

}
