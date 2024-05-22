import java.util.*;

public class LotkaVolterraModel {
    // Parameters
    private double alpha;
    private double beta;
    private double delta;
    private double gamma;

    public LotkaVolterraModel(double alpha, double beta, double delta, double gamma) {
        this.alpha = alpha;
        this.beta = beta;
        this.delta = delta;
        this.gamma = gamma;
    }

    // Euler's method to solve the differential equations
    public Map<String, Float> euler(double x0, double y0, double dt, double time) {
        int steps = (int) (time / dt);
        Map<String, Float> result = new HashMap<>();
        float x = (float) x0;
        float y = (float) y0;
        for (int i = 0; i < steps; i++) {
            double dx = alpha * x - beta * x * y;
            double dy = delta * x * y - gamma * y;
            x = (float) (x + dx * dt);
            y = (float) (y + dy * dt);
        }
        result.put("Prey", x);
        result.put("Predator", y);
        return result;
    }

    public static void main(String[] args) {
        // Generate random initial population values for prey and predators as integers
        Random random = new Random();
        int x0 = random.nextInt(200) + 10; // initial prey population between 10 and 110
        int y0 = random.nextInt(50) + 5; // initial predator population between 5 and 25

        System.out.println("Initial prey population: " + x0);
        System.out.println("Initial predator population: " + y0);

        double alpha = 0.1;
        double beta = 0.02;
        double delta = 0.01;
        double gamma = 0.1;
        double dt = 0.01; // time step
        double time = 200; // total time

        LotkaVolterraModel model = new LotkaVolterraModel(alpha, beta, delta, gamma);
        Map<String, Float> result = model.euler(x0, y0, dt, time);

        System.out.println("Final prey and predator populations: ");
        for (Map.Entry<String, Float> entry : result.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
