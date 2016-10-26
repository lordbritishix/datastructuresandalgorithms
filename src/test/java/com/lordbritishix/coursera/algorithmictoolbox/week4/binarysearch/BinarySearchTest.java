package com.lordbritishix.coursera.algorithmictoolbox.week4.binarysearch;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BinarySearchTest {
    private final long[] elements;
    private final long search;
    private final int expectedResult;

    private final BinarySearch fixture;

    public BinarySearchTest(long[] elements, long search, int expectedResult) {
        this.elements = elements;
        this.search = search;
        this.expectedResult = expectedResult;

        fixture = new BinarySearch();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {new long[]{1L, 2L, 3L, 4L}, 4L, 3},
                        {new long[]{1L, 2L, 3L, 4L}, 5L, -1},
                        {new long[]{1L, 2L, 3L, 4L}, 1L, 0},
                        {new long[]{2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L, 11L}, 3L, 1}

                }
        );
    }

    @Test
    public void binarySearchReturnsCorrectResult() {
        assertEquals(expectedResult, fixture.binarySearch(elements, search));
//        assertEquals(expectedResult, fixture.linearSearch(elements, search));

    }
}
