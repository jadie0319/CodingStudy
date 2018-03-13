package Sort;

/**
 * Created by choijaeyong on 2016. 3. 24..
 */
public class InsertionSort {

    public void insertsort(int A[], int n) {
        int v;
        int j;
        for(int i=1 ; i <= n-1 ; i++) { //n이 배열의 갯수르 가져온 값이라서. A[20]까지 있어서 n-1로 해야한다.
            v=A[i];
            j=i;
            while(A[j-1] > v && j>= 1) {
                A[j] = A[j-1];
                j--;
            }
            A[j] = v;
        }
    }

    public static void main(String[] args) {
        int dataSet[] = new int[]{1,4,10,2,42,33,56,15,12,16,19,20,25,44,33,32,54,60,70,80,90};

        InsertionSort is = new InsertionSort();

        System.out.println("삽입정렬 예제. 배열의 길이는 : " + dataSet.length);
        for(int k:dataSet) {
            System.out.print(k + "  ");
        }

        System.out.println("\n정렬 후 !!");
        is.insertsort(dataSet,dataSet.length);
        for(int k : dataSet) {
            System.out.print( k + "  ");
        }

    }
}
