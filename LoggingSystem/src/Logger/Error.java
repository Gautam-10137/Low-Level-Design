package Logger;

public class Error extends Logger {

	public Error(Logger nextLogger) {
		super(nextLogger);
	}
	
	public void handleLog(String message) {
		System.out.println("Error: "+message);
	}
}
