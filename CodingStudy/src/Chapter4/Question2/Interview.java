package Chapter4.Question2;

import Chapter4.RefGraph.TreeNode;

/*
 *  4-2 최소 트리 : 오름차순으로 정렬된 배열이 있다. 이 배열 안에 들어 있는 원소는
 *  정수이며 중복된 값이 없다고 했을 때 높이가 최소가 되는 이진 탐색 트리를 만드는
 *  알고리즘을 작성하라.
 */



public class Interview {

	public static void main(String[] args) {
		int array[] = {1,2,3,4,5,6,7,8,9,10};
		
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("Root : " + root.data);
		System.out.println("Create BST? " + root.isBST());
		System.out.println("Height : " + root.height());
	}

}
