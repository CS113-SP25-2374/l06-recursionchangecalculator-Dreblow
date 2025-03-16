package edu.miracosta.cs113.change;

import java.util.ArrayList;
import java.util.List;

/**
 * ChangeCalculator : Class containing the recursive method calculateChange, which determines and prints all
 * possible coin combinations representing a given monetary value in cents.
 *
 * Problem derived from Koffman & Wolfgang's Data Structures: Abstraction and Design Using Java (2nd ed.):
 * Ch. 5, Programming Project #7, pg. 291.
 *
 * NOTE: An additional method, printCombinationsToFile(int), has been added for the equivalent tester file to
 * verify that all given coin combinations are unique.
 */
public class ChangeCalculatorRecursive extends ChangeCalculator {
    private static double executionTime;

    /**
     * Wrapper method for determining all possible unique combinations of quarters, dimes, nickels, and pennies that
     * equal the given monetary value in cents
     *
     * @param cents a monetary value in cents
     * @return the total number of unique combinations of coins of which the given value is comprised
     */
    public static List<String> calculateRecursive(int cents) {
        long startTime = System.nanoTime();  // Start timer
        List<String> combinations = new ArrayList<>();

        calculateRecursiveHelper(cents, 0, 0, 0, 0, combinations, 25);

        long endTime = System.nanoTime();  // End timer
        executionTime = (endTime - startTime) / 1_000_000.0;
        return combinations;
    }

    private static void calculateRecursiveHelper(int cents, int quarters, int dimes, int nickels, int pennies, List<String> combinations, int maxCoin) {
        if (cents == 0) {
            combinations.add(combinationToString(quarters, dimes, nickels, pennies));
            return;
        }

        // Ensure coins are added in descending order to avoid duplicate permutations
        if (cents >= 25 && maxCoin >= 25) {
            calculateRecursiveHelper(cents - 25, quarters + 1, dimes, nickels, pennies, combinations, 25);
        }
        if (cents >= 10 && maxCoin >= 10) {
            calculateRecursiveHelper(cents - 10, quarters, dimes + 1, nickels, pennies, combinations, 10);
        }
        if (cents >= 5 && maxCoin >= 5) {
            calculateRecursiveHelper(cents - 5, quarters, dimes, nickels + 1, pennies, combinations, 5);
        }
        if (cents >= 1 && maxCoin >= 1) {
            calculateRecursiveHelper(cents - 1, quarters, dimes, nickels, pennies + 1, combinations, 1);
        }
    }

    public static String getTestTime () {
        return "Recursive: Execution time: " + executionTime + " ms";
    }
}