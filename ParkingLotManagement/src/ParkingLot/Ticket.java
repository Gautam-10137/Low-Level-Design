package ParkingLot;
import java.time.LocalDateTime;
import java.time.Duration;
public class Ticket {
     private int ticketId;
     private Vehicle vehicle;
     private ParkingSlot parkingSlot;
     private LocalDateTime entryTime;
     
     public Ticket(int ticketId,Vehicle vehicle,ParkingSlot parkingSlot, LocalDateTime entryTime) {
    	 this.ticketId=ticketId;
    	 this.vehicle=vehicle;
    	 this.parkingSlot=parkingSlot;
    	 this.entryTime=entryTime;
    	 
     }
     public int getTicketId() {
    	 return ticketId;
     }
     public Vehicle getVehicle() {
    	 return vehicle;
     }
     public ParkingSlot getParkingSlot() {
    	 return parkingSlot;
     }
     public LocalDateTime getEntryTime() {
    	 return entryTime;
     }
     public Duration calculateDuration() {
    	 LocalDateTime currentTime=LocalDateTime.now();
    	 return Duration.between(entryTime,currentTime);
     }
     
}
