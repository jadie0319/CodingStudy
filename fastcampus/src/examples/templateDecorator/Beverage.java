package examples.templateDecorator;

public abstract class Beverage {
	private String description ="empty";
	
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public abstract int cost();

}
