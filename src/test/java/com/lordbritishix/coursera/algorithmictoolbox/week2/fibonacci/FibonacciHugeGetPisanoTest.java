package com.lordbritishix.coursera.algorithmictoolbox.week2.fibonacci;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FibonacciHugeGetPisanoTest {
    private final FibonacciHuge fixture;
    private final long n;
    private final long m;
    private final long expectedResult;

    public FibonacciHugeGetPisanoTest(long n, long m, long expectedResult) {
        this.n = n;
        this.m = m;
        this.expectedResult = expectedResult;

        fixture = new FibonacciHuge();
    }

    @Parameterized.Parameters(name = "fib={0} mod={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {44L, 2L, 3L},
                        {44L, 3L, 8L},
                        {44L, 4L, 6L},
                        {44L, 5L, 20L},
                        {44L, 6L, 24L},
                        {44L, 7L, 16L},
                        {44L, 8L, 12L},
                        {44L, 9L, 24L},
                        {70L, 10L, 60L},
                        {44L, 11L, 10L},
                        {44L, 12L, 24L},
                        {44L, 13L, 28L},
                        {70L, 14L, 48L},
                        {400L, 2001L, 336L}
                }
        );
    }

    @Test
    public void fibonacciReturnsCorrectResult() {
        assertEquals(expectedResult, fixture.getPisano(n, m));
    }

}
