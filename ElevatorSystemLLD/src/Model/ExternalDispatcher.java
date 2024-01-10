package Model;
import java.util.List;
import java.util.ArrayList;
public class ExternalDispatcher {

	private List<ElevatorController> controllerList;
	
	public ExternalDispatcher(List<ElevatorController> controllers) {
		controllerList=controllers;
	}
	
	public void dispatch(int floor, Direction direction) {
//		for(ElevatorController elevatorController: controllerList) {
//			int elevatorId=elevatorController.getElevator().getId();
//			if(elevatorId%2==1 && floor%2==1 || elevatorId%2==0 && elevatorId%2==0) {
//				elevatorController.submitExternalRequest(floor,direction);
//			}
//		}
	}
}
