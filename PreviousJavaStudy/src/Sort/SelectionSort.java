package Sort;

/**
 * Created by choijaeyong on 2016. 3. 24..
 */

public class SelectionSort {
    public void selectionsort(int A[], int n) {
        int min=0;
        int temp=0;
        for(int i=0 ; i< n-1 ; i++) {
            min=i;
            for(int j=i+1 ; j<n ; j++) {
                if(A[min] > A[j]) {
                    min=j;
                }
            }
            temp=A[min];
            A[min] = A[i];
            A[i] = temp;
        }
    }


    public static void main(String[] args) {
        int dataSet[] = new int[]{1,4,10,2,42,33,56,15,12,16,19,20,25,44,33,32,54,60,70,80,90};
        SelectionSort ss = new SelectionSort();

        System.out.println("Selection Sort 예제. 배열의 크기는 : " + dataSet.length);
        for(int k:dataSet) {
            System.out.print(k + "  ");
        }
        System.out.println("\n정렬 후!!!");
        ss.selectionsort(dataSet,dataSet.length);
        for(int k:dataSet) {
            System.out.print(k + "  ");
        }

    }
}
