package slotManager;
import java.util.List;
import cost.CostComputationStrategy;
import ParkingLot.ParkingSlot;
import java.util.ArrayList;
public class TwoWheelerParkingSlotManager extends ParkingSlotManager {
     public TwoWheelerParkingSlotManager(List<ParkingSlot> twoWheelerSlots, CostComputationStrategy costStrategy) {
    	 super(twoWheelerSlots,new ArrayList<>(),costStrategy);
     }
}
