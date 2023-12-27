package gate;
import ParkingLot.Vehicle;
import controller.ParkingLotController;
public class ExitGate extends Gate {

	 public ExitGate(int gateId , ParkingLotController parkingLotController) {
		 super(gateId,parkingLotController);
	 }
	 public void processVehicle(Vehicle vehicle) {
		 System.out.println("Processing vehicle at exit gate");
         
		 System.out.println("Vehicle exit processed successfully");
	 }
}
