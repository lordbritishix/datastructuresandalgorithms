package com.lordbritishix.coursera.week3.largestnumber;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LargestNumberTest {
    private final Integer[] a;
    private final String expectedValue;

    private final LargestNumber fixture;

    public LargestNumberTest(Integer[] a, String expectedValue) {
        this.a = a;
        this.expectedValue = expectedValue;

        fixture = new LargestNumber();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {new Integer[]{2}, "2"},
                        {new Integer[]{2, 2, 2, 3}, "3222"},
                        {new Integer[]{4, 1, 3, 7}, "7431"},
                        {new Integer[]{21, 2}, "221"},
                        {new Integer[]{9, 4, 6, 1, 9}, "99641"},
                        {new Integer[]{23, 39, 92}, "923923"},
                }
        );
    }

    @Test
    public void largestNumberReturnsCorrectResult() {
        assertEquals(expectedValue, fixture.largestNumber(a));
    }

}
