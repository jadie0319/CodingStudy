package Sort;

import java.util.Arrays;
/**
 * Created by choijaeyong on 2016. 3. 25..
 */
public class QuickSort {


    public void quicksort(int[] array, int left, int right) { //left는 배열의 맨 왼쪽, right는 배열 맨끝.

        if(left>=right) {
            return;
        }
        int low = left + 1; // low 는 left 의 한칸 옆
        int high = right;   // high 는 right 와 동일함
        int pivot = array[left];  ////pivot은 정렬 대상에서 제외 되어야 한다.

        while (low <= high) {
            while (low <= right && array[low] <= pivot) { // 앞에서부터 피봇보다 큰게 있는지 검사.
                low++;
            }

            while (left + 1 <= high && pivot <= array[high]) { //뒤에서부터 피봇보다 작은게 있는지 검사.
                high--;
            }

            if (low <= high) {
                int temp = array[low];
                array[low] = array[high];  //앞에서 피봇보다 큰것과 뒤에서 피봇보다 작은것을 교환.
                array[high] = temp;
            } else {
                array[left] = array[high];  //만약 low가 high보다 커지면
                array[high] = pivot;        //high가 있는 위치와 pivot 숫자위치를 교환해준다.
            }
        }

        quicksort(array, left, high - 1 );    //pivot은 정렬 대상에서 제외 되어야 한다.
        quicksort(array, high + 1, right );
    }
//    public <E> void printArray(E[] array) {
//        for (E value : array) {
//            System.out.print(value);
//            System.out.print(" ");
//        }
//        System.out.println("");
//    }


    public static void main(String[] args) {
        int dataSet[] = new int[]{5, 10, 4, 9, 15, 14, 13};
        QuickSort qs = new QuickSort();

        System.out.println("퀵정렬 예제. 배열 크기 : " + dataSet.length);
        System.out.print(Arrays.toString(dataSet));

        System.out.println("\n퀵정렬 실행 후!!!");
        qs.quicksort(dataSet,0,dataSet.length-1);
        System.out.print(Arrays.toString(dataSet));




    }
}
