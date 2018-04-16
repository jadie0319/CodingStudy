package Chapter4.Question11;

import java.util.Random;



public class TreeNode {
	public int data;
	public TreeNode left;
	public TreeNode right;
	private int size = 0;
	public TreeNode(int data) {
		this.data = data;
		size = 1;
	}
	
	public void insertInOrder(int d) {
		if(d <= data) {
			if(left == null) {
				left = new TreeNode(d);
			} else {
				left.insertInOrder(d);
			}
		} else {
			if(right == null) {
				right = new TreeNode(d);
			} else {
				right.insertInOrder(d);
			}
		}
		size++;
	}
	
	public int size() {
		return this.size;
	}
	
	public TreeNode find(int d) {
		if(d == data) {
			return this;
		} else if(d > data) {
			return right != null ? right.find(d) : null;
		} else if(d <= data) {
			return left != null ? left.find(d) : null;
		}
		
		return null;
	}
	
//	public TreeNode getRandomNode() {
//		int leftSize = left == null ? 0 : left.size();
//		System.out.println(leftSize + "------");
//		Random random = new Random();
//		int index = random.nextInt(size);
//		if(index < leftSize) {
//			return left.getRandomNode();
//		} else if(index == leftSize) {
//			return this;
//		} else {
//			return right.getRandomNode();
//		}
//		
//	}
//	
	
	// remember Inorder
	
	public TreeNode getIthNode(int i) {
		int leftSize = left == null ? 0 : left.size();
		System.out.println(this.data + " -- " + leftSize);
		
		if(i < leftSize) {
			return left.getIthNode(i);
		} else if(i == leftSize) {
			return this;
		} else {
			return right.getIthNode(i - (leftSize + 1));
		}
		
	}
	
	
	

}
