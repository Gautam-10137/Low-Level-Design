package cost;
import java.time.Duration;
public class MinuteCostStrategy implements CostComputationStrategy{

	public CostDetails calculateCost(Duration duration) {
		double totalCost=duration.toMinutes()*0.2; // $.0.2 per minute
//		double totalCost=100;
		return new CostDetails(totalCost,duration);
	}
}
