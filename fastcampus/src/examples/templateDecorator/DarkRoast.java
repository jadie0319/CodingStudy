package examples.templateDecorator;

public class DarkRoast extends Beverage {
	
	public DarkRoast() {
		this.setDescription("다크로스트");
	}
	
	@Override
	public int cost() {
		return 4000;
	}

}
