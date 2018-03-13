package Exer;

public class DiningPhilosophers {
	
	private Object[] forks;
	private Philosopher[] philosophers;
	
	private DiningPhilosophers(int num) {
		forks = new Object[num];
		philosophers = new Philosopher[num];
		for(int i=0 ; i < num ; i++) {
			forks[i] = new Object();
			
			// 아래와 같은 이렇게 하면 모든 철학자가 왼손에 포크를 들 경우. 
			// 아무도 식사를 할수가 없다
			// philosophers[i] = new Philosopher(i,i,(i+1)%num);
			
			// 해결책
			int fork1 = i;
			int fork2 = (i+1)%num;
			if(i==0) {
				philosophers[i] = new Philosopher(i, fork2, fork1);
			} else {
				philosophers[i] = new Philosopher(i, fork1, fork2);
			}
		}
	}
	
	//먹기시작
	public void startEating() throws InterruptedException {
		for(int i=0 ; i < philosophers.length ; i++) {
			philosophers[i].start();
		}
		
		philosophers[0].join();
	}
	
	
	// 각 철하자는 서로 다른 스레드에서 돌아감
	private class Philosopher extends Thread {
		private int id;
		private int fork1;
		private int fork2;
		Philosopher(int id, int fork1, int fork2) {
			this.id=id;
			this.fork1=fork1;
			this.fork2=fork2;
		}
		
		public void run() {
			status("Ready to eat using forks " + fork1 + " and " + fork2);
			while(true) {
				status("Picking up fork " + fork1);
				synchronized(forks[fork1]) {
					status("Picking up fork " + fork2);
					synchronized(forks[fork2]) {
						status("Eating");
					}
				}
			}
			
		}
		
		private void status(String msg) {
			System.out.println("철학자 " + id + " : " + msg);
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		try {
			DiningPhilosophers d = new DiningPhilosophers(5);
			d.startEating();
		}catch (InterruptedException e) {
			
		}

	}

}
