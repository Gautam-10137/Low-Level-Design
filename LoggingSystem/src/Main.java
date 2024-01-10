import Logger.Logger;
import Logger.Info;
import Logger.Debug;
import Logger.Error;

public class Main {

	public static void main(String[] args) {
		Logger logger1=new Info(new Debug(new Error(null)));
		
		logger1.logMessage(Logger.DEBUG, "Debugging the error");
		logger1.logMessage(Logger.INFO, "Info the record");
		logger1.logMessage(Logger.ERROR, "Error in program.");

	}

}
