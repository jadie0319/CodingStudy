package examples.bookComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * comparator 예제.  book 인스턴스를 가격 기준으로 정렬하기.
 */

class Book {
	private int price;
	private String name;
	public Book (String name, int price){
		this.name = name;
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}

public class BookComparator {
	public static void main(String[] args) {
		Book book1 = new Book("jsp",3000);
		Book book2 = new Book("web", 4000);
		Book book3 = new Book("php", 2000);
		
		List<Book> bookList = new ArrayList<Book>();
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		
		List<Integer> te = new ArrayList<Integer>();
		te.add(1);
		te.add(2);
		Collections.sort(te); 
		// Integer 정렬시엔 오류없이 작동한다. 하지만 Book 클래스의 경우엔 sort에 넣으면
		// 뒤에 comparator를 구현한 클래스가 필요하다고 오류가 나온다.
		
		
		Collections.sort(bookList, new BookComparatorImpl());
		
		
		
		for(Book book : bookList) {
			System.out.println(book.getName() + "       " + book.getPrice());
		}
		
	}

}


class BookComparatorImpl implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		return ((Book)o1).getPrice() - ((Book)o2).getPrice();
	}
	
}


