import java.util.Random;

public class PoissonDistribution {

    public static void main(String[] args) {
        Random random = new Random();

        // Generate random mean (λ) between 1 and 10
        int lambda = random.nextInt(10) + 1;

        // Generate random maximum value for x-axis 
        int maxRange = random.nextInt(11) + 10;

        System.out.println("Mean (λ) of the Poisson distribution: " + lambda);
        System.out.println("Maximum value for x-axis: " + maxRange);
        System.out.println("\n--- Poisson Distribution ---");
        System.out.println("X \t Probability");

        for (int x = 0; x <= maxRange; x++) {
            double probability = poissonProbability(lambda, x);
            System.out.printf("%d \t %.6f\n", x, probability);
        }
    }

    // Function to calculate Poisson probability
    private static double poissonProbability(int lambda, int x) {
        return (Math.pow(lambda, x) * Math.exp(-lambda)) / factorial(x);
    }

    private static int factorial(int n) {
        if (n == 0 || n == 1)
            return 1;
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
