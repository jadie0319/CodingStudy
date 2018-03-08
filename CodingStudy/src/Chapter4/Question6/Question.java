package Chapter4.Question6;

import Chapter4.RefGraph.TreeNode;

/*
 * 4-6 후속자 : 이진 탐색 트리에서 주어진 노드의 '다음' 
 * 노드(중위 후속자(in-order-successor))를 찾는 알고리즘을 작성하라.
 * 각 노드에는 부모 노드를 가리키는 링크가 존재한다고 가정하자.
 */

public class Question {
	
	// in-order 순회에 대해 확실히 이해하자. 
	// left 순회가 완전히 끝나야 right순회가 시작된다.
	public static TreeNode inorderSucc(TreeNode n) {
		if(n == null) return null;
		
		// n right가 존재한다면.
		if(n.parent == null || n.right != null) {
			return leftMostChild(n.right);
		} else {
			TreeNode q = n;
			TreeNode x = q.parent;
			
			// q가 x의 right 라면.
			while(x != null && x.left != q) {
				q = x;
				x = x.parent;
			}
			return x;
		}
		
	}
	
	public static TreeNode leftMostChild(TreeNode n) {
		if( n == null) {
			return null;
		}
		while(n.left != null) {
			n = n.left;
		}
		return n;
	}
	
	
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		
		root.print();
		
		for (int i = 0; i < array.length; i++) {
			TreeNode node = root.find(array[i]);
			TreeNode next = inorderSucc(node);
			if (next != null) {
				System.out.println(node.data + "->" + next.data);
			} else {
				System.out.println(node.data + "->" + null);
			}
		}
		

	}

}
