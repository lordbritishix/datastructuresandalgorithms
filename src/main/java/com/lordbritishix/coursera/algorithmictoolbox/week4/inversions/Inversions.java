package com.lordbritishix.coursera.algorithmictoolbox.week4.inversions;

import java.util.Scanner;

public class Inversions {
    public long mergeSort(long[] a) {
        long[] buffer = new long[a.length];

        return doMergeSort(a, buffer, 0, a.length - 1);
    }

    long doMergeSort(long[] a, long[] b, int left, int right) {
        if (left >= right) {
            return 0L;
        }

        long numberOfInversions = 0;

        int mid = getMid(left, right);

        numberOfInversions += doMergeSort(a, b, left, mid);
        numberOfInversions += doMergeSort(a, b, mid + 1, right);

        numberOfInversions += doMerge(a, b, left, right, mid);

        return numberOfInversions;
    }

    /**
     * @param a     array to be sorted
     * @param b     buffer where array is temporarily sorted
     * @param left  index where the left subarray starts
     * @param mid   index where the left subarray ends
     * @param right index where the right subarray ends
     * @return
     */
    long doMerge(long[] a, long[] b, int left, int right, int mid) {
        long inversionCount = 0L;

        //i is the ptr to the left subarray
        int i = left;

        //j is the ptr to the right subarray
        int j = mid + 1;

        // do merge sort on temporary buffer
        copy(a, b, left, right);

        for (int x = left; x <= right; ++x) {
            if (j > right) {
                // if all of the right subarray has been exhausted, just copy all of the left subarray
                b[x] = a[i];
                i++;
            } else if (i > mid) {
                // if all of the left subarray has been exhausted, just copy all of the right subarray
                b[x] = a[j];
                j++;
            } else if (a[i] <= a[j]) {
                // merge element from left subarray
                b[x] = a[i];
                i++;
            } else if (a[i] > a[j]) {
                // to count the number of inversions, if the left subarray's element is greater than the right subarray's
                // element, then the remaining elements of the left subarray must also be greater than the right subarray's
                // element
                inversionCount += (mid + 1) - i;

                // merge element from right subarray
                b[x] = a[j];
                j++;
            }
        }

        // copy sorted elements back to original buffer
        copy(b, a, left, right);

        return inversionCount;
    }

    private void copy(long[] from, long[] to, int left, int right) {
        for (int x = left; x <= right; ++x) {
            to[x] = from[x];
        }
    }

    private int getMid(int left, int right) {
        return left + (right - left) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Inversions inversions = new Inversions();
        System.out.println(inversions.mergeSort(a));
    }
}

