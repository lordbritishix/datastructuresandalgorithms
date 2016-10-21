package com.lordbritishix.coursera.week3.largestnumber;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LargestNumber {
    public String largestNumber(Integer[] a) {
        String result = "";
        Arrays.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer perm1 = Integer.parseInt(o1.toString() + o2.toString());
                Integer perm2 = Integer.parseInt(o2.toString() + o1.toString());

                return Integer.compare(perm1, perm2);
            }
        });

        for (int i = a.length - 1; i >= 0; i--) {
            result += a[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        LargestNumber largestNumber = new LargestNumber();
        System.out.println(largestNumber.largestNumber(a));
    }
}

