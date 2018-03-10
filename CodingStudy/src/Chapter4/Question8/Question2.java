package Chapter4.Question8;

import Chapter4.RefGraph.TreeNode;

/*
 * 4-8 첫 번째 공통 조상 : 이진 트리에서 노드 두개가 주어졌을 때 이 두 노드의
 * 첫번째 공통 조상을 찾는 알고리즘을 설계하고 그 코드를 작성하라. 자료구조내에
 * 추가로 노드를 저장해 두면 안 된다. 반드시 이진 탐색트리일 필요는 없다.
 */

public class Question2 {
	
	public static class Result {
		public TreeNode node;
		public boolean isAncestor;
		public Result(TreeNode n, boolean isAnc) {
			node = n;
			isAncestor = isAnc;
		}
	}
	
	
	public static Result commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q) {
		if(root == null) {
			return new Result(null,false);
		}
		
		if(root == p && root == q) {
			return new Result(root, true);
		}
		Result rx = commonAncestorHelper(root.left, p, q);
		if (rx.isAncestor) { // Found common ancestor
			return rx;
		}
		
		Result ry = commonAncestorHelper(root.right, p, q);
		if (ry.isAncestor) { // Found common ancestor
			return ry;
		}
		
		if (rx.node != null && ry.node != null) {
			return new Result(root, true);  // result. root==13 일때 return 한다. 그러면 root 9의 ry로 저장되어있음.
		} else if (root == p || root == q) {
			
			boolean isAncestor = rx.node != null || ry.node != null;
			return new Result(root, isAncestor);
		} else {
			return new Result(rx.node != null ? rx.node : ry.node, false);
		}
		
	}
	
	
	
	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		Result r = commonAncestorHelper(root,p,q);
		if(r.isAncestor) {
			return r.node;
		}
		return null;
	}
	
	
	
	
	public static void main(String[] args) {
		int numbers[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
		TreeNode root = TreeNode.createMinimalBST(numbers);
		TreeNode p = root.find(10);
		TreeNode q = root.find(16);
		
		System.out.println(p.data);
		System.out.println(q.data);
		
		root.print();
		TreeNode ancestor = commonAncestor(root, p, q);
		if (ancestor != null) {
			System.out.println(ancestor.data);
		} else {
			System.out.println("null");
		}
	}
	

}
