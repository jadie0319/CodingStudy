package Chapter4.Question3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import Chapter4.RefGraph.GraphAssortedMethods;
import Chapter4.RefGraph.TreeNode;

public class QuestionDFS {
	
	public static void createLevelLinkedList(TreeNode root,
			ArrayList<LinkedList<TreeNode>> lists, int level) {
		
		if(root == null) return;
		LinkedList<TreeNode> list = null;
		if(lists.size() == level) {
			list = new LinkedList<TreeNode>();
			
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(root);
		createLevelLinkedList(root.left, lists, level+1);
		createLevelLinkedList(root.right, lists, level+1);
		
	}
	
	public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		createLevelLinkedList(root,lists,0);
		return lists;
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
