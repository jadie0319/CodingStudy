package CodeLibrary;

public class LinkedListNode<T> {
	public LinkedListNode<T> next, prev, last;
	public T data;
	public LinkedListNode(T d, LinkedListNode<T> n, LinkedListNode<T> p) {
		data = d;
		setNext(n);
		setPrevious(p);
	}
	public LinkedListNode(T d) {
		data = d;
	}
	
	public LinkedListNode() {}
	
	public void setNext(LinkedListNode<T> n) {
		next = n;
		if(this == next) {
			last = n;
		}
		if ( n != null && n.prev != this) {
			n.setPrevious(this);
		}
	}
	
	public void setPrevious(LinkedListNode<T> p) {
		prev = p;
		if(p != null && p.next != this) {
			p.setNext(this);
		}
	}
	
	public String printForward() {
		if(next != null) {
			return data + " => " + next.printForward();
		} else {
			return data.toString();
		}
	}
	
	
	public LinkedListNode<T> clone() {
		LinkedListNode<T> next2 = null;
		if(next != null) {
			next2 = next.clone();
		}
		LinkedListNode<T> head2 = new LinkedListNode<T>(data, next2, null);
		return head2;
	}

}
