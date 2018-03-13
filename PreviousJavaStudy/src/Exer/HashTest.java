package Exer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HashTest {

	public static void main(String[] args) {
		HashMap<String, Integer> shoes = new HashMap<String, Integer>();
		
		shoes.put("쓰레빠", 4);
		shoes.put("슬리퍼", 3);
		shoes.put("실내화", 10);
		
		HashMap<String, HashMap<String,Integer>> sh = new HashMap<String, HashMap<String,Integer>>();
		sh.put("신발", shoes);
		
		Set<String> keySet = sh.keySet();
		for(String key : keySet) {
			System.out.println(key);
			System.out.println(sh.get(key));
		}

		
		// List로 구현하는 것이 자유도를 확보할 수 있다.
		ArrayList<String> al = new ArrayList<String>();
		List<Integer> li = new ArrayList<Integer>();
		
		
		
		al.add("바보");al.add("쓰레기");al.add("사회악");
		Iterator iter = al.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
