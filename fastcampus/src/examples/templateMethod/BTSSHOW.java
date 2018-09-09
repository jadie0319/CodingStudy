package examples.templateMethod;

public class BTSSHOW implements Gate{

	@Override
	public void check(Ticket ticket) {
		if(!ticket.getTicketName().equals("BTS LA SHOW")) {
			System.out.println("get out");
		} else {
			System.out.println("welcome");
		}
		
	}
	

}
