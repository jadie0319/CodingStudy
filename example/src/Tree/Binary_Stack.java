package Tree;

import java.util.EmptyStackException;

/**
 * Created by choijaeyong on 2016. 3. 3..
 */
public class Binary_Stack {
    private BinaryTreeNode headTreeNode;
    public Binary_Stack(int data) {
        this.headTreeNode = new BinaryTreeNode(data);
    }

    public void tree_push(BinaryTreeNode btn) {
        if(headTreeNode==null || headTreeNode.getData()==0) {
            headTreeNode = btn;
        } else {
            BinaryTreeNode temp_node = btn;
            temp_node.setNext(headTreeNode);
            headTreeNode=temp_node;
        }
    }

    public boolean tree_isEmpty() {
        if(headTreeNode==null) {
            return true;
        } else {
            return false;
        }
    }
    public BinaryTreeNode tree_pop() {
        if(headTreeNode==null) {
            throw new EmptyStackException();
        } else {
            BinaryTreeNode popNode = headTreeNode;
            headTreeNode=headTreeNode.getNext();
            return popNode;
        }
    }

    public BinaryTreeNode tree_top() {
        if(headTreeNode == null) {
            return null;
        }else {
            return headTreeNode;
        }
    }

    public void deleteStack() {
        headTreeNode = null;
    }

}
