package com.lordbritishix.coursera.week3.summand;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DifferentSummandsTest {
    private final long n;
    private final List<Long> expectedSummands;

    private final DifferentSummands fixture;

    public DifferentSummandsTest(long n, List<Long> expectedSummands) {
        this.n = n;
        this.expectedSummands = expectedSummands;

        this.fixture = new DifferentSummands();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {8L, Arrays.asList(1L, 2L, 5L)},
                        {6L, Arrays.asList(1L, 2L, 3L)},
                        {2L, Arrays.asList(2L)},
                        {0L, Arrays.asList(0L)},
                        {7L, Arrays.asList(1L, 2L, 4L)},
                }
        );
    }

    @Test
    public void optimalSummandsReturnsCorrectResult() {
        assertEquals(expectedSummands, fixture.optimalSummands(n));
    }
}
