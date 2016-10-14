package com.lordbritishix.coursera.fibonacci;

import java.util.*;

/**
 * This class computes the sum the fib numbers between fib(from) and fib(to) and then returns the last digit.
 * This builds on a similar solution found in {@link FibonacciSumLastDigit}
 */
public class FibonacciPartialSum {
    private static final int PISANO_LENGTH_FOR_MOD_10 = 60;

    private long getFibonacciPartialSumNaive(long from, long to) {
        if (to <= 1) {
            return to;
        }

        long previous = 0;
        long current = 1;

        for (long i = 0; i < from - 1; ++i) {
            long tmp_previous = previous % 10;
            previous = current % 10;
            current = tmp_previous + current;
        }

        long sum = current;

        for (long i = 0; i < to - from; ++i) {
            long tmp_previous = previous % 10;
            previous = current % 10;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }

    long getFibonacciPartialSumFast(long from, long to) {
        if (from > to) {
            throw new IllegalArgumentException("to must be <= from");
        }

        return getFibonacciPartialSumNaive(from % PISANO_LENGTH_FOR_MOD_10, to % PISANO_LENGTH_FOR_MOD_10);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();

        FibonacciPartialSum fibonacciPartialSum = new FibonacciPartialSum();
        System.out.println(fibonacciPartialSum.getFibonacciPartialSumFast(from, to));
    }
}

