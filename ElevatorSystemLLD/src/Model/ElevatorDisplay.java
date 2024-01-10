package Model;

public class ElevatorDisplay {
         private int floor;
         private Direction direction;
        
       public ElevatorDisplay() { 
    	   this.floor=1;
    	   direction=Direction.IDLE;
       }
       
       public void setDisplay(int floor,Direction direction) {
    	   this.floor=floor;
    	   this.direction=direction;
       }
       
       public void showDisplay() {
    	   System.out.println("Floor:"+floor+" "+direction);
       }
}
