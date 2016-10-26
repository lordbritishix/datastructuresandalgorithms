package com.lordbritishix.coursera.algorithmictoolbox.week4.majorityelement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class MajorityElement {
    public long getMajorityElement(long[] a, int left, int right) {
        if (a.length <= 0) {
            return -1;
        }

        // down to one element
        if (left == right) {
            return a[left];
        }

        int mid = left + (right - left) / 2;

        //write your code here
        long leftMajority = getMajorityElement(a, left, mid);
        long rightMajority = getMajorityElement(a, mid + 1, right);

        if (isMajorityOnSubarray(a, left, right, leftMajority)) {
            return leftMajority;
        }

        if (isMajorityOnSubarray(a, left, right, rightMajority)) {
            return rightMajority;
        }

        return -1;
    }

    boolean isMajorityOnSubarray(long[] a, int left, int right, long val) {
        int count = 0;
        for (int x = left; x <= right; ++x) {
            if (val == a[x]) {
                count++;
            }
        }

        int div = ((right - left) + 1) / 2;
        return count > div;
    }

    public long getMajorityElementIterative(long[] a) {
        Map<Long, Long> elements = new HashMap<>();
        long maxSoFar = -1L;
        long idx = -1L;

        for (int x = 0; x < a.length; ++x) {
            if (!elements.containsKey(a[x])) {
                elements.put(a[x], 1L);
            } else {
                long count = elements.get(a[x]);
                elements.put(a[x], count + 1L);
            }

            if (maxSoFar < elements.get(a[x])) {
                maxSoFar = elements.get(a[x]);
                idx = a[x];
            }
        }

        return (maxSoFar > (a.length / 2)) ? idx : -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }

        MajorityElement majorityElement = new MajorityElement();

        if (majorityElement.getMajorityElement(a, 0, a.length - 1) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
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

