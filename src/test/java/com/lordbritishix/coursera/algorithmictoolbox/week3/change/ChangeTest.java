package com.lordbritishix.coursera.algorithmictoolbox.week3.change;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ChangeTest {
    private final int[] changes;
    private final int input;
    private final int expectedResult;
    private final Change fixture;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {new int[]{10, 5, 1}, 2, 2},
                        {new int[]{10, 5, 1}, 28, 6},
                        {new int[]{10, 5, 1}, 13, 4},
                        {new int[]{10, 5, 1}, 10, 1},
                        {new int[]{10, 5, 1}, 0, 0},
                        {new int[]{10, 5, 2}, 1, 0},
                        {new int[]{10, 5, 2}, 1, 0},
                        {new int[]{10, 9, 1}, 8, 8}

                }
        );
    }

    public ChangeTest(int[] changes, int input, int expectedResult) {
        this.input = input;
        this.expectedResult = expectedResult;
        this.changes = changes;
        this.fixture = new Change();
    }

    @Test
    public void getChangeReturnsCorrectResult() {
        assertEquals(expectedResult, fixture.getChange(changes, input));
    }
}
