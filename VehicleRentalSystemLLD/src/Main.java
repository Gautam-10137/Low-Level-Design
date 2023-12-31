
import java.util.Scanner;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import Product.VehicleType;
import Product.Status;
import Product.Vehicle;
public class Main {
    private static final Scanner scanner= new Scanner(System.in);
    private static VehicleRentalSystem  rentalSystem= new VehicleRentalSystem();
	public static void main(String[] args) {
	     startRentalSystem();
		
	}
	private static void startRentalSystem() {
		int choice;
		do {
			System.out.println("***Vehicle Rental System***");
			System.out.println("1.Add User");
			System.out.println("2.Add Store");
			System.out.println("3.Add Vehicle to Store");
			System.out.println("4.Make Reservation");
			System.out.println("5.View User Rservation");
			System.out.println("6.View Store Reservation");
			System.out.println("7.Confirm Reservation");
			System.out.println("8.Cancel Reservation");
			System.out.println("9.Calculate Total Cost of Reservation");
			System.out.println("0. Exit");
			System.out.println("Enter your choice:");
			
			try {	
				choice=scanner.nextInt();
				scanner.nextLine();
			}catch(Exception e) {
				scanner.nextLine();
				choice=-1;
			}
			
			switch(choice) {
			    case 1:
			    	addUser();
			    	break;
			    case 2:
			    	addStore();
			    	break;
			    case 3:
			    	addVehicleToStore();
			    	break;
			    case 4:
			    	makeReservation();
			    	break;
			    case 5:
			    	viewUserReservation();
			    	break;
			    case 6:
			    	viewStoreReservation();
			    	break;
			    case 7:
			    	confirmReservation();
			    	break;
			    case 8:
			    	cancelReservation();
			    	break;
			    case 9:
			    	calculateCost();
			    	break;
			    default:
			    	System.out.println("Invalid choice .Please try again!");
			}
		}while(choice!=0);
	}
	
    private static void addUser() {
    	System.out.println("***Add User***");
    	System.out.println("Enter User ID:");
    	int userId=scanner.nextInt();
    	scanner.nextLine();
    	System.out.println("Enter username:");
    	String username=scanner.nextLine();
    	System.out.println("Enter License No.:");
    	String licenseNo=scanner.nextLine();
    	User user=new User(userId,username,licenseNo);
    	rentalSystem.addUser(user);
    	System.out.println("User added Successfully.");    	
   	
    }
    
    private static void addStore() {
    	System.out.println("\n***ADD Store");
    	System.out.println("Enter Store ID:");
    	int storeId=scanner.nextInt();
    	scanner.nextLine();
    	System.out.println("Store name:");
    	String storeName=scanner.nextLine();
    	System.out.println("Enter store location: (city,state,pincode,country)");
    	String location=scanner.nextLine();
    	String []values=location.split(",");
    	System.out.println("Enter address");
    	String address=scanner.nextLine();
    	int pinCode=Integer.valueOf(values[2]);
    	Location storeLocation=new Location(values[0],values[1],pinCode,values[3]);
    	storeLocation.setAddress(location);
    	Store store= new Store(storeId,storeName,storeLocation);
    	rentalSystem.addStore(store);
    	System.out.println("Store Added Successfully.");
    }
    
    private static void addVehicleToStore() {
    	System.out.println("*** Add Vehicle To Store***");
    	System.out.println("Enter store ID where vehicle should be added");
    	int storeID=scanner.nextInt();
    	scanner.nextLine();
    	Store store = rentalSystem.getStoreById(storeID);
    	if(store!=null) {
    	  Vehicle vehicle=new Vehicle();
      	  System.out.println("Enter Vehicle ID:");
      	  int vehicleId=scanner.nextInt();
      	  scanner.nextLine();
      	  vehicle.setVehicleId(vehicleId);
    	  System.out.println("Enter Vehicle Number:");
    	  String vehicleNum=scanner.nextLine();
   
    	  vehicle.setVehicleNumber(vehicleNum);
    	  System.out.println("Enter Vehicle type: 1. Car   2. Bike");
    	  int choice=scanner.nextInt();
    	  scanner.nextLine();
    	  VehicleType vehicleType;
    	  vehicleType=choice==1?VehicleType.CAR:VehicleType.BIKE;
    	  vehicle.setVehicleType(vehicleType);
    	  
    	  System.out.println("Enter (company name,model name):");
    	  String commodel=scanner.nextLine();
    	  String []comvalues=commodel.split(",");
    	  vehicle.setCompanyName(comvalues[0]);
    	  vehicle.setModelName(comvalues[1]);
    	  System.out.println("Enter (kmDriven average cc)");
    	  int kmDriven=scanner.nextInt();
    	  int average=scanner.nextInt();
    	  int cc=scanner.nextInt();
          vehicle.setKmDriven(kmDriven);
          vehicle.setAverage(average);
          vehicle.setCc(cc);
          
          System.out.println("\nEnter dailyRentalCost hourlyRentalCost noOfSeat");
          
          int dailyRentalCost=scanner.nextInt();
          int hourlyRentalCost=scanner.nextInt();
          int noOfSeat=scanner.nextInt();
          scanner.nextLine();
          vehicle.setDailyRentalCost(dailyRentalCost);
          vehicle.setHourlyRentalCost(hourlyRentalCost);
          vehicle.setNoOfSeat(noOfSeat);
          
          System.out.println("Enter vehicle status (ACTIVE, INACTIVE):");
          String statusStr=scanner.nextLine();
          Status status=statusStr=="ACTIVE"?Status.ACTIVE:Status.INACTIVE;     
          vehicle.setStatus(status);
          System.out.println("Enter no. of quantity:");
          int quantity=scanner.nextInt();
          scanner.nextLine();
          store.getInventory().addVehicleToInventory(storeID, vehicle,quantity);
          System.out.println("Vehicle added to store successfully");
    	}
    	else {
    		System.out.println("Store not found. Please check the store ID.");
    	}
    }
    
