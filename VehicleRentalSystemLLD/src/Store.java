import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
public class Store {
    private int storeId;
    private String storeName;
    private  VehicleInventoryManagement inventoryManagement;
    private Location storeLocation;
    private List<Reservation> reservations;
    
    public Store(int storeId,String storeName, Location storeLocation) {
    	this.storeId=storeId;
    	this.storeName=storeName;
    	this.inventoryManagement=new VehicleInventoryManagement();
    	this.storeLocation=storeLocation;
    	this.reservations=new ArrayList<>();
    }
    
    public int getStoreId() {
    	return storeId;
    }
    
    public String getStoreName() {
    	return storeName;
    }
    
    public VehicleInventoryManagement getInventory() {
    	return inventoryManagement;
    }
    
    public Location getStoreLocation() {
    	return storeLocation;
    }
    public List<Reservation> getReservation(){
    	return reservations;
    }
    
    public void addReservation(Reservation reservation) {
    	reservations.add(reservation);
    }
    
    public void removeReservation(int reservationId) {
    	Iterator<Reservation> iterator=reservations.iterator();
    	while(iterator.hasNext()) {
    		Reservation reservation=iterator.next();
    		if(reservation.reservationId==reservationId) {
    			iterator.remove();
    			System.out.println("Reservation with reservation ID :"+reservationId+" removed from store");
    			return;
    		}
    	}
    	
    	System.out.println("Reservation with ID: "+reservationId+" not found in the store.");
    	
    }
    
    
    
    
    
}
