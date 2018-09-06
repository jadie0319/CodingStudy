package Chapter7.Question4;

public class Motorcycle extends Vehicle{
	public Motorcycle() {
		spotsNeeded = 1;
		size = VehicleSize.Motorcycle;
	}
	public boolean canFitInSpot(ParkingSpot spot) {
		return spot.getSize() == VehicleSize.Motorcycle;
	}
	
	public void print() {
		System.out.print("M");
	}
}
