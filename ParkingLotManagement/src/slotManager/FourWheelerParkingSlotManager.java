package slotManager;
import java.util.List;
import cost.CostComputationStrategy;
import ParkingLot.ParkingSlot;
import java.util.ArrayList;
public class FourWheelerParkingSlotManager extends ParkingSlotManager {

	public FourWheelerParkingSlotManager(List<ParkingSlot>fourWheelerSlots,CostComputationStrategy costStrategy) {
		super(new ArrayList<>(),fourWheelerSlots,costStrategy);
	}
}
