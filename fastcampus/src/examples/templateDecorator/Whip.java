package examples.templateDecorator;

public class Whip extends CondimentDecorator {
	private Beverage beverage;
	
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public int cost() {
		return 5000 + beverage.cost();
	}
	
	@Override
	public String getDescription( ) {
		return beverage.getDescription() + ", 휘핑크림";
	}

}
