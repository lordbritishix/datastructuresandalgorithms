package com.lordbritishix.coursera.lcm;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LCMTest {
    private final LCM fixture;
    private final int a;
    private final int b;
    private final long expectedResult;

    public LCMTest(int a, int b, long expectedResult) {
        this.a = a;
        this.b = b;
        this.expectedResult = expectedResult;

        fixture = new LCM();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {6, 8, 24},
                        {1, 2, 2},
                        {1, 1, 1},
                        {0, 1, 0},
                        {28851538, 1183019, 1933053046},
                }
        );
    }

    @Test
    public void lcmReturnsCorrectResult() {
//        assertEquals(expectedResult, fixture.lcmNaive(a, b));
        assertEquals(expectedResult, fixture.lcmFast(a, b));
    }
}
