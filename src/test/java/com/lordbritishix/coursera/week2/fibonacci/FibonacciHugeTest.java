package com.lordbritishix.coursera.week2.fibonacci;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FibonacciHugeTest {
    private final FibonacciHuge fixture;
    private final long n;
    private final long m;
    private final long expectedResult;

    public FibonacciHugeTest(long n, long m, long expectedResult) {
        this.n = n;
        this.m = m;
        this.expectedResult = expectedResult;

        fixture = new FibonacciHuge();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {1L, 239L, 1L},
                        {239L, 1000L, 161L},
                        {2816213588L, 30524L, 10249L},
                        {99999999999999999L, 2L, 0L}
                }
        );
    }

    @Test
    public void fibonacciReturnsCorrectResult() {
        assertEquals(expectedResult, fixture.getFibonacciModXHugePisano(n, m));
    }
}