    private static void makeReservation() {
    	System.out.println("\n***Make Reservation***");
    	System.out.println("Enter User ID:");
    	int userID=scanner.nextInt();
    	scanner.nextLine();
    	User user= rentalSystem.getUserById(userID);
    	if(user!=null) {
    		System.out.println("Enter PickUp Location(city,state,pincode,country)");
    		String pickUpLocationStr=scanner.nextLine();
    		String []pickUpValues= pickUpLocationStr.split(",");
    		Location pickUpLocation=new Location(pickUpValues[0],pickUpValues[1],Integer.valueOf(pickUpValues[2]),pickUpValues[3]);
    		System.out.println("Enter PickUp Address:");
    		String pickUpAdd=scanner.nextLine();
    		pickUpLocation.setAddress(pickUpAdd);
    		Store nearestStore=rentalSystem.findNearestStore(pickUpLocation);
    		if(nearestStore!=null) {
    			System.out.println("Available vehicles at "+nearestStore.getStoreName()+":");
                displayAvailableVehicles(nearestStore);
    		
    		System.out.println("Enter Id of the vehicle you want to reserve:");
    		int selectedVehicleId=scanner.nextInt();
    		scanner.nextLine();
    		
    		Vehicle selectedVehicle=getVehicleById(nearestStore,selectedVehicleId);
    		if(selectedVehicle!=null) {
    			System.out.println("Enter reservation start Date and Time (YYYY-MM-DD HH:mm:ss): ");
    			String startDateStr=scanner.nextLine();
    			Date startDate=parseDate(startDateStr);
    			
    			System.out.println("Enter reservation end Date and Time (YYYY-MM-DD HH:mm:ss):");
    			String endDateStr=scanner.nextLine();
    			Date endDate=parseDate(endDateStr);
    			
    			System.out.println("Enter dropOff Location (city,state,pinCode,country):");
    			String dropOffLocStr=scanner.nextLine();
    			String []dropOffValues=dropOffLocStr.split(",");
    			Location dropOffLocation =new Location(dropOffValues[0],dropOffValues[1],Integer.valueOf(dropOffValues[2]),dropOffValues[3]);
    			System.out.println("Enter address for  drop off:");
    			String dropOffAdd=scanner.nextLine();
    			
    			dropOffLocation.setAddress(dropOffAdd);
    			
    			System.out.println("Enter Reservation type : 1.Hourly 2. Daily");
    			int resChoice=scanner.nextInt();
    			ReservationType resType=resChoice==1?ReservationType.HOURLY:ReservationType.DAILY;
    			
//    			creating new reservation
    			
    			Reservation reservation=new Reservation(user,selectedVehicle,startDate,endDate,pickUpLocation,dropOffLocation,resType);
    			
    			nearestStore.addReservation(reservation);
    			user.addUserReservation(reservation);
    			System.out.println("Reservation made successfully at nearest store: "+nearestStore.getStoreName());
 
    		}
    		else {
    			System.out.println("Invalid vehicle Id. Please check the Id and try again.");
    		}
    		}
    		else {
    			System.out.println("No store found near the pick-up location.");
    		}
    	}
    	else {
    		System.out.println("No User found. Please check the user Id");
    	}
    }
    
