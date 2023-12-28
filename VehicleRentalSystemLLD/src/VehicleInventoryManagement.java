import java.util.List;
import Product.Vehicle;
import java.util.ArrayList;
public class VehicleInventoryManagement {
    List<InventoryEntry> inventory;
    
    public VehicleInventoryManagement() {
    	this.inventory=new ArrayList<>();
    }
    
    public void addVehicleToInventory(int storeId, Vehicle vehicle,int quantity) {
    	InventoryEntry entry= new InventoryEntry(storeId,vehicle,quantity);
    	inventory.add(entry);
    }
    
    public void removeVehicleFromInventory(int vehicleId,int storeId) {
    	inventory.removeIf(entry->entry.storeId==storeId && entry.vehicle.getVehicleId()==vehicleId);
    }
    
    public void updateVehicleQuantity(int vehicleId,int storeId,int newQuantity) {
    	for(InventoryEntry entry:inventory) {
    		if(entry.storeId==storeId && entry.vehicle.getVehicleId()==vehicleId) {
    			entry.quantity=newQuantity;
    			break;
    		}
    	}
    }
    
    public List<Vehicle> viewVehicleInventory(int storeId){
    	List<Vehicle> storeInventory= new ArrayList<>();
    	for(InventoryEntry entry:inventory) {
    		if(entry.storeId==storeId) {
    			storeInventory.add(entry.vehicle);
    		}
    	}
    	return storeInventory;
    }
}
