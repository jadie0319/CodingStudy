package Chapter7.Question2;

abstract class Employee {
	private Call currentCall = null;
	protected Rank rank;
	private CallHandler callHandler;
	
	public Employee(CallHandler handler) {
		callHandler = handler;
	}
	
	public void receiveCall(Call call) {
		currentCall = call;
	}
	
	public void callCompleted() {
		if(currentCall != null) {
			currentCall.disconnect();
			currentCall = null;
		}
		assignNewCall();
	}
	
	public void escalateAndReassign() {
		if(currentCall != null) {
			currentCall.incrementRank();
			callHandler.dispatchCall(currentCall);
			
			currentCall = null;
		}
		assignNewCall();
	}
	
	
	public boolean assignNewCall() {
		if(!isFree()) {
			return false;
		}
		return callHandler.assignCall(this);
	}
	
	
	public boolean isFree() {
		return currentCall == null;
	}
	
	
	public Rank getRank() {
		return rank;
	}

}
