package Chapter8.Question2;

import java.util.ArrayList;
import java.util.HashSet;

public class QuestionB {
	
	public static int randomInt(int n) {
		return (int) (Math.random() * n);
	}

	public static int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}

	public static boolean randomBoolean(int percentTrue) {
		return randomIntInRange(1, 100) <= percentTrue;
	}
	
	public static boolean[][] randomBooleanMatrix(int M, int N, int percentTrue) {
		boolean[][] matrix = new boolean[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = randomBoolean(percentTrue);
			}
		}
		return matrix;
	}	
	
	public static void printMatrix(boolean[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j]) {
					System.out.print("1");
				} else {
					System.out.print("0");
				}
			}
			System.out.println();
		}
	}

	
	public static ArrayList<Point> getPath(boolean[][] maze) {
		if(maze == null || maze.length == 0) {
			return null;
		}
		ArrayList<Point> path = new ArrayList<Point>();
		HashSet<Point> failedPoints = new HashSet<Point>();
		
		if(getPath(maze, maze.length-1 , maze[0].length -1, path, failedPoints)) {
			return path;
		}
		return null;
		
	}
	
	public static boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
		if(col < 0 || row < 0 || !maze[row][col]) {
			return false;
		}
		
		Point p = new Point(row,col);
		if(failedPoints.contains(p)) {
			return false;
		}
		
		boolean isAtOrigin = (row == 0) && (col == 0);
		
		if(isAtOrigin || getPath(maze,row,col-1,path,failedPoints) || getPath(maze,row-1,col,path,failedPoints)) {
			path.add(p);
			return true;
		}
		failedPoints.add(p);
		return false;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		int size = 5;
		boolean[][] maze = randomBooleanMatrix(size,size,70);
		
		printMatrix(maze);
		
		ArrayList<Point> path = getPath(maze);
		if (path != null) {
			System.out.println(path.toString());
		} else {
			System.out.println("No path found.");
		}
		

	}

}
