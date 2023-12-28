import Product.Vehicle;
public class InventoryEntry {
      public int storeId;
      public Vehicle vehicle;
      public int quantity;
      
      public InventoryEntry(int storeId, Vehicle vehicle, int quantity) {
    	  this.storeId=storeId;
    	  this.vehicle=vehicle;
    	  this.quantity=quantity;
      }
      
}
