package Logger;

public abstract class Logger {
	public static int INFO=1;
	public static int DEBUG=2;
	public static int ERROR=3;
    public Logger nextLogger;
    
    public Logger(Logger nextLogger) {
    	this.nextLogger=nextLogger;
    }
    public void logMessage(int logLevel,String message) {
    	if(nextLogger!=null) {
    		nextLogger.logMessage(logLevel, message);
    	}
    	else {
    		handleLog(message);
    	}
    }
    
    protected abstract void handleLog(String message);
}
