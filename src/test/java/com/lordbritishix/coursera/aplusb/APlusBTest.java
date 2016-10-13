package com.lordbritishix.coursera.aplusb;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(Parameterized.class)
public class APlusBTest {
    private final APlusB fixture;
    private final int a;
    private final int b;
    private final int expectedResult;
    private final boolean exceptionExpected;

    public APlusBTest(int a, int b, int expectedResult, boolean exceptionExpected) {
        this.a = a;
        this.b = b;
        this.expectedResult = expectedResult;
        this.exceptionExpected = exceptionExpected;
        this.fixture = new APlusB();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1, 2, false},
                {0, 0, 0, false},
                {9, 9, 18, false},
                {10, 10, 0, true},
                {-5, -10, 0, true},
                {-5, 0, 0, true},
                {10, 29, 0, true},
        });
    }


    @Test
    public void addReturnsCorrectValue() {
        IllegalArgumentException exception = null;
        try {
            int result = fixture.add(a, b);
            assertEquals(expectedResult, result);
        } catch (IllegalArgumentException e) {
            exception = e;
        }

        if (exceptionExpected && exception == null) {
            fail("exception is expected but was not thrown");
        }

        if (!exceptionExpected && exception != null) {
            fail("exception is expected but was thrown: " + exception);
        }
    }
}
