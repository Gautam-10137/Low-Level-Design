package slotManager;
import ParkingLot.ParkingSlot;
import ParkingLot.Ticket;
import java.util.List;
import java.util.ArrayList;
import ParkingLot.Vehicle;
import cost.CostComputationStrategy;
import ParkingLot.VehicleType;

import java.time.Duration;
import java.time.LocalDateTime;
import cost.CostDetails;
public class ParkingSlotManager {
   private List<ParkingSlot> twoWheelerSlots;
   private List<ParkingSlot> fourWheelerSlots;
   private List<Ticket> twoWheelerTickets;
   private List<Ticket> fourWheelerTickets;
   private CostComputationStrategy costStrategy;
   
   public ParkingSlotManager(List<ParkingSlot>twoWheelerSlots,List<ParkingSlot> fourWheelerSlots,CostComputationStrategy costStrategy) {
	   this.twoWheelerSlots=twoWheelerSlots;
	   this.fourWheelerSlots=fourWheelerSlots;
	   this.twoWheelerTickets=new ArrayList<>();
	   this.fourWheelerTickets=new ArrayList<>();
	   this.costStrategy=costStrategy;
   }
   
   public List<ParkingSlot> getAvailableSlots(VehicleType vehicleType){
	   if(vehicleType== VehicleType.TWO_WHEELER) {
		   return getAvailableTwoWheelerSlots();
	   }
	   else {
		   return getAvailableFourWheelerSlots();
	   }
   }
   
   public Ticket parkVehicle(Vehicle vehicle) {
	   List<ParkingSlot> availableSlots=getAvailableSlots(vehicle.getVehicleType());
	   if(!availableSlots.isEmpty()) {
		   ParkingSlot selectedSlot=availableSlots.get(0);
		   selectedSlot.occupySlot();
		   Ticket ticket= new Ticket(twoWheelerSlots.size()+fourWheelerSlots.size()+1,vehicle,selectedSlot,LocalDateTime.now());
		   if(vehicle.getVehicleType()==VehicleType.TWO_WHEELER) {
			   twoWheelerTickets.add(ticket);
		   }
		   else {
			   fourWheelerTickets.add(ticket);
		   }
		   return ticket;
	   }
	   else {
		   System.out.println("No Available Parking Slots for :" +vehicle.getVehicleType());
		   return null;
	   }
	   
   }
   public CostDetails vacateSlot(int ticketId) {
	   Ticket ticket=findTicketById(ticketId);
	   if(ticket!=null) {
		   ParkingSlot parkingSlot=ticket.getParkingSlot();
		   parkingSlot.vacateSlot();
		   Duration duration=Duration.between(ticket.getEntryTime(), LocalDateTime.now());
		   return costStrategy.calculateCost(duration);
		   
	   }
	   else {
		   System.out.println("Ticket Not Found For ID:"+ticketId);
		   return null;
	   }
   }
   
   public Ticket findTicketById(int ticketId) {
	   for(Ticket ticket:getTickets()) {
		   if(ticket.getTicketId()==ticketId) {
			   return ticket;
		   }
	   }
	   return null;
   }
   public List<Ticket>getTickets() {
	   List<Ticket> allTickets=new ArrayList<>();
	   allTickets.addAll(twoWheelerTickets);
	   allTickets.addAll(fourWheelerTickets);
	   return allTickets;
   }
   public List<Ticket> getAllTickets(){
	   return getTickets();
   }
   
   
   
   
   
   public List<ParkingSlot> getAvailableTwoWheelerSlots(){
	   return getAvailableSlots(twoWheelerSlots);
   }
   public List<ParkingSlot> getAvailableFourWheelerSlots(){
	   return getAvailableSlots(fourWheelerSlots);
   }
   public List<ParkingSlot> getAvailableSlots(List<ParkingSlot> slots){
	   List <ParkingSlot> availableSlots=new ArrayList<>();
	   for(ParkingSlot slot: slots) {
		   if(!slot.isOccupied()) {
			   availableSlots.add(slot);
		   }
	   }
	   return availableSlots;
   }

   
}
