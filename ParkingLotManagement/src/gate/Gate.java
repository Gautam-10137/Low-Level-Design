package gate;
import ParkingLot.Vehicle;
import controller.ParkingLotController;
public class Gate {
   private int gateId;
   private ParkingLotController parkingLotController;
   public Gate(int gateId,ParkingLotController parkingLotController) {
	   this.gateId=gateId;
	   this.parkingLotController=parkingLotController;
   }
   public void setParkingLotController(ParkingLotController parkingLotController) {
	   this.parkingLotController=parkingLotController;
   }
   public void processVehicle(Vehicle vehicle) {
	   System.out.println("Processing vehicle at gate");
   }
}
