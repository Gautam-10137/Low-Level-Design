import java.util.List;
import java.util.ArrayList;
public class User {

	  public int userId;
      public String username;
      public String licenseNo;
      List<Reservation> reservations;
      public User(int userId,String username,String licenseNo){
    	  this.userId=userId;
    	  this.username=username;
    	  this.licenseNo=licenseNo;
    	  this.reservations=new ArrayList<>();
      }
 
      public void addUserReservation(Reservation reservation) {
    	  this.reservations.add(reservation);
      }
}
