package Chapter4.Question8;

import Chapter4.RefGraph.GraphAssortedMethods;
import Chapter4.RefGraph.TreeNode;

/*
 * 4-8 첫 번째 공통 조상 : 이진 트리에서 노드 두개가 주어졌을 때 이 두 노드의
 * 첫번째 공통 조상을 찾는 알고리즘을 설계하고 그 코드를 작성하라. 자료구조내에
 * 추가로 노드를 저장해 두면 안 된다. 반드시 이진 탐색트리일 필요는 없다.
 */

public class Question {
	
	public static TreeNode commonAncestor(TreeNode p , TreeNode q) {
		int gapDepth = depth(p) - depth(q);
		// gapDepth 가 양수이면 first 가 q   	
		// gapDepth 가 음수이면 first 가 p
		
		TreeNode first = gapDepth > 0 ? q : p;
		TreeNode second = gapDepth >0 ? p : q;
		
		//System.out.println(q.data+ " > " + q.parent.data + " -> " + q.parent.parent.data + " -> " + q.parent.parent.parent.data);
		//System.out.println("depth q -> " + depth(q));
		second = goUp(second, Math.abs(gapDepth));
		
		
		while(first != second && first != null && second != null) {
			first = first.parent;
			second = second.parent;
		}
		System.out.println(first.data);
		System.out.println(second);
		
		return first == null || second == null ? null : first;
	}
	
	public static int depth(TreeNode p) {
		int depth = 0;
		while(p != null) {
			p = p.parent;
			depth++;
		}
		return depth;
	}

	public static TreeNode goUp(TreeNode node, int depth) {
		while(depth > 0 && node != null) {
			node = node.parent;
			depth--;
		}
		
		return node;
	}
	
	
	
	
	public static void main(String[] args) {
		int numbers[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};
		TreeNode root = TreeNode.createMinimalBST(numbers);
		TreeNode p = root.find(9);
		TreeNode q = root.find(16);
		
		System.out.println(p.data);
		System.out.println(q.data);
		
		root.print();
		
		System.out.println(commonAncestor(p,q).data);
		

	}

}
