package com.lordbritishix.coursera.week3.fractionalknapsack;

import java.util.Arrays;
import java.util.Scanner;

/**
 * The goal of this code problem is to implement an algorithm for the fractional knapsack problem.
 */
public class FractionalKnapsack {
    public static class KnapsackItem implements Comparable {
        private final int value;
        private final int weight;
        private final double perUnitValue;

        public KnapsackItem(int value, int weight) {
            this.value = value;
            this.weight = weight;

            this.perUnitValue = (double) value  / weight;
        }

        public int getValue() {
            return value;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return "per unit value: " + perUnitValue + " value: " + value + " weight: " + weight;
        }

        public double getPerUnitValue() {
            return perUnitValue;
        }

        @Override
        public int compareTo(Object other) {
            if (!(other instanceof KnapsackItem)) {
                throw new IllegalArgumentException("Cannot compare class that is not a KnapsackItem");
            }

            KnapsackItem that = (KnapsackItem) other;

            return Double.compare(that.getPerUnitValue(), this.getPerUnitValue());
        }
    }

    public double getOptimalValue(int capacity, KnapsackItem[] items) {
        double value = 0;

        Arrays.sort(items);

        int newCapacity = capacity;

        for (KnapsackItem item : items) {
            if (newCapacity <= 0) {
                break;
            }

            int tmp = newCapacity % item.getWeight();
            int partialWeight;

            if (tmp == newCapacity) {
                // if the item's weight is greater than the capacity, use the fraction of the items that will fit
                // the knapsack
                partialWeight = tmp;
            } else {
                // otherwise, use all of the items
                partialWeight = item.getWeight();
            }

            value += item.getPerUnitValue() * partialWeight;
            newCapacity -= partialWeight;
        }

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();

        KnapsackItem[] items = new KnapsackItem[n];
        for (int i = 0; i < n; i++) {
            items[i] = new KnapsackItem(scanner.nextInt(), scanner.nextInt());
        }

        FractionalKnapsack fractionalKnapsack = new FractionalKnapsack();
        System.out.println(fractionalKnapsack.getOptimalValue(capacity, items));
    }
} 
