package Chapter1.Question8;

import java.util.ArrayList;
import java.util.Hashtable;

/*
 *  1-8 0행렬 : M * N 행렬의 한 원소가 0일 경우, 해당 원소가 속한 행과 열의 모든
 *  원소를 0으로 설정하는 알고리즘을 작성하라.
 */


public class Interview8 {

	public static void main(String[] args) {
		int[][] matrix = new int[3][4];
		int num = 0;
		System.out.println("--------original");
		for(int i=0; i < 3 ; i++) {
			for(int j=0; j < 4 ; j++) {
				matrix[i][j] = num;
				num++;
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		Interview8 interview = new Interview8();
		
		matrix = interview.zeroMatrix(matrix);
		
		for(int i=0; i < 3 ; i++) {
			for(int j=0; j < 4 ; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		
		

	}
	
	int[][] zeroMatrix(int[][] matrix) {
		ArrayList<Integer> rows = new ArrayList<Integer>();
		ArrayList<Integer> cols = new ArrayList<Integer>();
		
		for(int i=0 ; i < 3 ; i++) {
			for(int j=0 ; j <4 ; j++) {
				if(matrix[i][j] == 0 ) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		
		for(int i=0 ; i < rows.size() ; i++) {
			for(int j=0 ; j < 4 ; j++) {
				matrix[rows.get(i)][j] =0;
			}
		}
		for(int i=0 ; i < cols.size() ; i++) {
			for(int j=0 ; j < 3 ; j++) {
				matrix[j][cols.get(i)] =0;
			}
		}
		
		
		
		
		return matrix;
	}
	
	
	
	

}
