package Chapter4.Question5;

import Chapter4.RefGraph.GraphAssortedMethods;
import Chapter4.RefGraph.TreeNode;

/*
 *  4-5 BST 검증 : 주어진 이진 트리가 이진 탐색 트리인지 확인하는 함수를 작성하라.
 */

public class Question {
	

	public static boolean checkBST(TreeNode n, Integer min, Integer max) {
		if (n == null) {
			return true;
		}
		if ((min != null && n.data <= min) || (max != null && n.data > max)) {
			return false;
		}
		
		// 왼쪽분기시 -> max를 갱신.
		// 오른쪽분기시 -> min을 갱신.
		
		if (!checkBST(n.left, min, n.data) ||
			!checkBST(n.right, n.data, max)) {
			return false;
		}
		return true;
	}
		
	public static boolean checkBST(TreeNode n) {
		return checkBST(n, null, null);
	}
	
	
	

	public static void main(String[] args) {
		int numbers[] = {20,10,30,5,15,25,31};
		TreeNode root = GraphAssortedMethods.createTreeNodeFromArray(numbers);
		root.print();
		boolean isBst = checkBST(root);
		System.out.println(isBst);
		
	}

}