    private static Date parseDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Error parsing date. Please enter a valid date format (YYYY-MM-DD HH:mm:ss).");
            return null;
        }
    }
    
    private static Vehicle getVehicleById(Store store,int vehicleId) {
    	List<Vehicle> availableVehicles=store.getInventory().viewVehicleInventory(store.getStoreId());
    	for(Vehicle vehicle :availableVehicles) {
    		if(vehicle.getVehicleId()==vehicleId) {
    			return vehicle;
    		}
    	}
    	return null;
    }
    
    private static void displayAvailableVehicles(Store store) {
    	List<Vehicle> availableVehicles=store.getInventory().viewVehicleInventory(store.getStoreId());
    	if(!availableVehicles.isEmpty()) {
    		 for(Vehicle vehicle:availableVehicles) {
    			 System.out.println(vehicle.getVehicleId()+". "+vehicle.getCompanyName()+"(company) "+vehicle.getModelName()+"(model) ");
    		 }
    	}
    	else {
    		System.out.println("No Vehicle available at moment.");
    	}
    }
    
    private static void viewUserReservation() {
    	System.out.println("*** View User Reservation");
    	System.out.println("Enter user Id:");
    	int userId=scanner.nextInt();
    	scanner.nextLine();
    	User user= rentalSystem.getUserById(userId);
    	if(user!=null) {
    		System.out.println("User "+user.username+"'s Reservations:");
    		for(Reservation reservation:user.reservations) {
    			printReservationDetails(reservation);
    		}

    	}
    	else {
    		System.out.println("User not found. Please check the user Id and try again.");
    	}
    }
    
    private static void viewStoreReservation() {
    	System.out.println("*** View Store Reservation");
    	System.out.println("Enter store Id:");
    	int storeId=scanner.nextInt();
    	scanner.nextLine();
    	Store store= rentalSystem.getStoreById(storeId);
    	if(store!=null) {
    		System.out.println("Store "+store.getStoreName()+"'s Reservations:");
    		for(Reservation reservation:store.getReservation()) {
    			printReservationDetails(reservation);
    		}

    	}
    	else {
    		System.out.println("Store not found. Please check the store Id and try again.");
    	} 	
    }
    
      private static void printReservationDetails(Reservation reservation) {
    	System.out.println("Reservation ID: " + reservation.reservationId);
        System.out.println("Vehicle: " + reservation.vehicle.getModelName());
        System.out.println("Pick-up Location: " + reservation.pickUpLocation.address);
        System.out.println("Drop-off Location: " + reservation.dropLocation.address);
        System.out.println("Start Date: " + reservation.dateBookedFrom);
        System.out.println("End Date: " + reservation.dateBookedTo);
        System.out.println("Reservation Type: " + reservation.reservationType);
        System.out.println("Status: " + reservation.reservationStatus);
        System.out.println("--------------------------------------------");
    } 
      
      private static void confirmReservation() {
    	    System.out.println("\n*** Confirm Reservation ***");
    	    System.out.print("Enter Store ID : ");
    	    int storeId = scanner.nextInt();
    	    scanner.nextLine();
    	    System.out.print("Enter Reservation ID to confirm: ");
    	    int reservationId = scanner.nextInt();
    	    scanner.nextLine(); // Consume the newline character
            
    	    Store store = rentalSystem.getStoreById(storeId);
            Reservation reservation=getReservationById(store,reservationId);
    	    if (reservation != null) {
    	        if (reservation.reservationStatus == ReservationStatus.PENDING) {
    	            reservation.confirmReservation();
    	            System.out.println("Reservation confirmed successfully!");
    	        } else {
    	            System.out.println("Reservation cannot be confirmed. Check the reservation status.");
    	        }
    	    } else {
    	        System.out.println("Reservation not found. Please check the Reservation ID.");
    	    }
    }
      
      private static void cancelReservation() {
    	  System.out.println("\n*** Cancel Reservation***");
    	  System.out.print("Enter Store ID: ");
    	  int storeId=scanner.nextInt();
    	  scanner.nextLine();
    	  System.out.println("Enter Reservation ID: ");
    	  int reservationId=scanner.nextInt();
    	  scanner.nextLine();
    	  Store store=rentalSystem.getStoreById(storeId);
    	  Reservation reservation=getReservationById(store,reservationId);
    	  if(reservation!=null) {
    		  if(reservation.reservationStatus==ReservationStatus.PENDING || reservation.reservationStatus==ReservationStatus.CONFIRMED) {
    			  reservation.cancelReservation();
    			  System.out.println("Reservation Cancelled Successfully.");
    		  }
    		  else {
    			  System.out.println("Reservation can't be cancelled. Check the reservation status.");
    		  }
    	  }
    	  else {
    		  System.out.println("Reservation not found. Please check the Reservation ID.");
    	  }
      }
      
      private static Reservation getReservationById(Store store,int reservationId) {
    	  for(Reservation reservation : store.getReservation()) {
    		  if(reservation.reservationId==reservationId) {
    			  return reservation;
    		  }
    	  }
    	  return null;
      }
      
      private static void calculateCost() {
    	  System.out.println("\n*** Calculate Total Cost***");
    	  System.out.print("Enter Store ID:");
    	  int storeId=scanner.nextInt();
    	  scanner.nextLine();
    	  System.out.println("Enter reservation Id: ");
    	  int reservationId=scanner.nextInt();
    	  scanner.nextLine();
    	  Store store=rentalSystem.getStoreById(storeId);
    	  Reservation reservation= getReservationById(store,reservationId);
    	  
    	  double totalCost=reservation.calculateTotalCost();
    	  System.out.println("Total cost  "+totalCost);
    	  
      }
   
}
