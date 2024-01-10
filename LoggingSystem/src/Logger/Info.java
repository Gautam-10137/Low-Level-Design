package Logger;

public class Info extends Logger{
    
	public Info(Logger nextLogger) {
		super(nextLogger);
	}
	
	public void handleLog(String message) {
		System.out.println("Info: "+message);
	}
}
