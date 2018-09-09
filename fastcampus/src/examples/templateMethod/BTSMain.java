package examples.templateMethod;

public class BTSMain {
	public static void main(String[] args) {
		Gate show = new BTSSHOW();
		
		Ticket p1 = new Army();
		
		show.check(p1);
		
	}
	

}
