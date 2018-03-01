package Chapter4.Question4;

import Chapter4.RefGraph.GraphAssortedMethods;
import Chapter4.RefGraph.TreeNode;

/*
 *  4-4 균형 확인 : 이진 트리가 균형 잡혀있는지 확인하는 함수를 작성하라. 이 문제에서
 *  균형 잡힌 트리란 모든 노드에 대해서 왼쪽 부분 트리의 높이와 오른쪽 부분 트리의 
 *  높이의 차이가 최대 하나인 트리를 의미한다.
 */

public class Question {

	public static void main(String[] args) {
		int numbers[] = {1,2,3,4,5,6,7,8,9,10};
		TreeNode root = GraphAssortedMethods.createTreeNodeFromArray(numbers);
//		TreeNode temp = new TreeNode(11);
//		root.left.left.left.left = temp;
//		System.out.println(root.left.left.left.data);
		System.out.println(isBalanced(root));
		
	}
	
	static int checkHeight(TreeNode root) {
		if(root == null) return -1;
		
		int leftHeight = checkHeight(root.left);
		if(leftHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int rightHeight = checkHeight(root.right);
		if(rightHeight == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int heightDiff = leftHeight - rightHeight;
		
		if(Math.abs(heightDiff) > 1) {
			return Integer.MIN_VALUE;
		} else {
			return Math.max(leftHeight, rightHeight) + 1;
		}
		
	}
	
	static boolean isBalanced(TreeNode root) {
		return checkHeight(root) != Integer.MIN_VALUE;
	}
	

}
