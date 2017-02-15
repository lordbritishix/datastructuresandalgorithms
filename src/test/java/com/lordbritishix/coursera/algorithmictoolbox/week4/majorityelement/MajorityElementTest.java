package com.lordbritishix.coursera.algorithmictoolbox.week4.majorityelement;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class MajorityElementTest {
    private final long[] elements;
    private final long majorityElement;

    private final MajorityElement fixture;

    public MajorityElementTest(long[] elements, long majorityElement) {
        this.elements = elements;
        this.majorityElement = majorityElement;

        fixture = new MajorityElement();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
//                        {new long[]{}, -1},
//                        {new long[]{1L}, 1},
                        {new long[]{2L, 3L, 9L, 2L, 2L}, 2L},
//                        {new long[]{1L, 2L, 3L, 4L}, -1},
//                        {new long[]{1L, 2L, 3L, 1L}, -1},
//                        {new long[]{10L, 2L, 10L, 1L, 10L}, 10L},
//                        {new long[]{512766168L, 717383758L, 5L, 126144732L, 5L, 573799007L, 5L, 5L, 5L, 405079772L}, -1}
                }
        );
    }

    @Test
    public void getMajorityReturnsCorrectResult() {
        assertEquals(majorityElement, fixture.getMajorityElement(elements, 0, elements.length - 1));
    }
}
