package com.lordbritishix.coursera.algorithmictoolbox.week4.dotproduct;

import java.util.Scanner;

public class DotProduct {
    public static class Point {
        private final int x;
        private final int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public static Point of(int x, int y) {
            return new Point(x, y);
        }
    }

    public long minDotProduct(int[] a, int[] b) {
        //write your code here
        long result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }
        return result;
    }

    public double getClosestPairOfPoints(Point[] points) {
        return 0d;
    }

    public double getClosestPairOfPointsNaive(Point[] points) {
        double minDistance = Double.MAX_VALUE;
        for (int x = 0; x < points.length; ++x) {
            for (int y = x + 1; y < points.length; ++y) {
                double distance = getDistance(points[x], points[y]);

                if (distance < minDistance) {
                    minDistance = distance;
                }
            }
        }

        return minDistance;
    }

    private double getDistance(Point p1, Point p2) {
        double a = Math.pow(p1.x - p2.x, 2);
        double b = Math.pow(p1.y - p2.y, 2);
        return Math.sqrt(a + b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            Point point = Point.of(scanner.nextInt(), scanner.nextInt());
            points[i] = point;
        }

        DotProduct dotProduct = new DotProduct();
        System.out.println(dotProduct.getClosestPairOfPoints(points));
    }
}

