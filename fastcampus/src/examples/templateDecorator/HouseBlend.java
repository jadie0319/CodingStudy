package examples.templateDecorator;

public class HouseBlend extends Beverage {
	public HouseBlend() {
		this.setDescription("하우스블랜드");
	}
	@Override
	public int cost() {
		return 2500;
	}

}
