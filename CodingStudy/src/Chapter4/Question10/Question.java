package Chapter4.Question10;

import Chapter4.RefGraph.GraphAssortedMethods;
import Chapter4.RefGraph.TreeNode;

/*
 * 4-10 하위트리확인 : 두 개의 커다란 이진 트리 T1과 T2가 있다고 하자. T1이
 * T2보다 훨씬 크다고 했을 때, T2가 T1의 하위트리인지 판별하는 알고리즘을 만들라.
 * T1안에 있는 노드 n의 하위 트리가 T2와 동일하면, T2는 T1의 하위트리다. 다시말해
 * T1에서 노드 n의 아래쪽을 끊어냈을때 그 결과가 T2와 동일해야 한다.
 */

public class Question {
	
	public static boolean matchTree(TreeNode node, TreeNode node2) {
		if(node == null && node2 == null) {
			return true; // nothing left in the subtree
		} else if(node == null || node2 == null) {
			return false;
		} else if(node.data != node2.data) {
			return false;
		} else {
			return matchTree(node.left, node2.left) && matchTree(node.right, node2.right);
		}
		
		
	}

	public static boolean subTree(TreeNode node, TreeNode node2) {
		if(node == null) {
			return false;
		} else if(node.data == node2.data && matchTree(node,node2)) {
			return true;
		}
		
		return subTree(node.left,node2) || subTree(node.right,node2);
	}
	
	
	public static boolean checkSubtree(TreeNode node,TreeNode node2) {

		if(node2 == null) {
			return true;
		}
		
		return subTree(node,node2);
	}
	
	public static void main(String[] args) {
		int array[] = {1,2,3,4,5,6,7,8,9,10};
		TreeNode root = GraphAssortedMethods.createTreeNodeFromArray(array);
		
		int array2[] = {5,10};
		TreeNode root2 = GraphAssortedMethods.createTreeNodeFromArray(array2);
		
		root.print();
		root2.print();
		
		if(checkSubtree(root,root2)) {
			System.out.println("t2 is a subtree of t1");
		} else {
			System.out.println("t2 is not a subtree of t1");
		}
		
		

	}

}
