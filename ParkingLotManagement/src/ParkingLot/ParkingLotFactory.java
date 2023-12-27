package ParkingLot;
import java.util.List;
import java.util.ArrayList;
import controller.ParkingLotController;
import controller.ParkingLotController;
public class ParkingLotFactory {
   public ParkingLotController createParkingLot(int numTwoWheelerSlots, int numFourWheelerSlots) {
	   List<ParkingSlot>twoWheelerSlots=createSlots(numTwoWheelerSlots,VehicleType.TWO_WHEELER);
	   List<ParkingSlot>fourWheelerSlots=createSlots(numFourWheelerSlots,VehicleType.FOUR_WHEELER);
	   
	   ParkingLot parkingLot=new ParkingLot(twoWheelerSlots,fourWheelerSlots);
	   return new ParkingLotController(parkingLot);   
   }
   private List<ParkingSlot>createSlots(int numSlots,VehicleType vehicleType){
	   List<ParkingSlot>parkingSlots=new ArrayList<>();
	   for(int i=1;i<=numSlots;i++) {
		   parkingSlots.add(new ParkingSlot(i,false,vehicleType));
	   }
	   return parkingSlots;
   }
   
}
