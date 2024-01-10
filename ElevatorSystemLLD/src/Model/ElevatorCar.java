
package Model;

public class ElevatorCar {
       private int id;
       private ElevatorDoor door;
       private InternalButtons internalButtons;
       private Direction elevatorDirection;
       private ElevatorState elevatorState;
       private int currentFloor;
       private ElevatorDisplay display;
       
       public ElevatorCar() {
    	   door=new ElevatorDoor();
    	   internalButtons=new InternalButtons();
    	   elevatorDirection=Direction.IDLE;
    	   currentFloor=0;
    	   elevatorState=ElevatorState.IDLE;
           display=new ElevatorDisplay();
       }
       
       public void setDisplay() {
    	   display.setDisplay(currentFloor, elevatorDirection);
       }
       
       public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Direction getElevatorDirection() {
		return elevatorDirection;
	}

	public void setElevatorDirection(Direction elevatorDirection) {
		this.elevatorDirection = elevatorDirection;
	}

	public ElevatorState getElevatorState() {
		return elevatorState;
	}

	public void setElevatorState(ElevatorState elevatorState) {
		this.elevatorState = elevatorState;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public void setCurrentFloor(int currentFloor) {
		this.currentFloor = currentFloor;
	}

	public void showDisplay() {
    	   display.showDisplay();
       }
       
       public void pressButton() {
    	   
       }
       
       public void moveElevator(int floor) {
    	   
       }

       
}
