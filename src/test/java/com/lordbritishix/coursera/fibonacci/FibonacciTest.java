package com.lordbritishix.coursera.fibonacci;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FibonacciTest {
    private final Fibonacci fixture;
    private final int n;
    private final long expectedResult;

    public FibonacciTest(int n, long expectedResult) {
        this.n = n;
        this.expectedResult = expectedResult;
        this.fixture = new Fibonacci();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {0, 0L},
                        {1, 1L},
                        {2, 1L},
                        {3, 2L},
                        {4, 3L},
                        {5, 5L},
                        {6, 8L},
                        {7, 13L},
                        {8, 21L},
                        {9, 34L},
                        {10, 55L},
                        {11, 89L},
                        {12, 144L},
                }
        );
    }

    @Test
    public void fibReturnsCorrectResult() {
        assertEquals(expectedResult, fixture.getFibonacciUsingMemoization(n));
        assertEquals(expectedResult, fixture.getFibonacciUsingRecusion(n));
    }

}
