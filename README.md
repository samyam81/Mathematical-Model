## Mathematical-Model.

# Population Growth Simulator

This Java program simulates population growth using the logistic growth model and the Lotka-Volterra model. It generates random parameters for the growth models and simulates the growth over a specified period of time.

## Getting Started

To run the simulation, simply execute the `PredictTheGrowth.java` file in your Java environment. Ensure you have Java installed on your system.

```bash
javac PredictTheGrowth.java
java PredictTheGrowth
```

## Overview

The program randomly generates parameters for two types of growth models:

### Logistic Growth Model
- Growth rate (r): Between 0 and 0.5
- Carrying capacity (K): Between 0 and 2000
- Initial population size (N0): Between 0 and 100
- Time step (dt): Between 0 and 0.5
- Total simulation time: Between 0 and 500

It then simulates population growth using the logistic growth equation:

```
dN/dt = r * N * (1 - N / K)
```

### Lotka-Volterra Model
- Prey birth rate (alpha): Between 0 and 0.5
- Predation rate coefficient (beta): Between 0 and 0.5
- Predator-prey interaction rate (delta): Between 0 and 0.5
- Predator death rate (gamma): Between 0 and 0.5

It then simulates population dynamics using the Lotka-Volterra equations:

```
dx/dt = alpha * x - beta * x * y
dy/dt = delta * x * y - gamma * y
```

## Bayesian Inference Simulation

This Java program implements Bayesian inference to update beliefs about the probability of grass being wet given observations about rain and sprinkler activity. Here's how it works:

- Prior probabilities (`pW`, `pR`, `pS`): These represent the initial beliefs about the probability of the grass being wet, the probability of rain, and the probability of the sprinkler being on, respectively.
- Conditional probabilities (`pWGivenR`, `pWGivenNR`, `pWGivenS`, `pWGivenNS`): These represent the likelihood of observing wet grass given different combinations of rain and sprinkler activity.
- Observation (`r`, `s`): These are boolean variables representing whether it rained (`r`) and whether the sprinkler was on (`s`).
- The `calculatePosteriorProbability` function uses Bayesian inference to update the prior beliefs based on the observed data.
- Finally, the program outputs the final posterior probability of the grass being wet given the observations.

## Black-Scholes

This Java program calculates the price of a European call option using the Black-Scholes model. Here's how it works:

- The `blackScholesCall` function implements the Black-Scholes formula for pricing a call option.
- It takes parameters such as the current stock price (`s`), the strike price (`x`), the risk-free interest rate (`r`), the time to expiration (`t`), and the volatility (`v`).
- Inside the `main` function, random values are generated for these parameters within certain ranges.
- The `roundToFiveSignificantDigits` function rounds a given value to five significant digits.
- Using the generated random data, the program calculates the price of a European call option using the Black-Scholes formula and outputs the result.

## Output

The simulation results are printed to the console, displaying the population size at each time step for both growth models. Additionally, a plot of the results can be implemented using appropriate plotting libraries.

## File Structure

- `PredictTheGrowth.java`: Contains the Java code for the population growth simulation.
- `BayesianInferenceSimulation.java`: Contains the Java code for the Bayesian inference simulation.
- `BlackScholes.java`: Contains the Java code for the Black-Scholes option pricing.

## Author

This program was created by Samyam.81[https://github.com/samyam81].
