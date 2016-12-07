package com.lordbritishix.coursera.algorithmictoolbox.week5.knapsack;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class KnapsackTest {
    private final Knapsack fixture;
    private final int weight;
    private final int[] itemWeights;
    private final int expectedMaxWeight;

    public KnapsackTest(int weight, int[] itemWeights, int expectedMaxWeight) {
        this.fixture = new Knapsack();
        this.itemWeights = itemWeights;
        this.weight = weight;
        this.expectedMaxWeight = expectedMaxWeight;
    }


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {10, new int[]{1, 4, 8}, 9},
                {10, new int[]{9, 10, 11}, 10},
        });
    }

    @Test
    public void optmialWeightReturnsCorrectResult() {
        assertEquals(expectedMaxWeight, fixture.optimalWeight(weight, itemWeights));
    }
}
