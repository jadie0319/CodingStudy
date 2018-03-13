package Hasing;

/**
 * Created by choijaeyong on 2016. 3. 28..
 */
public class HashTableNode {
    private int blockCount;
    private ListNode startNode;
    public HashTableNode() {
        
    }

    public int getBlockCount() {
        return blockCount;
    }
    public void setBlockCount (int blockCount) {
        this.blockCount=blockCount;
    }
    public ListNode getStartNode() {
        return startNode;
    }
    public void setStartNode(ListNode startNode) {
        this.startNode = startNode;
    }
}
