package examples.templateDecorator;

public class Soy extends CondimentDecorator {
	private Beverage beverage;
	
	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public int cost() {
		return 500 + beverage.cost();
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + ", 소이";
	}

}
