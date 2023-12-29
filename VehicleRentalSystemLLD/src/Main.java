
import java.util.Scanner;


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
    	System.out.println("Store name");
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
    	  int vehicleNum=scanner.nextInt();
    	  scanner.nextLine();
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
          vehicle.setDailyRentalCost(dailyRentalCost);
          vehicle.setHourlyRentalCost(hourlyRentalCost);
          vehicle.setNoOfSeat(noOfSeat);
          
          System.out.println("Enter vehicle status (ACTIVE, INACTIVE):");
          String statusStr=scanner.nextLine();
          Status status=statusStr=="ACTIVE"?Status.ACTIVE:Status.INACTIVE;     
          vehicle.setStatus(status);
          int quantity=scanner.nextInt();
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
    	User user= rentalSystem.getUserById(userID);
    	if(user!=null) {
    		System.out.println("Enter PickUp Location(city,state,pincode,country)");
    		String locationStr=scanner.nextLine();
//    		String []values=
//    		Location location=new Location()
    		
    		
    		
    	}
    }
    
    private static void viewUserReservation() {
    	
    }
    
    private static void viewStoreReservation() {
    	
    }
    
    
   
}
