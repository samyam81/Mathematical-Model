import java.text.DecimalFormat;
import java.util.Random;

public class BlackScholes {

    public static double blackScholesCall(double s, double x, double r, double t, double v) {
        double d1 = (Math.log(s / x) + (r + v * v / 2) * t) / (v * Math.sqrt(t));
        double d2 = d1 - v * Math.sqrt(t);

        return s * normalDistribution(d1) - x * Math.exp(-r * t) * normalDistribution(d2);
    }

    private static double normalDistribution(double x) {
        return Math.exp(-x * x / 2) / Math.sqrt(2 * Math.PI);
    }

    public static double roundToFiveSignificantDigits(double value) {
        DecimalFormat df = new DecimalFormat("#.#####");
        return Double.parseDouble(df.format(value));
    }

    public static void main(String[] args) {
        Random random = new Random();

        // Generate random data rounded to five significant digits
        double stockPrice = roundToFiveSignificantDigits(80 + random.nextDouble() * 40); // Random stock price between
                                                                                         // 80 and 120
        double strikePrice = roundToFiveSignificantDigits(70 + random.nextDouble() * 60); // Random strike price between
                                                                                          // 70 and 130
        double riskFreeRate = roundToFiveSignificantDigits(0.01 + random.nextDouble() * 0.1); // Random risk-free rate
                                                                                              // between 1% and 10%
        double timeToExpiration = roundToFiveSignificantDigits(0.1 + random.nextDouble() * 2.9); // Random time to
                                                                                                 // expiration between
                                                                                                 // 0.1 and 3 years
        double volatility = roundToFiveSignificantDigits(0.1 + random.nextDouble() * 0.5); // Random volatility between
                                                                                           // 10% and 60%

        double callPrice = blackScholesCall(stockPrice, strikePrice, riskFreeRate, timeToExpiration, volatility);

        System.out.println("Random Data:");
        System.out.println("Stock Price: " + stockPrice);
        System.out.println("Strike Price: " + strikePrice);
        System.out.println("Risk-free Rate: " + riskFreeRate);
        System.out.println("Time to Expiration: " + timeToExpiration);
        System.out.println("Volatility: " + volatility);
        System.out.println();

        System.out.println("European Call Option Price: " + callPrice);
    
    }
}
