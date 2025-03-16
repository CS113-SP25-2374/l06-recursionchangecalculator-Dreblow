package edu.miracosta.cs113.change;

import java.util.ArrayList;
import java.util.List;

public class ChangeCalculatorLinear extends ChangeCalculator {
    private static double executionTime;

    public static List<String> calculateLinear(int cents) {
        long startTime = System.nanoTime();  // Start timer
        List<String> combinations = new ArrayList<>();

        // Iterate over the number of quarters
        for (int q = 0; q <= cents / COINS[Quarter]; q++) {
            // Iterate over the number of dimes
            for (int d = 0; d <= (cents - q * COINS[Quarter]) / COINS[Dime]; d++) {
                // Iterate over the number of nickels
                for (int n = 0; n <= (cents - q * COINS[Quarter] - d * COINS[Dime]) / COINS[Nickel]; n++) {
                    // Calculate the number of pennies
                    int p = cents - q * COINS[Quarter] - d * COINS[Dime] - n * COINS[Nickel];

                    // If the remaining amount is valid (i.e., a non-negative number of pennies)
                    if (p >= 0) {
                        String combination = combinationToString(q, d, n, p);
                        combinations.add(combination);
                    }
                }
            }
        }

        long endTime = System.nanoTime();  // End timer
        executionTime = (endTime - startTime) / 1_000_000.0;
        return combinations;
    }

    public static String getTestTime () {
        return "Linear: Execution time: " + executionTime + " ms";
    }
}
