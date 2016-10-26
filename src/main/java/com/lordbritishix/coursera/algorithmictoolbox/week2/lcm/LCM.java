package com.lordbritishix.coursera.algorithmictoolbox.week2.lcm;

import java.util.Scanner;

/**
 * LCM is the smallest number that's divisible by both a and b
 */
public class LCM {
    /**
     * Very slow method for computing lcm. It works by looping from 1 - a * b and checking if l % a and l % b
     * is both equal to zero.
     */
    long lcmNaive(int a, int b) {
        for (long l = 1; l <= (long) a * b; ++l) {
            if (l % a == 0 && l % b == 0) {
                return l;
            }
        }

        return (long) a * b;
    }

    /**
     * Insight:
     *
     * if lcm(a, b) * gcd(a, b) = a * b
     * then, lcm(a, b) = (a * b) / gcd(a, b)
     */
    long lcmFast(int a, int b) {
        int newA = a;
        int newB = b;

        // compute gcd, it will be in newA
        while (newB > 0) {
            int remainder = newA % newB;
            newA = newB;
            newB = remainder;
        }

        // compute lcm
        return (long) a * b / newA;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        LCM lcm = new LCM();

        System.out.println(lcm.lcmFast(a, b));
    }
}
