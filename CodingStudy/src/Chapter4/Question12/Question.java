package Chapter4.Question12;

import Chapter4.RefGraph.TreeNode;

/*
 * 4-12 합의 경로 : 각 노드의 값이 정수(음수 및 양수)인 이진 트리가 있다. 이때 정수의
 * 합이 특정 값이 되도록 하는 경로의 개수를 세려고 한다. 경로가 꼭 루트에서 시작해서 말단
 * 노드에서 끝날 필요는 없지만 반드시 아래로 내려가야 한다. 즉, 부모 노드에서 자식 노드로만
 * 움직일 수 있다. 이 알고리즘을 어떻게 설계할 것인가?
 * 
 */


public class Question {
	public static int countPathsWithSum(TreeNode root, int targetSum) {
		if(root == null) return 0;
		
		int pathsFromRoot = countPathsWithSumFromNode(root,targetSum,0);
		
		int pathsOnLeft = countPathsWithSum(root.left,targetSum);
		int pathsOnRight = countPathsWithSum(root.right,targetSum);
		
		return pathsFromRoot + pathsOnLeft + pathsOnRight;
	}
	
	public static int countPathsWithSumFromNode(TreeNode node, int targetSum, int currentSum) {
		if(node == null) {
			return 0;
		}
		currentSum += node.data;
		
		int totalPaths = 0;
		if(currentSum == targetSum) {
			totalPaths++;
		}
		
		totalPaths += countPathsWithSumFromNode(node.left,targetSum,currentSum);
		totalPaths += countPathsWithSumFromNode(node.right,targetSum,currentSum);
		
		
		return totalPaths;
	}
	
	

	public static void main(String[] args) {
		/*
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);		
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(-8);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(6);	
		System.out.println(countPathsWithSum(root, 0));*/
		
		TreeNode root = new TreeNode(-7);
		root.left = new TreeNode(-7);
		root.left.right = new TreeNode(1);
		root.left.right.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(20);
		root.right.right.left = new TreeNode(0);
		root.right.right.left.left = new TreeNode(-3);
		root.right.right.left.left.right = new TreeNode(2);
		root.right.right.left.left.right.left = new TreeNode(1);
		System.out.println(countPathsWithSum(root, -14));
		
//		TreeNode root = new TreeNode(0);
//		root.left = new TreeNode(0);
//		root.right = new TreeNode(0);
//		root.right.left = new TreeNode(0);
//		root.right.left.right = new TreeNode(0);
//		root.right.right = new TreeNode(0);
		
		System.out.println(countPathsWithSum(root, 0));
		System.out.println(countPathsWithSum(root, 4));

	}

}
