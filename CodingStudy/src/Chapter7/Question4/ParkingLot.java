package Chapter7.Question4;

public class ParkingLot {
	private Level[] levels;
	private final int NUM_LEVELS = 5;
	
	public ParkingLot() {
		levels = new Level[NUM_LEVELS];
		for(int i=0; i < NUM_LEVELS ; i++) {
			levels[i] = new Level(i,30);
		}
	}
	
	
	// 주차 공간(혹은 여러개에 걸쳐)에 주차한다. 실패하면 false 반환한다.
	public boolean parkVehicle(Vehicle vehicle) {
		for (int i = 0; i < levels.length; i++) {
			if (levels[i].parkVehicle(vehicle)) {
				return true;
			}
		}
		return false;
	}
	
	public void print() {
		for (int i = 0; i < levels.length; i++) {
			System.out.print("Level" + i + ": ");
			levels[i].print();
			System.out.println("");
		}
		System.out.println("");
	}

}
