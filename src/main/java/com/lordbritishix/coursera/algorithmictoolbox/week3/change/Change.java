package com.lordbritishix.coursera.algorithmictoolbox.week3.change;

import java.util.Scanner;

/**
 * The goal in this problem is to find the minimum number of coins needed to change the input value
 * (an integer) into coins with denominations 1, 5, and 10. Assumes that m is sorted in descending order.
 * Greedy algorithm:
 * <ol>
 *     <li>Take the biggest number in the array and divide m by that</li>
 *     <li>Set m to the remainder</li>
 *     <li>Repeat step 1, but use the next biggest number in the array</li>
 *     <li>When m is 0, then it is complete</li>
 * </ol>
 */
public class Change {
    public int getChange(int[] denominations, int m) {
        int count = 0;
        int newM = m;

        for (int denomination : denominations) {
            int wholePart = newM / denomination;

            if (wholePart > 0) {
                count += wholePart;
                newM = newM % denomination;

            }

            if (newM <= 0) {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();

        Change change = new Change();

        int[] changes = new int[]{10, 5, 1};
        System.out.println(change.getChange(changes, m));

    }
}

