package com.lordbritishix.coursera.algorithmictoolbox.week3.fractionalknapsack;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FractionalKnapsackTest {
    private final FractionalKnapsack.KnapsackItem[] items;
    private final int weight;
    private final double maximalValue;
    private final FractionalKnapsack fixture;

    public FractionalKnapsackTest(FractionalKnapsack.KnapsackItem[] items, int weight, double maximalValue) {
        this.fixture = new FractionalKnapsack();
        this.weight = weight;
        this.maximalValue = maximalValue;
        this.items = items;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {new FractionalKnapsack.KnapsackItem[]{
                                new FractionalKnapsack.KnapsackItem(60, 20),
                                new FractionalKnapsack.KnapsackItem(100, 50),
                                new FractionalKnapsack.KnapsackItem(120, 30),
                        }, 50, 180.0d},

                        {new FractionalKnapsack.KnapsackItem[]{
                                new FractionalKnapsack.KnapsackItem(500, 30)
                        }, 10, 166.6667d},

                        {new FractionalKnapsack.KnapsackItem[]{
                                new FractionalKnapsack.KnapsackItem(500, 30)
                        }, 0, 0.0d},

                        {new FractionalKnapsack.KnapsackItem[]{
                                new FractionalKnapsack.KnapsackItem(500, 1)
                        }, 1, 500.0d},

                }
        );
    }

    @Test
    public void getOptimalValueReturnsCorrectResult() {
        assertEquals(maximalValue, fixture.getOptimalValue(weight, items), 0.0001d);
    }

}
