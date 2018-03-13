package Hasing;

/**
 * Created by choijaeyong on 2016. 3. 28..
 */
public class Hasing_exec {
    public static void main(String[] args) {
        System.out.println("해쉬테이블 예제");
        HashTable h = new HashTable();
        HashTableOperations Ho = new HashTableOperations();

        h.setTSize(20);
        System.out.println(h.getTSize());
        System.out.println(h.getTable().length);
//        h =HashTableOperations.createHashTable(20);

        HashTableOperations.hashInsert(h,20);




    }
}
