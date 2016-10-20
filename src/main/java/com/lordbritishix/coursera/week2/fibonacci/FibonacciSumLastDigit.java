package com.lordbritishix.coursera.week2.fibonacci;

import java.util.Scanner;

/**
 * This class does the following:
 * 1. Compute the sum of fib(n) from fib(0) to fib(n)
 * 2. Get the last number of n
 *
 * Insight:
 * This builds on the fact that the pisano of fib(n) % 10 is 60 - so we only need to calculate up to fib(60) to know
 * the last number of the sum of any fib(n). Hence, any fib(n) == fib(n % 60)
 */
public class FibonacciSumLastDigit {
    private static final int PISANO_LENGTH_FOR_MOD_10 = 60;

    private long getFibonacciSumNaive(long n) {
        if (n <= 1) {
            return n;
        }

        long previous = 0;
        long current = 1;
        long sum = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous % 10;
            previous = current % 10;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }

    long getFibonacciSumFast(long n) {
        if (n <= 1) {
            return n;
        }

        return getFibonacciSumNaive(n % PISANO_LENGTH_FOR_MOD_10);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();

        FibonacciSumLastDigit fibonacciSumLastDigit = new FibonacciSumLastDigit();

        long s = fibonacciSumLastDigit.getFibonacciSumFast(n);
        System.out.println(s);
    }
}

