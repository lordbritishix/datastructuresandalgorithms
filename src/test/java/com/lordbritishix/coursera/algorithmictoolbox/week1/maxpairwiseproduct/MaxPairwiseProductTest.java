package com.lordbritishix.coursera.algorithmictoolbox.week1.maxpairwiseproduct;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import com.google.common.collect.ImmutableList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MaxPairwiseProductTest {
    private final MaxPairwiseProduct fixture;
    private final int[] input;
    private final long expectedResult;

    public MaxPairwiseProductTest(List<Integer> inputAsList, long expectedResult) {
        this.fixture = new MaxPairwiseProduct();
        this.input = new int[inputAsList.size()];

        int ctr = 0;
        for (Integer num : inputAsList) {
            input[ctr] = num;
            ctr++;
        }

        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {ImmutableList.of(1, 1), 1L},
                        {ImmutableList.of(1, 2, 3), 6L},
                        {ImmutableList.of(1, 3, 1, 1, 3), 9L},
                        {ImmutableList.of(7, 5, 14, 2, 8, 8 , 10, 1, 2, 3), 140L},
                        {ImmutableList.of(100000, 90000), 9000000000L}
                }
        );
    }

    @Test
    public void maxPairwiseProductReturnsCorrectResult() {
        long result = fixture.getMaxPairwiseProductSlow(input);
        assertEquals(expectedResult, result);

        result = fixture.getMaxPariwiseProductFast(input);
        assertEquals(expectedResult, result);
    }
}
