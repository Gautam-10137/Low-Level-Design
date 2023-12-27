package ParkingLot;
import java.util.List;
import gate.EntryGate;
import gate.ExitGate;
import java.util.HashMap;
import java.util.Map;
import controller.ParkingLotController;
import slotManager.ParkingSlotManager;
import cost.CostComputationStrategy;
import slotManager.TwoWheelerParkingSlotManager;
import slotManager.FourWheelerParkingSlotManager;
import cost.HourlyCostStrategy;
import cost.MinuteCostStrategy;
public class ParkingLot {
     private List<ParkingSlot> twoWheelerSlots;
     private List<ParkingSlot> fourWheelerSlots;
     private EntryGate entryGate;
     private ExitGate exitGate;
     private ParkingLotController parkingLotController;
     private Map<VehicleType,ParkingSlotManager> parkingSlotManagers;
     
     public ParkingLot(List<ParkingSlot> twoWheelerSlots,List<ParkingSlot> fourWheelerSlots) {
    	 this.twoWheelerSlots=twoWheelerSlots;
    	 this.fourWheelerSlots=fourWheelerSlots;
    	 this.entryGate=new EntryGate(1,null);
    	 this.exitGate=new ExitGate(2,null);
    	 this.parkingLotController=new ParkingLotController(this);
    	 entryGate.setParkingLotController(parkingLotController);
    	 exitGate.setParkingLotController(parkingLotController);
    	 this.parkingSlotManagers=new HashMap<>();
     }
     public EntryGate getEntryGate() {
    	 return entryGate;
     }
     public ExitGate getExitGate() {
    	 return exitGate;
     }
     
     public ParkingSlotManager getParkingSlotManager(VehicleType vehicleType) {
    	 if(!parkingSlotManagers.containsKey(vehicleType)) {
    		 ParkingSlotManager parkingSlotManager;
    		 CostComputationStrategy costStrategy=getCostStrategy(vehicleType);
    		 if(vehicleType==VehicleType.TWO_WHEELER) {
    			 parkingSlotManager=new TwoWheelerParkingSlotManager(twoWheelerSlots,costStrategy);
    		 }
    		 else {
    			 parkingSlotManager= new FourWheelerParkingSlotManager(fourWheelerSlots,costStrategy);
    		 }
    		 parkingSlotManagers.put(vehicleType, parkingSlotManager);
    		 
    	 }
    	 return parkingSlotManagers.get(vehicleType);
    	 
     }
     public CostComputationStrategy getCostStrategy(VehicleType vehicleType) {
    	 if(vehicleType==VehicleType.TWO_WHEELER) {
    		 return new HourlyCostStrategy();
    	 }
    	 else {
    		 return new MinuteCostStrategy();
    	 }
     }
}

