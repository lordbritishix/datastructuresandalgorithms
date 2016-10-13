package com.lordbritishix.coursera.aplusb;

import java.util.Scanner;

class APlusB {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();

        APlusB aPlusB = new APlusB();

        System.out.println(aPlusB.add(a, b));
    }

    int add(int a, int b) {
        if ((a < 0) || (b < 0)) {
            throw new IllegalArgumentException("a and b must be >= 0");
        }

        if ((a > 9) || (b > 9)) {
            throw new IllegalArgumentException("a and b must be <= 9");
        }

        return a + b;
    }
}