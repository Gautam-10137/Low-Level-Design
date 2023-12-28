
public class Location {
     public String address;
     public String city;
     public String state;
     public int pinCode;
     public String country;
     
     public Location(String city, String state,int pinCode,String country) {
    	 this.city=city;
    	 this.state=state;
    	 this.pinCode=pinCode;
    	 this.country=country;
     }
     public void setAddress(String address) {
    	 this.address=address;
     }
     
     
}
