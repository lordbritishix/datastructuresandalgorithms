package com.lordbritishix.coursera.algorithmictoolbox.week4.sorting;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class SortingTest {
    private final long[] elements;
    private final long[] sortedElements;

    private final Sorting fixture;

    public SortingTest(long[] elements, long[] sortedElements) {
        this.elements = elements;
        this.sortedElements = sortedElements;

        this.fixture = new Sorting();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {new long[]{1L, 2L, 3L}, new long[]{1L, 2L, 3L}},
                        {new long[]{8L, 3L, 2L, 1L, 4L, 7L}, new long[]{1L, 2L, 3L, 4L, 7L, 8L}},
                        {new long[]{3L}, new long[]{3L}},
                        {new long[]{4L, 1L, 2L, 3L}, new long[]{1L, 2L, 3L, 4L}},
                        {new long[]{2L, 2L, 2L}, new long[]{2L, 2L, 2L}},
                        {new long[]{31L, 1L, 22L}, new long[]{1L, 22L, 31L}},

                }
        );
    }

    @Test
    public void sortUsingMyVersionReturnsSortedElements() {
        fixture.myQuickSort(elements, 0, elements.length - 1);
        assertArrayEquals(sortedElements, elements);
    }

    @Test
    public void sortUsingPartition3ReturnsSortedElements() {
        fixture.randomizedQuickSort(elements, 0, elements.length - 1);
        assertArrayEquals(sortedElements, elements);
    }

}
