package Chapter7.Question4;

import java.util.ArrayList;


public abstract class Vehicle {
	protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();
	protected String licensePlate;
	protected int spotsNeeded;
	protected VehicleSize size;
	
	public int getSpotsNeeded() { return spotsNeeded; }
	public VehicleSize getVehicleSize() { return size; }
	
	// 주어진 주차 공간에 차량 주차.
	public void parkInSpot(ParkingSpot s) {
		parkingSpots.add(s);
	}
	
	// 차를 뺀 다음 해당 공간이 비었다고 알려준다.
	public void clearSpots() {
		for(int i=0; i < parkingSpots.size() ; i++) {
			parkingSpots.get(i).removeVehicle();;
		}
		parkingSpots.clear();
	}
	
	public abstract boolean canFitInSpot(ParkingSpot spot);
	public abstract void print();
	
	

}