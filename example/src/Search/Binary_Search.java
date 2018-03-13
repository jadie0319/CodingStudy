package Search;

import java.util.Scanner;

/**
 * Created by choijaeyong on 2016. 3. 27..
 */
public class Binary_Search {

    public static int binarySearch(int[] A,int n,int data) {
        int low=0;
        int mid=0;
        int high=n-1;
        while(low <= high) {
            mid=low + (high-low)/2;
            if(A[mid] == data) {
                return mid+1;
            } else if(A[mid] <data) {
                low = mid+1;
            } else {
                high=mid-1;
            }
        }
        return 0;
    }

    public static void insertionsort(int A[],int n) {
        int v;
        int j;
        for(int i=1 ; i<= n-1 ; i++) {
            v=A[i];
            j=i;
            while(A[j-1] > v && j >=1) {
                A[j] = A[j-1];
                j--;
            }
            A[j]=v;
        }
    }

    public static void main(String[] args) {
        int[] dataSet= {11,22,33,66,77,88,44,55,99,45,64,23,12,37};
        Scanner sc = new Scanner(System.in);
        //222를 찾아보자
        System.out.println("우선 데이터를 정렬한다.");
        insertionsort(dataSet,dataSet.length);
        for(int k : dataSet) {
            System.out.print(k + "  ");
        }

        System.out.println("\n배열에서 위치를 찾아보자");
        int a=sc.nextInt();
        int position = binarySearch(dataSet,dataSet.length,a);
        System.out.println("숫자 " + a + "의 위치는 = " + position);





    }
}
