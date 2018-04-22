package Chapter7.Question2;

import java.util.ArrayList;
import java.util.List;

public class CallHandler {
	// 직급 레벨 3
	private final int LEVELS = 3;
	
	private final int NUM_RESPONDENTS = 10;
	private final int NUM_MANAGERS = 4;
	private final int NUM_DIRECTORS = 2;

	/*
	 * employeeLevels[0] = respondents
	 * employeeLevels[1] = managers
	 * employeeLevels[2] = directors
	 */
	
	List<List<Employee>> employeeLevels;
	
	List<List<Call>> callQueues;
	
	public CallHandler() {
		employeeLevels = new ArrayList<List<Employee>>(LEVELS);
		callQueues = new ArrayList<List<Call>>(LEVELS);
		
		ArrayList<Employee> respondents = new ArrayList<Employee>(NUM_RESPONDENTS);
		for(int i=0; i < NUM_RESPONDENTS ; i++) {
			respondents.add(new Respondent(this));
		}
		employeeLevels.add(respondents);
		
		ArrayList<Employee> managers = new ArrayList<Employee>(NUM_MANAGERS);
		managers.add(new Manager(this));
		employeeLevels.add(managers);
		
		ArrayList<Employee> directors = new ArrayList<Employee>(NUM_DIRECTORS);
		directors.add(new Director(this));
		employeeLevels.add(directors);
		
	}
	
	// 최초 전
	public Employee getHandlerForCall(Call call) {
		for(int level = call.getRank().getValue() ; level < LEVELS ; level++) {
			List<Employee> employeeLevel = employeeLevels.get(level);
			for(Employee emp : employeeLevel) {
				if(emp.isFree()) {
					return emp;
				}
			}
		}
		return null;
	}
	
	
	public void dispatchCall(Caller caller) {
		Call call = new Call(caller);
		dispatchCall(call);
		
	}
	
	public void dispatchCall(Call call) {
		Employee emp = getHandlerForCall(call);
		if(emp != null) {
			emp.receiveCall(call);
			call.setHandler(emp);
		} else {
			call.reply("please wait for free employee to reply");
			callQueues.get(call.getRank().getValue()).add(call);
		}
		
	}
	
	public boolean assignCall(Employee emp) {
		for(int rank = emp.getRank().getValue() ; rank >= 0 ; rank--) {
			List<Call> que = callQueues.get(rank);
			if(que.size() > 0) {
				Call call = que.remove(rank);
				if(call != null) {
					emp.receiveCall(call);
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	
	
}
