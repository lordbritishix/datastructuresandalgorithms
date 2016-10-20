package com.lordbritishix.coursera.week2.gcd;

import java.util.Scanner;

/**
 * GCD is the largest number that divides both a and b
 */
public class GCD {
    /**
     * GCD using naive method which tries to mod a and b from 2 to (a or b, whichever is greater). Performance is
     * O(n) where n is the greater number between a or b
     */
    int gcdNaive(int a, int b) {
        int current_gcd = 1;
        for (int d = 2; d <= a && d <= b; ++d) {
            if (a % d == 0 && b % d == 0) {
                if (d > current_gcd) {
                    current_gcd = d;
                }
            }
        }

        return current_gcd;
    }

    /**
     * Insight:
     *
     * GCD using euclidean method. If a' is the result of a % b, gcd can be computer recursively by: gcd = gcd(b, a')
     */
    int gadUsingEuclidean(int a, int b) {

        int newA = a;
        int newB = b;

        while (newB > 0) {
            int remainder = newA % newB;
            newA = newB;
            newB = remainder;
        }

        return newA;
    }


    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        GCD gcd = new GCD();

        System.out.println(gcd.gadUsingEuclidean(a, b));
    }
}
