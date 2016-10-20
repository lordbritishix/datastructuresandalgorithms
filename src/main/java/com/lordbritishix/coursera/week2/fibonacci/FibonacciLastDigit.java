package com.lordbritishix.coursera.week2.fibonacci;

import java.util.Scanner;

/**
 * Gets the last digit of fib(n) - i.e. fib(n) % 10
 */
public class FibonacciLastDigit {
    int getFibonacciLastDigitUsingNaive(int n) {
        if (n <= 1) {
            return n;
        }

        int previous = 0;
        int current = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % 10;
    }

    int getFibonacciLastDigitFast(int n) {
        if (n <= 1) {
            return n;
        }

        // Insights:
        // n % 10 can be used to get the last digit of n.
        // we only want the last digit, so just store 2 numbers in memory - which are previous and current. Also,
        // we can just store the last digit for previous and current so that it can handle really big numbers.
        int previous = 0;
        int current = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % 10;
        }

        return current % 10;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FibonacciLastDigit fibonacciLastDigit = new FibonacciLastDigit();

        int n = scanner.nextInt();
        int c = fibonacciLastDigit.getFibonacciLastDigitFast(n);
        System.out.println(c);
    }
}

