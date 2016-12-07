package com.lordbritishix.coursera.algorithmictoolbox.week4.inversions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class InversionsTest {
    private Inversions fixture;

    @Before
    public void setup() {
        this.fixture = new Inversions();
    }

    @Test
    public void doMergeReturnsCorrectResult1() {
        long[] elements = new long[]{4L, 5L, 1L, 2L};
        testSort(elements, new long[]{1L, 2L, 4L, 5L});
    }

    @Test
    public void doMergeReturnsCorrectResult2() {
        long[] elements = new long[]{1L, 2L, 6L, 7L, 8L};
        testSort(elements, new long[]{1L, 2L, 6L, 7L, 8L});
    }

    @Test
    public void doMergeReturnsCorrectResult3() {
        long[] elements = new long[]{1L};
        testSort(elements, new long[]{1L});
    }

    @Test
    public void doMergeReturnsCorrectResult4() {
        long[] elements = new long[]{2L, 1L};
        testSort(elements, new long[]{1L, 2L});
    }

    @Test
    public void doMergeReturnsCorrectResult5() {
        long[] elements = new long[]{};
        testSort(elements, new long[]{});
    }

    @Test
    public void doMergeReturnsCorrectResult6() {
        long[] elements = new long[]{6L, 5L};
        testSort(elements, new long[]{5L, 6L});
    }

    @Test
    public void doMergeReturnsCorrectResultForPartialSort() {
        long[] elements = new long[]{5L, 6L, 7L, 1L};
        testSort(elements, new long[]{5L, 6L, 1L, 7L}, 2, 3, 2);
    }

    @Test
    public void doMergeSortReturnsCorrectResult1() {
        long[] elements = new long[]{7L, 6L, 5L, 4L};

        fixture.mergeSort(elements);
        assertArrayEquals(new long[]{4L, 5L, 6L, 7L}, elements);
    }

    @Test
    public void doMergeSortReturnsCorrectResult2() {
        long[] elements = new long[]{1L, 2L, 3L, 4L, 5L};

        fixture.mergeSort(elements);
        assertArrayEquals(new long[]{1L, 2L, 3L, 4L, 5L}, elements);
    }

    @Test
    public void doMergeSortReturnsCorrectResult3() {
        long[] elements = new long[]{2L, 1L};

        fixture.mergeSort(elements);
        assertArrayEquals(new long[]{1L, 2L}, elements);
    }

    @Test
    public void doMergeSortReturnsCorrectResult4() {
        long[] elements = new long[]{2L, 3L, 1L};

        fixture.mergeSort(elements);
        assertArrayEquals(new long[]{1L, 2L, 3L}, elements);
    }

    @Test
    public void doMergeSortReturnsCorrectResult5() {
        long[] elements = new long[]{2L, 3L, 9L, 2L, 9L};

        fixture.mergeSort(elements);
        assertArrayEquals(new long[]{2L, 2L, 3L, 9L, 9L}, elements);
    }



    @Test
    public void doMergeReturnsCorrectInversion1() {
        long[] elements = new long[]{2L, 5L, 1L, 6L};
        testInversion(elements, 2L);
    }

    @Test
    public void doMergeReturnsCorrectInversion2() {
        long[] elements = new long[]{4L, 3L, 2L, 1L};
        testInversion(elements, 6L);
    }

    @Test
    public void doMergeReturnsCorrectInversion3() {
        long[] elements = new long[]{2L, 3L, 9L, 2L, 9L};
        testInversion(elements, 2L);
    }

    private void testInversion(long[] input, long expectedInversionCount) {
        long inversionCount = fixture.mergeSort(input);

        assertEquals(expectedInversionCount, inversionCount);
    }

    private void testSort(long[] input, long[] expected) {
        long[] buffer = new long[input.length];

        int mid = (input.length - 1) / 2;

        fixture.doMerge(input, buffer, 0, input.length - 1, mid);
        assertArrayEquals(expected, input);
    }

    private void testSort(long[] input, long[] expected, int left, int right, int mid) {
        long[] output = new long[input.length];
        fixture.doMerge(input, output, left, right, mid);
        assertArrayEquals(expected, input);
    }
}
