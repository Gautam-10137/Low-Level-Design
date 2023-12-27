package ParkingLot;

public class ParkingSlot {
    private int slotId;
    private boolean isOccupied;
    private VehicleType vehicleType;
    
    public ParkingSlot(int slotId, boolean isOccupied, VehicleType vehicleType) {
    	this.slotId=slotId;
    	this.isOccupied=isOccupied;
    	this.vehicleType=vehicleType;
    }
    
    public int getSlotId() {
    	return slotId;
    }
    
    public boolean isOccupied() {
    	return isOccupied;
    }
    
    public VehicleType getVehicleType() {
    	return vehicleType;
    }
    
    public void occupySlot() {
    	isOccupied=true;
    }
    
    public void vacateSlot() {
    	isOccupied=false;
    }
    
}
