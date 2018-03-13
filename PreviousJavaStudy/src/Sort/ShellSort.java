package Sort;



/**
 * Created by choijaeyong on 2016. 3. 24..
 */
public class ShellSort {
    public void shellsort(int A[], int array_size) {
        int h=1;
        while(h <= array_size / 3) {
            h=3*h +1;
        }
        // h = 13  h가 간격

        while(h>0) {
            for(int i=h ; i< array_size ; i++) {
                int temp = A[i];  // A[13] = 44
                int j=i;   // 처음 j = 13

                while(j > h-1 && A[j-h] >= temp) {  //삽입정렬
                    A[j] = A[j-h];
                    j -= h;
                }
                A[j]=temp;

            }
            h= (h-1)/3;  // 간격을 줄인다.
        }

    }
    public static void main(String[] args) {
        int dataSet[] = new int[]{1,4,10,2,42,33,56,15,12,16,19,20,25,44,33,32,54,60,70,80,90};
        int dataSet2[] = new int[]{5,2,4,6,1};

        ShellSort ss = new ShellSort();

        System.out.println("쉘정렬 예제. 배열의 길이는 : " + dataSet.length);
        for(int k:dataSet2) {
            System.out.print(k + "  ");
        }

        System.out.println("\n정렬 후 !!");
        ss.shellsort(dataSet2,dataSet2.length);
        for(int k : dataSet2) {
            System.out.print( k + "  ");
        }
    }
}
