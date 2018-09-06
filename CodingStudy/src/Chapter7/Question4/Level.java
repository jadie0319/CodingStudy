package Chapter7.Question4;

public class Level {
	private int floor;
	private ParkingSpot[] spots;
	private int availableSpots = 0; // 빈자리 개수
	private static final int SPOTS_PER_ROW = 10;
	
	public Level(int f, int numberSpots) {
		floor = f;
		spots = new ParkingSpot[numberSpots];
		int largeSpots = numberSpots / 4;
		int bikeSpots = numberSpots / 4;
		int compactSpots = numberSpots - largeSpots - bikeSpots;
		for(int i=0; i < numberSpots ; i++) {
			VehicleSize vs = VehicleSize.Motorcycle;
			if(i < largeSpots) {
				vs = VehicleSize.Large;
			} else if( i < largeSpots + compactSpots) {
				vs = VehicleSize.Compact;
			}
			int row = i / SPOTS_PER_ROW;
			spots[i] = new ParkingSpot(this, row, i, vs);
		}
		availableSpots = numberSpots;
	}
	
	public int availableSpots() {
		return availableSpots;
	}
	
	// 주어진 차량을 주차할 장소를 찾는다. 실패하면 false
	public boolean parkVehicle(Vehicle vehicle) {
		if(availableSpots() < vehicle.getSpotsNeeded()) {
			return false;
		}
		int spotNumber = findAvailableSpots(vehicle);
		if(spotNumber <  0 ) {
			return false;
		}
		return parkStartingAtSpot(spotNumber, vehicle);
	}
	
	// 차량을 spotNumber 가 가리키는 장소부터 vehicle.spotsNeeded 만큼의 공간에
	// 주차한다.
	private boolean parkStartingAtSpot(int spotNumber, Vehicle vehicle) {
		vehicle.clearSpots();
		boolean success = true;
		for(int i=spotNumber; i < spotNumber + vehicle.spotsNeeded ; i++) {
			success &= spots[i].park(vehicle);
		}
		availableSpots -= vehicle.spotsNeeded;
		return success;
	}
	
	
	
	// 주차할 장소를 찾는다. 빈자리 인덱스를 반환하거나 실패했을 경우 -1을 반환.
	public int findAvailableSpots(Vehicle vehicle) {
		int spotsNeeded = vehicle.getSpotsNeeded();
		int lastRow = -1;
		int spotsFound = 0;
		for(int i=0; i< spots.length ; i++) {
			ParkingSpot spot = spots[i];
			if(lastRow != spot.getRow()) {
				spotsFound = 0;
				lastRow = spot.getRow();
			}
			
			if(spot.canFitVehicle(vehicle)) {
				spotsFound++;
			} else {
				spotsFound =0;
			}
			
			if(spotsFound == spotsNeeded) {
				return i - (spotsNeeded -1);
			}
		}
		return -1;
	}
	
	public void print() {
		int lastRow = -1;
		for (int i = 0; i < spots.length; i++) {
			ParkingSpot spot = spots[i];
			if (spot.getRow() != lastRow) {
				System.out.print("  ");
				lastRow = spot.getRow();
			}
			spot.print();
		}
	}
	
	
	
	
	
	
	// 차를 빼면 availableSpots 를 증가시킨다.
	public void spotFreed() {
		availableSpots++;
	}
}
