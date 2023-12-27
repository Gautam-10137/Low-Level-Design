package controller;
import ParkingLot.ParkingLot;
import gate.EntryGate;
import ParkingLot.Vehicle;
import slotManager.ParkingSlotManager;
import ParkingLot.Ticket;
import gate.ExitGate;
import cost.CostDetails;
import java.util.List;
import ParkingLot.VehicleType;
import ParkingLot.ParkingSlot;
import java.util.Map;
import java.util.HashMap;
public class ParkingLotController {
    private ParkingLot parkingLot;
    private Map <Vehicle,Ticket>enteredVehicle; 
   public ParkingLotController(ParkingLot parkingLot) {
	   this.parkingLot=parkingLot;
	   this.enteredVehicle=new HashMap<>();
   }
   
   public Ticket processEntry(Vehicle vehicle) {
	   System.out.println("Processing entry of vehicle: "+ vehicle.getLicencePlate());
	   EntryGate entryGate=parkingLot.getEntryGate();
	   entryGate.processVehicle(vehicle);
	   
	   ParkingSlotManager parkingSlotManager=parkingLot.getParkingSlotManager(vehicle.getVehicleType());
	   Ticket ticket=parkingSlotManager.parkVehicle(vehicle);
	   enteredVehicle.put(vehicle, ticket);
	   return ticket;
   }
   
   public CostDetails processExit(int ticketID) {
	   Vehicle vehicle=findVehicleByTicketID(ticketID);
	   if(vehicle!=null) {
	   System.out.println("Processing exit of vehicle: "+ vehicle.getLicencePlate());
	   
	   ExitGate exitGate=parkingLot.getExitGate();
	   
	   exitGate.processVehicle(vehicle);
	   
	  

	   Ticket ticket=enteredVehicle.get(vehicle);
	   if(ticket!=null) {
		   ParkingSlotManager parkingSlotManager=parkingLot.getParkingSlotManager(vehicle.getVehicleType());
		   return parkingSlotManager.vacateSlot(ticket.getTicketId());
	   }
	   else {
		   System.out.println("Vehicle not found in the parking lot.");
	   }
	   }
	   else {
	   System.out.println("Vehicle not found with Ticket ID:"+ticketID);
	   }
	   return null;
   }
   private Vehicle findVehicleByTicketID(int ticketID) {
	   for(Map.Entry<Vehicle, Ticket> entry: enteredVehicle.entrySet()) {
		   Ticket ticket=entry.getValue();
		   if(ticket!=null && ticket.getTicketId()==ticketID) {
			   return entry.getKey();
		   }
	   }
	   return null;
   }
   
   public List<ParkingSlot> getAvailableSlots(VehicleType vehicleType){
	   System.out.println("Getting Available Slots for: "+ vehicleType);
	   ParkingSlotManager parkingSlotManager=parkingLot.getParkingSlotManager(vehicleType);
	   return parkingSlotManager.getAvailableSlots(vehicleType);
   }
}
