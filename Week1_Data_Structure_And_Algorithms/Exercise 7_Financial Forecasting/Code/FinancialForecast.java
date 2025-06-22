package Week_1.Data_Structure.Financial_Forecasting;
import java.util.Scanner;

public class FinancialForecast {
    public static double calculateFutureValue(double presentValue, double rate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return (1 + rate) * calculateFutureValue(presentValue, rate, years - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=======Financial Forecast=======");

        System.out.print("Enter the present value: ");
        double presentValue = scanner.nextDouble();

        System.out.print("Enter the annual growth rate (as %): ");
        double ratePercent = scanner.nextDouble();
        double annualRate = ratePercent / 100.0;

        System.out.print("Enter the number of years: ");
        int years = scanner.nextInt();

        double futureValue = calculateFutureValue(presentValue, annualRate, years);

        System.out.printf("Future value after %d years: %.2f\n", years, futureValue);

        scanner.close();
    }
}
