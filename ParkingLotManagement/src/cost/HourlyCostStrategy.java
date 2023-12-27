package cost;
import java.time.Duration;
public class HourlyCostStrategy implements CostComputationStrategy{

	public CostDetails calculateCost(Duration duration) {
		double totalCost=duration.toHours()*10;   // $.10 per hour
//		double totalCost=120; 
		return new CostDetails(totalCost,duration);
	}
	
	
}
