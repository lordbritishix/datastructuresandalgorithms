package com.lordbritishix.coursera.algorithmictoolbox.week5.primitivecalculator;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PrimitiveCalculatorTest {
    private final PrimitiveCalculator fixture;
    private final int input;
    private final Integer[] output;

    public PrimitiveCalculatorTest(int input, Integer[] output) {
        this.input = input;
        this.output = output;

        fixture = new PrimitiveCalculator();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {1, new Integer[]{1}},
                        {5, new Integer[]{1, 2, 4, 5}},
                        {10, new Integer[]{1, 3, 9, 10}},
                        {96234, new Integer[]{1, 3, 9, 10, 11, 22, 66, 198, 594, 1782, 5346, 16038, 16039, 32078, 96234}},
                }
        );
    }

    @Test
    public void optimalSequenceReturnsCorrectResult() {
        assertEquals(Arrays.asList(output), fixture.optimalSequence(input));
    }
}

