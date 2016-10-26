package com.lordbritishix.coursera.algorithmictoolbox.week2.gcd;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GCDTest {
    private final GCD fixture;
    private final int a;
    private final int b;
    private final int expectedResult;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {18, 35, 1},
                        {28851538, 1183019, 17657},
                        {8, 4, 4},
                        {4, 8, 4},
                        {15, 25, 5},
                        {1344, 217, 7},
                        {3, 5, 1}
                }
        );
    }

    public GCDTest(int a, int b, int expectedResult) {
        this.a = a;
        this.b = b;
        this.expectedResult = expectedResult;

        this.fixture = new GCD();
    }

    @Test
    public void gcdReturnsCorrectResult() {
        assertEquals(expectedResult, fixture.gcdNaive(a, b));
        assertEquals(expectedResult, fixture.gadUsingEuclidean(a, b));

    }


}
