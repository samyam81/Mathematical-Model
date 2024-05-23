import java.util.Random;

public class GaussianDistribution {
    public static void main(String[] args) {
        // The bell Curve...
        double mean = 0; 
        double stdDev = 1; 

        Random random = new Random();
        
        System.out.println("Random numbers following Gaussian distribution:");
        for (int i = 0; i < 10; i++) {
            double randomNumber = mean + stdDev * random.nextGaussian();
            System.out.println(randomNumber);
        }
    }
}

// The random.nextGaussian() method generates random numbers from a Gaussian
// (Normal) distribution with a mean of 0 and a standard deviation of 1.
