package Exer;


//프로그래밍 면접 책 p281

class IntBuffer {
	private int index;
	private int[] buffer = new int[8];
	public synchronized void add(int num) {
		//버퍼가 꽉참. 대기 wait()
		while(index == buffer.length -1) {
			try {
				wait();
			} catch (InterruptedException e) {
				
			}
			
		}	
		buffer[index++] = num;
		notifyAll();
	}
	
	public synchronized int remove() {
		while(index == 0) {  // 버퍼가 비어있음 
			try {
				wait();
			}catch(InterruptedException e) {
				
			}
		}
		int ret =buffer[--index];
		notifyAll();
		return ret;
	}
	
}



