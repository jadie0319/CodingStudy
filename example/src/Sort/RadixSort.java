package Sort;

import java.util.Arrays;
/**
 * Created by choijaeyong on 2016. 3. 27..
 */

//실패!!!!!!!!
public class RadixSort {
    public static int[] radixsort(int[] array) {
        for(int shift=Integer.SIZE -1 ; shift > -1 ; shift--) {
            int[] tmp = new int[array.length];
            int j=0;
            for(int i=0; i<array.length ; i++) {
                boolean move=array[i]<<shift>=0;
                if(shift==0 ? !move : move) {
                    tmp[j]=array[i];
                    j++;
                } else {
                    array[i-j]=array[i];
                }
            }
            for(int i=j; i<tmp.length; i++) {
                tmp[i]=array[i-j];
            }
            array=tmp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] dataSet={2,10,5,7,4};
        System.out.println("기수정렬 예제");
        System.out.print(Arrays.toString(dataSet));

        System.out.println("\n기수정렬 후!");
        radixsort(dataSet);
        System.out.print(Arrays.toString(dataSet));


    }
}
