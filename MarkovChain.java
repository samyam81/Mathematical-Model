import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MarkovChain {
    private Map<String, List<String>> transitionMap = new HashMap<>();
    private Random random = new Random();

    public void addTransition(String state, String nextState) {
        transitionMap.putIfAbsent(state, new ArrayList<>());
        transitionMap.get(state).add(nextState);
    }

    public String getNextState(String currentState) {
        List<String> possibleNextStates = transitionMap.get(currentState);
        if (possibleNextStates == null || possibleNextStates.isEmpty()) {
            return null;
        }
        int randomIndex = random.nextInt(possibleNextStates.size());
        return possibleNextStates.get(randomIndex);
    }

    public static void main(String[] args) {
        MarkovChain markovChain = new MarkovChain();

        // Define transitions
        markovChain.addTransition("Sunny", "Sunny");
        markovChain.addTransition("Sunny", "Cloudy");
        markovChain.addTransition("Sunny", "Rainy");
        markovChain.addTransition("Cloudy", "Sunny");
        markovChain.addTransition("Cloudy", "Cloudy");
        markovChain.addTransition("Cloudy", "Rainy");
        markovChain.addTransition("Rainy", "Sunny");
        markovChain.addTransition("Rainy", "Cloudy");
        markovChain.addTransition("Rainy", "Rainy");

        // Start state
        String currentState = "Sunny";

        // Generate sequence of states
        for (int i = 0; i < 9; i++) {
            System.out.print(currentState + " -> ");
            currentState = markovChain.getNextState(currentState);
        }
        System.out.print(currentState);
    }
}
