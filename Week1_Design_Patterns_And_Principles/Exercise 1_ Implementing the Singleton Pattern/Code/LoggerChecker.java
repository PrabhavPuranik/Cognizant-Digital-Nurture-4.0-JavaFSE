package Week_1.Design_Patterns;

public class LoggerChecker {

    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.setLogLevel("DEBUG");

        System.out.println("=========== Singleton Logger Test ===========");

        if(logger1 == logger2){
            System.out.println("Logger is a Singleton!");
        }
        else{
            System.out.println("Logger is not a Singleton!");
        }

        System.out.println("\nLog Level of logger1 : " + logger1.getLogLevel());
        System.out.println("Log Level of logger2 : " + logger2.getLogLevel());

        System.out.println("\nResult: Both logger1 and logger2 refer to the same singleton instance.");

        System.out.println("=============================================");
    }
}
