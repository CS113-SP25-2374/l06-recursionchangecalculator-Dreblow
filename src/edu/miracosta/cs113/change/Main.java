package edu.miracosta.cs113.change;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] testAmounts = { 1, 5, 25, 43 };

        for (int i = 0; i < testAmounts.length; i++) {
            List<String> recursiveResult = ChangeCalculatorRecursive.calculateRecursive(testAmounts[i]);
            List<String> linearResult = ChangeCalculatorLinear.calculateLinear(testAmounts[i]);

            System.out.println(" ");
            System.out.println("Testing amount " + testAmounts[i] + ": ");

            for (String result : recursiveResult) {
                System.out.println(result);
            }

            for (String result : linearResult) {
                if (!recursiveResult.contains(result)) {
                    System.out.println("Missing: " + result);
                }
            }

            System.out.println("Total Results: " + recursiveResult.size() + "/" + linearResult.size());
            System.out.println(ChangeCalculatorLinear.getTestTime());
            System.out.println(ChangeCalculatorRecursive.getTestTime());
        }

        System.out.println("Jobs done!");
    }
}