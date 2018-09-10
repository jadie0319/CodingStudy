package examples.templateDecorator;

public class Espresso extends Beverage{	
	public Espresso() {
		this.setDescription("에스프레소");
	}
	@Override
	public int cost() {
		return 3500;
	}

}
