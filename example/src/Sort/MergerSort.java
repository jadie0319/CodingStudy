package Sort;

import java.util.Arrays;
/**
 * Created by choijaeyong on 2016. 3. 24..
 */
public class MergerSort {

    public static void main(String[] args) {
        int[] array = { 30, 50, 7, 40, 88, 15, 44, 55, 22, 33, 77, 99, 11, 66, 1, 85 ,3};

//        System.out.println("\n합병정렬 예제! 배열 크기 : " + array.length);
//        for(int k : array) {
//            System.out.print(k + "  ");
//        }
//        System.out.println("\n합병정렬 실행! ");
//        array = mergeSort(array);
//        System.out.print(Arrays.toString(array));

        int[] shortArray = new int[] {4,10,2,9,5};

        System.out.println("\n합병정렬 예제! 배열 크기 : " + shortArray.length);
        for(int k : shortArray) {
            System.out.print(k + "  ");
        }
        System.out.println("\n합병정렬 실행! ");
        shortArray = mergeSort(shortArray);
        System.out.print(Arrays.toString(shortArray));



    }

    public static int[] mergeSort(int array[]) {
        if (array.length > 1) {

            int elementsInA1 = array.length / 2;
            int elementsInA2 = array.length - elementsInA1;

            int arr1[] = new int[elementsInA1];
            int arr2[] = new int[elementsInA2];

            for (int i = 0; i < elementsInA1; i++)
                arr1[i] = array[i];

            for (int i = elementsInA1; i < elementsInA1 + elementsInA2; i++)
                arr2[i - elementsInA1] = array[i];

            arr1 = mergeSort(arr1);
            arr2 = mergeSort(arr2); //  재귀에 의해 최종적으로는 맨처음에 나눈 arr1,arr2가
                                    //  정렬이 된 상태로 return된 arr1,arr2가 맨 마지막에 처리된다.
                                    //  array{4,10,2,9,5} arr1{4,10} arr2{2,5,9}

            int i = 0, j = 0, k = 0; //i는 array의 첨자로 사용, j는 arr1의 첨자, k는 arr2의 첨자

            while (arr1.length != j && arr2.length != k) { // 배열의 길이는 첨자보다 1 크다. 같으면 OutOfBound

                if (arr1[j] < arr2[k]) {
                    array[i] = arr1[j]; //작은값을 array[i]에 넣어라.
                    i++;
                    j++;
                } else {
                    array[i] = arr2[k];
                    i++;
                    k++;
                }
            }

            while (arr1.length != j) { //위에 while에서 남은것들 마무리.
                array[i] = arr1[j];
                i++;
                j++;
            }
            while (arr2.length != k) {
                array[i] = arr2[k];
                i++;
                k++;
            }
        }

        return array;
    }
}
