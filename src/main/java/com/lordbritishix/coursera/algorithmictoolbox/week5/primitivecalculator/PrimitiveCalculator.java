package com.lordbritishix.coursera.algorithmictoolbox.week5.primitivecalculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * c[x] =
 *    min(
 *       c[x / 2] + 1,   //if x % 2 == 0
 *       c[x / 3] + 1,   //if x % 3 == 0
 *       c[x - 1] + 1
 *    )
 */
public class PrimitiveCalculator {
    private static final int INFINITY = Integer.MAX_VALUE;

    private static class Pair {
        int idx;
        int val;

        public static Pair of(int idx, int val) {
            Pair pair = new Pair();
            pair.idx = idx;
            pair.val = val;

            return pair;
        }
    }

    public List<Integer> optimalSequence(int n) {
        int[] nums = new int[n + 1];
        nums[0] = INFINITY;

        for (int x = 1; x < nums.length; ++x) {
            int nDiv2 = x % 2 == 0 ? nums[x / 2] + 1 : INFINITY;
            int nDiv3 = x % 3 == 0 ? nums[x / 3] + 1 : INFINITY;
            int nLess1 = nums[x - 1] == Integer.MAX_VALUE ? INFINITY : nums[x - 1] + 1;

            nums[x] = min(nDiv2, nDiv3, nLess1);
        }

        int idx = nums.length - 1;
        List<Integer> sequence = new ArrayList<>();
        sequence.add(idx);

        // back-tracking
        while (idx > 0) {
            int nDiv2 = idx % 2 == 0 ? nums[idx / 2] : INFINITY;
            int nDiv3 = idx % 3 == 0 ? nums[idx / 3] : INFINITY;
            int nLess1 = nums[idx - 1];

            Pair nDiv2Pair = Pair.of(idx / 2, nDiv2);
            Pair nDiv3Pair = Pair.of(idx / 3, nDiv3);
            Pair nLess1Pair = Pair.of(idx - 1, nLess1);

            Pair minPair = min(nLess1Pair, min(nDiv2Pair, nDiv3Pair));
            idx = minPair.idx;

            if (idx > 0) {
                sequence.add(idx);
            }
        }

        Collections.sort(sequence);
        return sequence;
    }

    private Pair min(Pair first, Pair second) {
        if (first.val < second.val) {
            return first;
        } else {
            return second;
        }
    }


    private int min(int first, int second, int third) {
        int val = Math.min(Math.min(first, second), third);

        if (val == Integer.MAX_VALUE) {
            return 0;
        }

        return val;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        PrimitiveCalculator calculator = new PrimitiveCalculator();

        List<Integer> sequence = calculator.optimalSequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

