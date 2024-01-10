package Model;
import java.util.PriorityQueue;
public class ElevatorController {
// creating an elevator to which it controls 
	ElevatorCar elevator;
//	creating minHeap for moving up
	PriorityQueue<Integer> upMinPQ;
//	creating maxHeap for moving down
	PriorityQueue<Integer> downMaxPQ;
	
	public ElevatorController(ElevatorCar elevator) {
		this.elevator=elevator;
		this.upMinPQ=new PriorityQueue<>();
		this.downMaxPQ= new PriorityQueue<>((a,b)-> b-a);
	}
	
//	here floor in parameter is floor from which request is raised
	public void submitExternalRequest(int floor,Direction direction){
//		it will add that floor on which external button is clicked to Queue
		if(direction==Direction.UP) {
			upMinPQ.offer(floor);
		}
		else {
			downMaxPQ.offer(floor);
		}
	}
	
	
//	here in parameter floor is destination floor
	public void submitInternalRequest(int floor) {
//		getting currentFloor so that we can decide in which queue to add request
		int currentFloor= elevator.getCurrentFloor();
		if(floor > currentFloor) {
			upMinPQ.offer(floor);
		}
		else {
			downMaxPQ.offer(floor);
		}
	}
	public void control() {
		while(true) {
			if(elevator.getElevatorDirection()==Direction.UP) {
				if(!upMinPQ.isEmpty()) {
					int floor=upMinPQ.poll();
					elevator.moveElevator(floor);
				}
				else if(!downMaxPQ.isEmpty()) {
				   elevator.setElevatorDirection(Direction.DOWN);
				}
			}
			else if(elevator.getElevatorDirection()==Direction.DOWN) {
				if(!downMaxPQ.isEmpty()) {
					int floor=downMaxPQ.poll();
					elevator.moveElevator(floor);
				}
				else if(!upMinPQ.isEmpty()) {
					elevator.setElevatorDirection(Direction.UP);
				}
			}
			else {
				elevator.setElevatorDirection(Direction.IDLE);
				waitForNewRequest();
			}
		}
	}
	
	private void waitForNewRequest() {
		if(!upMinPQ.isEmpty()) {
			elevator.setElevatorDirection(Direction.UP);
		}
		else if(!downMaxPQ.isEmpty()) {
			elevator.setElevatorDirection(Direction.DOWN);
		}
	}
}
