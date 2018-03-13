package Sort;

import static java.lang.System.out;
import java.util.Arrays;
/**
 * Created by choijaeyong on 2016. 3. 27..
 */
public class CountingSort {
    public static int[] countingsort(int[] array) {
        int min = array[0];
        int max = array[0];

        for (int x : array) {
            min = Math.min(x, min);
            max = Math.max(x, max);
        }
        return countingsort(array, min, max);
    }

    public static int[] countingsort(int[] array,int low, int high) { //low는 배열의 최소값, high는 배열의 최대값
        int[] counts= new int[high - low +1];
        for(int x: array) {
            counts[x-low]++;
        }
        int current=0;
        for(int i=0 ; i<counts.length; i++) {
            Arrays.fill(array,current,current+counts[i],i+low);
            current += counts[i];
        }
        return array;

    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] array = {5,7,2,9,1};

        out.println("기수정렬 예제. 배열 크기 : " + array.length);
        out.print(Arrays.toString(array));

        out.println("\n정렬후!!");
        array=countingsort(array);
        out.print(Arrays.toString(array));

        out.println("\n다른 예제 (p417쪽)");
        int[] array2={0,1,1,0,1,2,1,2,0,0,0,1};
        out.print(Arrays.toString(array2));

        out.println("\n정렬후!!");
        array2=countingsort(array2);
        out.print(Arrays.toString(array2));






        long end = System.currentTimeMillis();
        System.out.println("\n실행시간 :  " + (end-start)/1000.0);

    }
}
