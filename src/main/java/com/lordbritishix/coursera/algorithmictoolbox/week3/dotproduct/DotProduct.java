package com.lordbritishix.coursera.algorithmictoolbox.week3.dotproduct;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Compute the dot product, nothing special
 */
public class DotProduct {
    public long maxDotProduct(long[] a, long[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        long result = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            result += a[i] * b[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextLong();
        }

        DotProduct dotProduct = new DotProduct();

        System.out.println(dotProduct.maxDotProduct(a, b));
    }
}

