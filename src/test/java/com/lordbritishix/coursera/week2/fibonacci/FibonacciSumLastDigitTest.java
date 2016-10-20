package com.lordbritishix.coursera.week2.fibonacci;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FibonacciSumLastDigitTest {
    private final FibonacciSumLastDigit fixture;
    private final long n;
    private final long expectedResult;

    public FibonacciSumLastDigitTest(long n, long expectedResult) {
        this.n = n;
        this.expectedResult = expectedResult;

        fixture = new FibonacciSumLastDigit();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {0L, 0L},
                        {1L, 1L},
                        {3L, 4L},
                        {100L, 5L},
                        {54L, 6L},
                        {70L, 3L}
                }
        );
    }

    @Test
    public void fibonacciSumLastDigitReturnsCorrectResult() {
        assertEquals(expectedResult, fixture.getFibonacciSumFast(n));
    }

}
