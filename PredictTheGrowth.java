import java.util.Random;

public class PredictTheGrowth {
    public static void main(String[] args) {
        // Generate random parameters
        Random random = new Random();
        double r = random.nextDouble() * 0.5; // growth rate between 0 and 0.5
        double K = random.nextDouble() * 2000.0; // carrying capacity between 0 and 2000
        double N0 = random.nextDouble() * 100.0; // initial population size between 0 and 100
        double dt = random.nextDouble() * 0.5; // time step between 0 and 0.5
        double simulationTime = random.nextDouble() * 500.0; // total simulation time between 0 and 500

        simulatePopulationGrowth(r, K, N0, dt, simulationTime);
    }

    public static void simulatePopulationGrowth(double r, double K, double N0, double dt, double simulationTime) {
        int steps = (int) (simulationTime / dt) + 1;
        double[] time = new double[steps];
        double[] population = new double[steps];
        time[0] = 0.0;
        population[0] = N0;

        for (int i = 1; i < steps; i++) {
            double dNdt = r * population[i - 1] * (1 - population[i - 1] / K);
            population[i] = population[i - 1] + dNdt * dt;
            time[i] = time[i - 1] + dt;
        }

        plotResults(time, population);
    }

    public static void plotResults(double[] time, double[] population) {
        System.out.println("Time | Population Size");
        for (int i = 0; i < time.length; i++) {
            System.out.printf("%.2f | %.2f\n", Math.round(time[i] * 100.0) / 100.0,
                    Math.round(population[i] * 100.0) / 100.0);
        }
    }
}
