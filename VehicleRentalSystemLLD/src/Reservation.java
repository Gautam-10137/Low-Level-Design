import Product.Vehicle;
import java.util.Date;

public class Reservation {
	 public static int nextReservationId=1;
     
	 public int reservationId;
     public User user;
     public Vehicle vehicle;
     public Date bookingDate;
     public Date dateBookedFrom;
     public Date dateBookedTo;
     public Long fromTimeStamp;
     public Long toTimeStamp;
     public Location pickUpLocation;
     public Location dropLocation;
     public ReservationType reservationType;
     public ReservationStatus reservationStatus;
     
     
     public Reservation(User user, Vehicle vehicle, Date dateBookedFrom ,Date dateBookedTo, Location pickUpLocation, Location dropLocation,ReservationType reservationType) {
    	 this.reservationId= generateReservationId();
    	 this.user=user;
    	 this.vehicle=vehicle;
    	 this.bookingDate=new Date();
    	 this.dateBookedFrom=dateBookedFrom;
    	 this.dateBookedTo=dateBookedTo;
    	 this.fromTimeStamp=dateBookedFrom.getTime();
    	 this.toTimeStamp=dateBookedTo.getTime();
    	 this.pickUpLocation=pickUpLocation;
    	 this.dropLocation=dropLocation;
    	 this.reservationType=reservationType;
    	 this.reservationStatus=ReservationStatus.PENDING;
    	   	 
     }
     
     public  int generateReservationId() {
    	 return nextReservationId++;
     }
     
     public void confirmReservation() {
    	 if(reservationStatus==ReservationStatus.PENDING) {
    		 reservationStatus=ReservationStatus.CONFIRMED;
    	 }
    	 else {
    		 System.out.println("Cannot confirm Reservation. Status:"+reservationStatus);
    	 }
     }
     public void cancelReservation() {
    	 if(reservationStatus==ReservationStatus.PENDING ||reservationStatus==ReservationStatus.CONFIRMED ) {
    		 reservationStatus=ReservationStatus.CANCELLED;
    	 }
    	 else {
    		 System.out.println("Cannot cancel reservation. Status:"+reservationStatus);
    	 }
     }
     public double calculateTotalCost() {
    	 long durationInHours=getDurationInHours();
    	 if(this.reservationType==ReservationType.HOURLY) {
    		 return durationInHours*this.vehicle.getHourlyRentalCost();
    	 }
    	 else {
    		 return durationInHours/24.0*vehicle.getDailyRentalCost();
    	 }
     }
     private long getDurationInHours() {
    	 long durationInMillis=this.fromTimeStamp-this.toTimeStamp;
    	 return durationInMillis/(60*60*1000);
     }
     public String toString() {
    	 return "Reservation ID: " + reservationId +
                 "\nUser: " + user.username +
                 "\nVehicle: " + vehicle.getModelName() +
                 "\nBooking Date: " + bookingDate +
                 "\nPickup Date: " + dateBookedFrom +
                 "\nReturn Date: " + dateBookedTo +
                 "\nPickup Location: " + pickUpLocation.address +
                 "\nDrop Location: " + dropLocation.address +
                 "\nReservation Type: " + reservationType +
                 "\nReservation Status: " + reservationStatus;
     }
     
     
     
     
}
