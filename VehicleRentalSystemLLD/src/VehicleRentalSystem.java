import java.util.List;
import java.util.ArrayList;
public class VehicleRentalSystem {
       List<User> users;
       List<Store> stores;
       
      public  VehicleRentalSystem(){
    	   this.users=new ArrayList<>();
    	   this.stores=new ArrayList<>();
      }
      
      public void addUser(User user) {
    	  users.add(user);
      }
      
      public void removeUser(int userId) {
    	  users.removeIf(User->User.userId==userId);
      }
      
      public void addStore(Store store) {
    	  stores.add(store);
      }
      public void removeStore(int storeId) {
    	  stores.removeIf(store->store.getStoreId()==storeId);
      }
      
      
      public  Store findNearestStore(Location pickUpLocation) {
    	    if (stores.isEmpty()) {
    	        return null; 
    	    }

    	    Store nearestStore = stores.get(0);
    	    double minDistance = calculateDistance(pickUpLocation, nearestStore.getStoreLocation());

    	    for (int i = 1; i < stores.size(); i++) {
    	        Location storeLocation = stores.get(i).getStoreLocation();
    	        double distance = calculateDistance(pickUpLocation, storeLocation);

    	        if (distance < minDistance) {
    	            minDistance = distance;
    	            nearestStore = stores.get(i);
    	        }
    	    }

    	    return nearestStore;
    	}
      
      private static double calculateDistance(Location location1, Location location2) {
    	    // Euclidean distance formula for 2D space
    	    double dx = location1.pinCode - location2.pinCode;
    	    return Math.sqrt(dx * dx);
    	}
      
      public Store getStoreById(int storeId) {
    	  for(Store store:stores) {
    		  if(store.getStoreId()==storeId) {
    			  return store;
    		  }
    	  }
    	  
    	  return null;
      }
      public User getUserById(int userId) {
    	  for(User user:users) {
    		  if(user.userId==userId) {
    			  return user;
    		  }
    	  }
    	  return null;
      }
}
