package Logger;

public class Debug extends Logger {
   
	public Debug(Logger nextLogger) {
		super(nextLogger);
	}
	
	public void handleLog(String message) {
		System.out.println("Debug: "+message);
	}
}
