package com.lordbritishix.coursera.algorithmictoolbox.week4.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class Sorting {
    private static Random random = new Random();

    /**
     * numbers before m1 are less than x
     * numbers after m2 are greater than x
     * numbers between m1 and m2 are equal to x
     */
    public int[] partition3(long[] a, int l, int r) {
        int m1 = l;
        int m2 = r;

        // this is the pivot
        long x = a[l];

        // skip the pivot
        int i = l + 1;

        while (i <= m2) {
            if (a[i] < x) {
                // if x < pivot, put it behind m1
                swap(a, m1, i);
                m1++;
                i++;
            } else if (a[i] > x) {
                // if x > pivot, move it behind m2
                swap(a, i, m2);
                m2--;
            } else {
                i++;
            }
        }

        return new int[]{m1, m2};
    }

    private void swap(long[] a, int i, int j) {
        if (i == j) {
            return;
        }

        long t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public int partition2(long[] a, int l, int r) {
        long x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                swap(a, i, j);
            }
        }
        swap(a, l, j);
        return j;
    }

    public void randomizedQuickSort(long[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        long t = a[l];
        a[l] = a[k];
        a[k] = t;

        //use partition3
        int[] m = partition3(a, l, r);
        randomizedQuickSort(a, l, m[0] - 1);
        randomizedQuickSort(a, m[1] + 1, r);

        // partition2
//        int m = partition2(a, l, r);
//        randomizedQuickSort(a, l, m - 1);
//        randomizedQuickSort(a, m + 1, r);

    }

    public void myQuickSort(long[] elements, int left, int right) {
        if (left >= right) {
            return;
        }

        int partition = partition(elements, left, right);

        myQuickSort(elements, left, partition - 1);
        myQuickSort(elements, partition + 1, right);
    }

    private int partition(long[] elements, int left, int right) {
        long partition = elements[left];
        int partitionIdx = left;

        for (int x = left + 1; x <= right; ++x) {
            if (partition > elements[x]) {
                partitionIdx++;
                swap(elements, partitionIdx, x);
            }
        }

        swap(elements, left, partitionIdx);

        return partitionIdx;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }

        Sorting sorting = new Sorting();
        sorting.randomizedQuickSort(a, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}

