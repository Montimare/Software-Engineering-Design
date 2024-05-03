import java.util.HashMap;
import java.util.Map;

public class GPTOptimizedUlam {
    public static void main(String[] args) {
        final int end = 100000;
        Map<Integer, Integer> stepsMap = new HashMap<>();

        // Calculate steps for each number and store in the map
        for (int i = 1; i <= end; i++) {
            int steps = calculateSteps(i, stepsMap);
            stepsMap.put(i, steps);
        }

        // Print the results
        for (int i = 1; i <= end; i++) {
            System.out.println("Number " + i + " took " + stepsMap.get(i) + " steps.");
        }
    }

    private static int calculateSteps(int n, Map<Integer, Integer> stepsMap) {
        if (stepsMap.containsKey(n)) {
            return stepsMap.get(n);
        }

        int steps = 0;
        while (n!= 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = (n * 3) + 1;
            }
            steps++;
        }

        stepsMap.put(n, steps); // Store the result in the map
        return steps;
    }
}
