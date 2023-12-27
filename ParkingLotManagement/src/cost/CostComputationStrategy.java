package cost;
import java.time.Duration;
public interface CostComputationStrategy {

	 public CostDetails calculateCost(Duration duration);
}
