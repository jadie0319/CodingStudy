package Chapter4.RefGraph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphAssortedMethods {
	
	public static TreeNode createTreeNodeFromArray(int array[]) {
		if(array.length > 0) {
			TreeNode root = new TreeNode(array[0]);
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			boolean done = false;
			int i = 1;
			while(!done) {
				TreeNode r = (TreeNode)queue.element();
				if(r.left == null) {
					r.left = new TreeNode(array[i]);
					i++;
					queue.add(r.left);
				} else if(r.right == null) {
					r.right = new TreeNode(array[i]);
					i++;
					queue.add(r.right);
				} else {
					queue.remove();
				}
				if(i == array.length) {
					done = true;
				}
			}
			return root;
		} else {
			return null;
		}
		 
	}
	

}
