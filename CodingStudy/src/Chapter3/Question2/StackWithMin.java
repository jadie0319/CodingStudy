package Chapter3.Question2;

import java.util.Stack;

public class StackWithMin extends Stack<NodeWithMin>{
	public void push(int value) {
		int newMin = Math.min(value, min());
		super.push(new NodeWithMin(value,newMin));
	}
	
	public int min() {
		if(this.empty()) {
			return Integer.MAX_VALUE; // 에러값.
		} else {
			return peek().min;
		}
	}

}
