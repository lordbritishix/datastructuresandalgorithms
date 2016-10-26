package com.lordbritishix.coursera.algorithmictoolbox.week2.fibonacci;

import java.util.Scanner;

/**
 * This computes the fib(n) mod m where n can be up to 10^18.
 * <p>
 * Insights:
 * It takes advantage of the fact that the output of fib(n) mod m
 * produces a periodic sequence of numbers called the pisano. By getting the pisano, we can just compute fib(pisano-length) mod m
 * which should be a number that's a lot smaller than fib(n) mod m.
 * <p>
 * We can also take advantage of the following property of mod:
 * (a + b) mod m =( (a mod m) + (b mod m) ) mod m
 * to store only a mod m and b mod m when computing the fib so that it can handle really big numbers
 */
public class FibonacciHuge {
    private long getFibonacciModXHugeNaive(long n, long m) {
        if (n <= 1) {
            return n;
        }

        long previous = 0L;
        long current = 1L;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous % m;
            previous = current % m;
            current = (tmp_previous + current) % m;
        }

        return current;
    }

    /**
     * Gets the pisano and then computes fib(pisano length) mod m
     */
    long getFibonacciModXHugePisano(long n, long m) {
        if (n <= 1) {
            return n;
        }

        long pisano = getPisano(n, m);
        long remainder;

        if (pisano == -1L) {
            remainder = n;
        } else {
            remainder = n % pisano;
        }

        return getFibonacciModXHugeNaive(remainder, m);
    }

    /**
     * Gets the length of the sequence segment before it repeats (pisano). Pisano sequence starts with 0, 1 and so once
     * we find those, we can find out the length of the sequence segment.
     */
    long getPisano(long n, long m) {
        if (m <= 1) {
            throw new IllegalArgumentException("n must be >= 2");
        }

        long previous = 0L;
        long current = 1L;

        for (long i = 0; i < n - 1; ++i) {
            // because the input can be really really big and we are only interested in fib(n) mod m, take advantage of the mod
            // distributed properties: (a + b) mod m =( (a mod m) + (b mod m) ) mod m
            long tmp_previous = previous % m;
            previous = current % m;
            current = (tmp_previous + current) % m;

            // We found the end of the sequence, so break the loop
            if (previous == 0L && current == 1L) {
                return i + 1;
            }
        }

        return -1L;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();

        FibonacciHuge fibonacciHuge = new FibonacciHuge();

        System.out.println(fibonacciHuge.getFibonacciModXHugePisano(n, m));
    }
}

