public class BayesianInferenceSimulation {
    public static void main(String[] args) {
        // Prior probabilities
        double pW = 0.5; // Prior probability of grass being wet
        double pR = 0.2; // Prior probability of rain
        double pS = 0.3; // Prior probability of sprinkler

        // Conditional probabilities
        double pWGivenR = 0.9; // P(W|R): Probability of wet grass given rain
        double pWGivenNR = 0.2; // P(W|¬R): Probability of wet grass given no rain
        double pWGivenS = 0.8; // P(W|S): Probability of wet grass given sprinkler
        double pWGivenNS = 0.1; // P(W|¬S): Probability of wet grass given no sprinkler

        // Observation: It rained and the sprinkler was on
        boolean r = true;
        boolean s = true;

        // Update beliefs using Bayesian inference
        double pWPosterior = calculatePosteriorProbability(pW, pR, pS,
                pWGivenR, pWGivenNR, pWGivenS, pWGivenNS,
                r, s);

        // Output the final posterior probability
        System.out.println("Final posterior probability of grass being wet: " + pWPosterior);
    }

    // Function to calculate the posterior probability using Bayesian inference
    private static double calculatePosteriorProbability(double pW, double pR, double pS,
            double pWGivenR, double pWGivenNR, double pWGivenS, double pWGivenNS,
            boolean r, boolean s) {
        // Calculate the joint probability of wet grass, rain, and sprinkler
        double jointP = pW * (r ? pR : (1 - pR)) * (s ? pS : (1 - pS));

        // Calculate the marginal probability of rain and sprinkler
        double marginalP = (r ? pR : (1 - pR)) * (s ? pS : (1 - pS));

        // Calculate the conditional probability of wet grass given rain and sprinkler
        @SuppressWarnings("unused")
        double condP = (pWGivenR * pWGivenS);

        // Calculate the conditional probability of wet grass given no rain and
        // sprinkler
        double condPNS = (pWGivenNR * pWGivenS);

        // Calculate the posterior probability of wet grass using the joint and marginal
        // probabilities
        double pWPosterior = (jointP / marginalP) / ((jointP / marginalP) + (condPNS * (1 - jointP / marginalP)));

        return pWPosterior;
    }
}
