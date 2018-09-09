package examples.templateMethod;

// 선배. 
public class Executor {
	public void exec(BaseAction action) {
		action.logic();
	}
}
