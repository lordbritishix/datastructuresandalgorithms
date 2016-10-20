package com.lordbritishix.coursera.week2.fibonacci;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FibonacciLastDigitTest {
    private final FibonacciLastDigit fixture;
    private final int n;
    private final int expectedResult;

    public FibonacciLastDigitTest(int n, int expectedResult) {
        this.n = n;
        this.expectedResult = expectedResult;
        this.fixture = new FibonacciLastDigit();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {0, 0},
                        {1, 1},
                        {2, 1},
                        {3, 2},
                        {4, 3},
                        {5, 5},
                        {6, 8},
                        {7, 3},
                        {8, 1},
                        {9, 4},
                        {10, 5},
                        {11, 9},
                        {12, 4},
                        {331, 9},
                        {327305, 5},
                }
        );
    }

    @Test
    public void fibReturnsCorrectResult() {
        assertEquals(expectedResult, fixture.getFibonacciLastDigitFast(n));
    }

}
