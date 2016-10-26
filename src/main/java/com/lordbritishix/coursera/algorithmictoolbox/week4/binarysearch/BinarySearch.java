package com.lordbritishix.coursera.algorithmictoolbox.week4.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BinarySearch {
    int binarySearch(long[] a, long x) {
        int left = 0, right = a.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (x < a[mid]) {
                // left partition
                right = mid - 1;
            } else if (x > a[mid]) {
                // right partition
                left = mid + 1;
            } else {
                // found it
                return mid;
            }
        }

        return -1;
    }

    int linearSearch(long[] a, long x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        int m = scanner.nextInt();
        long[] b = new long[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextLong();
        }

        BinarySearch binarySearch = new BinarySearch();

        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(binarySearch.binarySearch(a, b[i]) + " ");
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
