package Sort;

/**
 * Created by choijaeyong on 2016. 3. 23..
 */
public class BubbleSort {
    public void bubblesort(int A[], int n) {
        for(int pass=n-1 ; pass >= 0 ; pass--) {
            for(int i=0 ; i<pass-1;i++) {
                if(A[i] > A[i+1]) {    //앞에 것이 뒤에것보다 크다면 교환한다. 오름차순.
                    int temp=A[i];
                    A[i] = A[i+1];
                    A[i+1] = temp;
                }
            }
        }
    }

    public void bubblesortImproved(int A[], int n) {
        int pass,i,temp,swapped=1;
        for(pass= n-1 ; pass >= 0 && swapped==1 ; pass--) {
            swapped=0;
            for(i=0 ; i< pass -1 ; i++) {
                if(A[i] > A[i+1]) {
                    temp=A[i];
                    A[i] = A[i+1];
                    A[i+1] = temp;
                    swapped=1;
                }
            }
        }
    }

    public static void main(String[] args) {

        int dataSet[] = new int[]{1,4,10,2,42,33,56,15,12,16,19,20,25,44,33,32,54,60,70,80,90};
        BubbleSort bs = new BubbleSort();

        System.out.println("BubbleSort!!! 배열 총 길이 : " + dataSet.length );
        for (int k:dataSet) {
            System.out.print(k + "  ");
        }
        System.out.println("\n오름차순으로 정렬후!");
//        bs.bubblesort(dataSet,dataSet.length);   //그냥 버블소트
        bs.bubblesortImproved(dataSet, dataSet.length);  //향상된 버블소트. 더이상 교환이 없다면 정렬이 완료된 걸 뜻함.
        for (int k:dataSet) {
            System.out.print(k + "  ");
        }


    }
}
