package examples.templateDecorator;

public class Mocha extends CondimentDecorator {
	private Beverage beverage;
	
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public int cost() {
		return 500 + beverage.cost();
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + ", 모카";
	}
	
}
