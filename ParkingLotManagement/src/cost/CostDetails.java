package cost;
import java.time.Duration;
public class CostDetails {
     private double totalCost;
     private Duration duration;
     
     public CostDetails(double totalCost, Duration duration) {
    	 this.totalCost=totalCost;
    	 this.duration=duration;
     }
     
     public double totalCost() {
    	 
    	 return totalCost;
     }
     public Duration getDuration() {
    	 return duration;
     }
}
