package com.lordbritishix.coursera.week1.maxpairwiseproduct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * This class computes the maximum product of 2 integers in a given array of integers.
 */
public class MaxPairwiseProduct {
    /**
     * Algorithm:
     * Compute the product of all the pair combination defined in the number array and keep track of the highest result.
     * Complexity: n^2
     */
    long getMaxPairwiseProductSlow(int[] numbers) {
        long result = 0L;
        int n = numbers.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                long tmpProduct = (long)numbers[i] * numbers[j];
                if (tmpProduct > result) {
                    result = tmpProduct;
                }
            }
        }
        return result;
    }

    /**
     * Algorithm:
     * Finds the top 2 max numbers from the array of integers and compute the product of those.
     * Complexity: 2n
     */
    long getMaxPariwiseProductFast(int[] numbers) {
        if (numbers.length < 2) {
            throw new IllegalArgumentException("input must have at least 2 elements");
        }

        int idxOfFirstLargest = 0;

        // Find the 1st digit
        for (int x = 0; x < numbers.length; ++x) {
            if (numbers[x] > numbers[idxOfFirstLargest]) {
                idxOfFirstLargest = x;
            }
        }

        int idxOfSecondLargest = -1;

        // Find the 2nd digit
        for (int x = 0; x < numbers.length; ++x) {
            // don't include the 1st digit that was found previously
            if ((idxOfSecondLargest <= -1) && (x != idxOfFirstLargest)) {
                idxOfSecondLargest = x;
                continue;
            }

            if (x == idxOfFirstLargest) {
                continue;
            }

            if (numbers[x] > numbers[idxOfSecondLargest]) {
                idxOfSecondLargest = x;
            }
        }

        return (long) numbers[idxOfFirstLargest] * numbers[idxOfSecondLargest];
    }

    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        MaxPairwiseProduct maxPairwiseProduct = new MaxPairwiseProduct();
        System.out.println(maxPairwiseProduct.getMaxPariwiseProductFast(numbers));
    }

    private static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

}