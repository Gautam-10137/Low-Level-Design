import controller.ParkingLotController;
import ParkingLot.ParkingLotFactory;
import ParkingLot.Vehicle;
import ParkingLot.Ticket;
import cost.CostDetails;
import ParkingLot.VehicleType;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import ParkingLot.ParkingSlot;
import java.util.Scanner;
import java.util.List;
public class Main {
	private static ParkingLotController parkingLotController;
	public static void main(String[] args) {
         
		initializeParkingLot();
		
		startCommandLineInterface();
		
	}
	private static void initializeParkingLot() {
		ParkingLotFactory parkingLotFactory=new ParkingLotFactory();
//		creating parking Lot with 10 two-wheeler slots and 5 four-wheeler slots.
		parkingLotController=parkingLotFactory.createParkingLot(10,5);
	}
	
    private static void startCommandLineInterface() {
    	System.out.println("------------------------");
    	System.out.println("Parking Lot System");
    	System.out.println("------------------------");
    	System.out.println("Welcome to the Parking Lot Command Line Interface!");
    	
    	Scanner scanner= new Scanner(System.in);
    	while(true) {
    		System.out.println("1. Process Entry");
    		System.out.println("2. Process Exit");
    		System.out.println("3. Display Available Slots");
    		System.out.println("4. Exit System");
    		System.out.print("Enter you choice:");
    		
    		int choice=scanner.nextInt();
    		
    		switch(choice) {
    		case 1:
    			processEntry();
    			break;
    		case 2:
    			processExit();
    			break;
    		case 3:
    			displayAvailableSlots();
    			break;
    		case 4:
    			System.out.println("Exiting the system. Goodbye!");
    			System.exit(0);
    		default:
    			System.out.println("Invalid choice. Please try again. ");
    	}
    }
    }
    
    private static void processEntry() {
    	Scanner scanner= new Scanner(System.in);
    	
    	System.out.println("Enter License Plate:");
    	String licensePlate=scanner.nextLine();
    	System.out.println("Enter vehicle type (1 for Two-Wheeler,2 for Four-Wheeler");
    	int vehicleTypeChoice=scanner.nextInt();
    	VehicleType vehicleType=vehicleTypeChoice==1?VehicleType.TWO_WHEELER:VehicleType.FOUR_WHEELER;
    	Vehicle vehicle= new Vehicle(licensePlate,vehicleType);
    	
    	Ticket ticket=parkingLotController.processEntry(vehicle);
    	if(ticket!=null) {
    		System.out.println("Vehicle parked successfully. TicketId:"+ticket.getTicketId());
    	}
    }
    
    private static void processExit() {
    	Scanner scanner= new Scanner(System.in);
    	
    	System.out.println("Enter Ticket ID:");
    	int ticketID=scanner.nextInt();
    	CostDetails costDetails=parkingLotController.processExit(ticketID);
    	
    	if(costDetails!=null) {
    		System.out.println("Vehicle Exited Successfully");
    		System.out.println("Total Cost : $"+costDetails.totalCost());
    		System.out.println("Parking Duration: "+costDetails.getDuration().toMinutes()+"minutes");
    	}
    	
    }
    
    private static void displayAvailableSlots() {
    	System.out.println("Displaying Available Slots:");
    	System.out.println(" Available Two-Wheeler Slots:");
    	List<ParkingSlot>availableTwoWheelerSlots=parkingLotController.getAvailableSlots(VehicleType.TWO_WHEELER);
    	
    	displaySlots(availableTwoWheelerSlots);
    	
    	System.out.println("Available Four-Wheeler Slots:");
    	List<ParkingSlot> availableFourWheelerSlots=parkingLotController.getAvailableSlots(VehicleType.FOUR_WHEELER);
    	displaySlots(availableFourWheelerSlots);
    }
    
    private static void displaySlots(List<ParkingSlot> availableSlots) {
    	for(ParkingSlot slot : availableSlots) {
    		System.out.println("Slot ID: "+slot.getSlotId());	
       }
    }
    
  
}
