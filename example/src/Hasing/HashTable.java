package Hasing;

/**
 * Created by choijaeyong on 2016. 3. 28..
 */
public class HashTable {
    private int tSize;
    private int count;
    private HashTableNode[] table;
    public int getTSize() {
        return tSize;
    }
    public void setTSize(int size) {
        tSize=size;
        table = new HashTableNode[size];
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count=count;
    }
    public HashTableNode[] getTable() {
        return table;
    }
    public void setTable(HashTableNode[] table) {
        this.table=table;
    }
}
