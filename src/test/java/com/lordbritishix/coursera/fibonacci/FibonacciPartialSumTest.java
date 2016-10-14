package com.lordbritishix.coursera.fibonacci;


import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FibonacciPartialSumTest {
    private final long from;
    private final long to;
    private final long expectedResult;
    private final FibonacciPartialSum fibonacciPartialSum;

    public FibonacciPartialSumTest(long from, long to, long expectedResult) {
        this.from = from;
        this.to = to;
        this.expectedResult = expectedResult;

        this.fibonacciPartialSum = new FibonacciPartialSum();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {3L, 7L, 1L},
                        {10L, 10L, 5L},
                        {10L, 200L, 2L},
                        {1L, 1L, 1L},
                        {0L, 1L, 1L},
                        {0L, 0L, 0L},
                }
        );
    }

    @Test
    public void fibonacciPartialSumReturnsCorrectResult() {
        assertEquals(expectedResult, fibonacciPartialSum.getFibonacciPartialSumFast(from, to));
    }

}
