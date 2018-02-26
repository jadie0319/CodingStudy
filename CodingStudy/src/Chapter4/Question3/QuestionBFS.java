package Chapter4.Question3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import Chapter4.RefGraph.GraphAssortedMethods;
import Chapter4.RefGraph.TreeNode;

/*
 * 4-3 깊이의 리스트 : 이진 트리가 주어졌을때 같은 깊이에 있는 노드를 연결리스트로
 * 연결해주는 알고리즘을 설계하라. 즉 트리의 깊이가 D라면 D개의 연결 리스트를 만들어야
 * 한다.
 */

public class QuestionBFS {
	
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		
		/* Visit the root */
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if(root != null) {
			current.add(root);
		}
		
		while(current.size() > 0) {
			result.add(current); // add previous level
			LinkedList<TreeNode> parents = current; //  go to next level
			current = new LinkedList<TreeNode>();
			for(TreeNode parent : parents) {
				/* visit the children */
				if(parent.left != null) {
					current.add(parent.left);
				}
				if(parent.right != null) {
					current.add(parent.right);
				}
			}
			
		}
		return result;
	}

	public static void printResult(ArrayList<LinkedList<TreeNode>> result) {
		int depth = 0;
		for(LinkedList<TreeNode> entry : result) {
			Iterator<TreeNode> itr = entry.iterator();
			System.out.print("Link list at depth : " + depth + ":");
			while(itr.hasNext()) {
				System.out.print(" " + ((TreeNode)itr.next()).data);
			}
			System.out.println();
			depth++;
		}
	}
	

	public static void main(String[] args) {
		int numbers[] = {1,2,3,4,5,6,7,8,9,10};
		TreeNode root = GraphAssortedMethods.createTreeNodeFromArray(numbers);
		ArrayList<LinkedList<TreeNode>> list = createLevelLinkedList(root);
		printResult(list);

	}

}
