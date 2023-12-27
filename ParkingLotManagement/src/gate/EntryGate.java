package gate;
import ParkingLot.Vehicle;

import controller.ParkingLotController;
import ParkingLot.Ticket;
public class EntryGate extends Gate {
	
	public EntryGate(int gateId,ParkingLotController parkingLotController) {
	   super(gateId,parkingLotController);   
	}
	
	
    
	public void processVehicle(Vehicle vehicle) {
		super.processVehicle(vehicle);
		System.out.println("Processing Vehicle at Entry Gate");
		
		System.out.println("Vehicle entry processed successfully");
	}
}
