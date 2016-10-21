package com.lordbritishix.coursera.week3.summand;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Computes the max pair-wise sum of a number n
 *
 * Insight:
 * 1. let k = n, l = 1
 * 2. if k <= 2*l, output k, then it is complete
 * 3. if not, output l, then solve the subproblem k-l, l+1
 */
public class DifferentSummands {
    public List<Long> optimalSummands(long n) {
        List<Long> summands = new ArrayList<>();

        long k = n;
        long l = 1L;

        while (true) {
            if (!(k <= (2 * l))) {
                summands.add(l);
                k = k - l;
                l = l + 1L;
            } else {
                summands.add(k);
                break;
            }
        }

        return summands;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        DifferentSummands differentSummands = new DifferentSummands();
        List<Long> summands = differentSummands.optimalSummands(n);
        System.out.println(summands.size());
        for (Long summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

