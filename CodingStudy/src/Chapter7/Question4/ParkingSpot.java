package Chapter7.Question4;

public class ParkingSpot {
	private Vehicle vehicle;
	private VehicleSize spotSize;
	private int row;
	private int spotNumber;
	private Level level;
	
	public ParkingSpot(Level lv, int r, int n, VehicleSize vs) {
		level = lv;
		row = r;
		spotNumber = n;
		spotSize = vs;
	}
	
	public boolean isAvailable() {
		return vehicle == null;
	}
	
	// 주차공간이 충분히 크고 사용 가능한지 확인한다.
	public boolean canFitVehicle(Vehicle vehicle) {
		return isAvailable() && vehicle.canFitInSpot(this);
	}
	
	// 해당 공간에 차를 주차한다.
	public boolean park(Vehicle v) {
		if(!canFitVehicle(v)) {
			return false;
		}
		vehicle = v;
		vehicle.parkInSpot(this);
		return true;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getSpotNumber() {
		return spotNumber;
	}
	
	
	public void removeVehicle() {
		level.spotFreed();
		vehicle = null;
	}
	public VehicleSize getSize() {
		return spotSize;
	}

	public void print() {
		if(vehicle == null) {
			if(spotSize == VehicleSize.Compact) {
				System.out.println("Car");
			} else if(spotSize == VehicleSize.Large) {
				System.out.println("Bus");
			} else if(spotSize == VehicleSize.Motorcycle){
				System.out.println("Motor");
			}
		} else {
			vehicle.print();
		}
	}
	
	
	
	
	
	
}
