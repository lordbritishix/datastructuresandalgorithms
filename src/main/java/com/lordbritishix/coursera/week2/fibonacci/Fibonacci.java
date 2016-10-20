package com.lordbritishix.coursera.week2.fibonacci;

import java.util.Scanner;

/**
 * Computes the fibonacci sequence
 */
public class Fibonacci {
    /**
     * Really fast way of computing fibonacci by using memoization. n-2 and n-1 are fetched from memory so no need
     * to recompute them
     */
    long getFibonacciUsingMemoization(int n) {
        if (n <= 1) {
            return n;
        }

        int capacity = n + 1;

        int[] i = new int[capacity];
        i[0] = 0;
        i[1] = 1;

        for (int x = 2; x < capacity; ++x) {
            i[x] = i[x - 1] + i[x - 2];
        }

        return i[capacity - 1];
    }

    /**
     * Classic way of computing fibonacci using recursion. n-2 and n-1 are computed recursively.
     */
    long getFibonacciUsingRecusion(int n) {
        if (n <= 1) {
            return n;
        }

        return getFibonacciUsingRecusion(n - 1) + getFibonacciUsingRecusion(n - 2);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Fibonacci fibonacci = new Fibonacci();

        System.out.println(fibonacci.getFibonacciUsingMemoization(n));
    }
}
