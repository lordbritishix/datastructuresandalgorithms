package com.lordbritishix.coursera.algorithmictoolbox.week3.dotproduct;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DotProductTest {
    private final long[] profitPerClick;
    private final long[] avgNumbersOfClicks;
    private final long expectedResult;

    private DotProduct fixture;

    public DotProductTest(long[] profitPerClick, long[] avgNumbersOfClicks, long expectedResult) {
        this.profitPerClick = profitPerClick;
        this.avgNumbersOfClicks = avgNumbersOfClicks;
        this.expectedResult = expectedResult;

        this.fixture = new DotProduct();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {new long[]{23L}, new long[]{39L}, 897L},
                        {new long[]{1L, 3L, -5L}, new long[]{-2L, 4L, 1L}, 23L},
                }
        );
    }

    @Test
    public void computeDotProductReturnsCorrectResult() {
        assertEquals(expectedResult, fixture.maxDotProduct(profitPerClick, avgNumbersOfClicks));
    }
}
