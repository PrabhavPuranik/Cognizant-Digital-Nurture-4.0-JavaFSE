package Week_1.Design_Patterns;

public class Logger {

    private String logLevel;

    private Logger() {}

    private static class LoggerHolder {
        private static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance(){
        return LoggerHolder.INSTANCE;
    }

     public void setLogLevel(String level) {
        this.logLevel = level;
    }

    public String getLogLevel() {
        return logLevel;
    }
}
