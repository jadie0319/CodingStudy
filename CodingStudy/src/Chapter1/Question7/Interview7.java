package Chapter1.Question7;

/*
 * 1-7 핼렬 회전 : 이미지를 표현하는 N * N 행렬이 있다.이미지의 각 픽셀은
 * 4바이트로 표현된다. 이때, 이미지를 90도 회전시키는 메서드를 작성하라. 행렬을
 * 추가로 사용하지 않고서도 할 수 있겠는가?
 */

// ex) 4 * 4 
public class Interview7 {

	public static void main(String[] args) {
		int[][] matrix = new int[4][4];
		int num = 0;
		System.out.println("--------original");
		for(int i=0; i < 4 ; i++) {
			for(int j=0; j < 4 ; j++) {
				matrix[i][j] = num;
				num++;
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
		
		System.out.println("--------rotate");
		Interview7 interview = new Interview7();
		matrix = interview.rotate3(matrix);
		
		for(int i=0; i < 4 ; i++) {
			for(int j=0; j < 4 ; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		

	}
	
	// left  rotate. Add new matrix -> failed!
	int[][] rotate(int[][] matrix) {
		int row = 4;
		int col = 4;
		int test[][] = new int[4][4];
		for(int i=row-1 ; i >= 0 ; i--) {
			for(int j=0 ; j < 4 ; j++) {
				test[3-i][j] = matrix[j][i];

			}

		}
		return test;
		
	}
	
	// right rotate. Add new matrix -> failed!
	int[][] rotate2(int[][] matrix) {
		int row = 4;
		int col = 4;
		int test[][] = new int[4][4];
		for(int i=0 ; i< 4 ; i++) {
			for(int j=0 ; j < 4 ; j++) {
				test[j][3-i] = matrix[i][j];
			}
		}
		return test;
		
	}
	
	// Book's solution.
	int[][] rotate3(int[][] matrix) {
		if(matrix.length == 0 || matrix.length != matrix[0].length) {
			System.exit(0);
		}
		
		
		for(int layer=0; layer < matrix.length / 2 ; layer++) {
			int first = layer;
			int last = matrix.length - layer - 1;
			for(int i=first ; i < last ; i++) {
				int offset = i - first;
				
				// top 
				int top = matrix[first][i];
				
				// left -> top
				matrix[first][i] = matrix[last-offset][first];
				
				// bottom -> left
				matrix[last-offset][first] = matrix[last][last-offset];
				
				// right -> bottom
				matrix[last][last-offset] = matrix[i][last];
				
				// top -> right
				matrix[i][last] = top;
				
			}
		}
		
		
		return matrix;
	}
	
	
	
	
	
	
	

}
