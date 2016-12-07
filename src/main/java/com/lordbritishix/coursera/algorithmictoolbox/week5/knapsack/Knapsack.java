package com.lordbritishix.coursera.algorithmictoolbox.week5.knapsack;

import java.util.Scanner;

/**
 * Insights for dynamic programming:
 * <ol>
 *     <li>Solves all possible answers for a given combination of input</li>
 *     <li>Uses memoization to avoid recomputing previous results</li>
 * </ol>
 *
 * Great supplementary article about solving the non-fractional knapsack problem using DP
 * https://www.youtube.com/watch?v=8LusJS5-AGo&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr
 */
public class Knapsack {
    public int optimalWeight(int weight, int[] itemWeights) {
        int weightAxis = weight + 1;
        int itemsLengthAxis = itemWeights.length;

        // The matrix that stores all the possible optimal weight for the provided items
        int[][] matrix = new int[weightAxis][itemsLengthAxis];

        for (int j = 0; j < itemsLengthAxis; ++j) {
            int itemWeight = itemWeights[j];
            for (int k = 1; k < weightAxis; ++k) {
                int actualWeight;

                // Special case for when we are processing the first row, because j - 1 will lead into out of bounds exception
                if ((j - 1) < 0) {
                    actualWeight = itemWeight > k ? 0 : itemWeight;
                } else {
                    // The meat of the algorithm. Basically:
                    // 1. if k < itemWeight, use the result from [k][j - 1]
                    // 2. else, Math.max (the item's value + the remaining value if the item was added, value of [k][j - 1])
                    if (k < itemWeight) {
                        actualWeight = matrix[k][j - 1];
                    } else {
                        actualWeight = Math.max(itemWeight + matrix[k - itemWeight][j - 1], matrix[k][j - 1]);
                    }
                }

                matrix[k][j] = actualWeight;
            }
        }

        return matrix[weightAxis - 1][itemsLengthAxis - 1];
    }

    private void printMatrix(int[][] matrix, int weight, int itemCount) {
        for (int j = 0; j < itemCount; ++j) {
            for (int k = 0; k < weight; ++k) {
                System.out.print(matrix[k][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }

        Knapsack knapsack = new Knapsack();
        System.out.println(knapsack.optimalWeight(W, w));
    }
}

