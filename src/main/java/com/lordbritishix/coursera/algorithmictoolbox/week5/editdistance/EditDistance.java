package com.lordbritishix.coursera.algorithmictoolbox.week5.editdistance;

import java.util.Scanner;

class EditDistance {
    public int editDistance(String s, String t) {

        int i = s.length() + 1;
        int j = t.length() + 1;

        int[][] matrix = new int[i][j];

        for (int x = 0; x < i; ++x) {
            matrix[x][0] = x;
        }

        for (int x = 0; x < j; ++x) {
            matrix[0][x] = x;
        }

        for (int y = 1; y < j; ++y) {
            for (int x = 1; x < i; ++x) {
                int top = matrix[x][y - 1] + 1;
                int left = matrix[x - 1][y] + 1;
                int diag = matrix[x - 1][y - 1];
                diag = t.charAt(y - 1) == s.charAt(x - 1) ? diag : diag + 1;

                matrix[x][y] = min(top, left, diag);
            }
        }

        return matrix[s.length()][t.length()];
    }

    private int min(int x, int y, int z) {
        return Math.min(Math.min(x, y), z);
    }

    private void printMatrix(int[][] matrix, String s, String t) {
        System.out.println("s: " + s);
        System.out.println("t: " + t);

        for (int j = 0; j < t.length() + 1; ++j) {
            for (int i = 0; i < s.length() + 1; ++i) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        EditDistance editDistance = new EditDistance();
        System.out.println(editDistance.editDistance(s, t));
    }

}
