package com.lordbritishix.coursera.algorithmictoolbox.week4.pointsandsegments;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class PointsAndSegmentsTest {
    private final PointsAndSegments fixture;
    private final PointsAndSegments.Segment[] segments;
    private final int[] points;
    private final int[] expectedResult;

    public PointsAndSegmentsTest(PointsAndSegments.Segment[] segments, int[] points, int[] expectedResult) {
        this.segments = segments;
        this.points = points;
        this.expectedResult = expectedResult;

        this.fixture = new PointsAndSegments();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {new PointsAndSegments.Segment[]{new PointsAndSegments.Segment(0, 5), new PointsAndSegments.Segment(7, 10)},
                                new int[]{1, 6, 11}, new int[]{1, 0, 0}},
                        {new PointsAndSegments.Segment[]{new PointsAndSegments.Segment(-10, 10)},
                                new int[]{-100, 100, 0}, new int[]{0, 0, 1}},
                        {new PointsAndSegments.Segment[]{new PointsAndSegments.Segment(0, 5), new PointsAndSegments.Segment(-3, 2), new PointsAndSegments.Segment(7, 10) },
                                new int[]{1, 6}, new int[]{2, 0}},
                        {new PointsAndSegments.Segment[]{new PointsAndSegments.Segment(0, 5)},
                                new int[]{11}, new int[]{0}},
                        {new PointsAndSegments.Segment[]{new PointsAndSegments.Segment(2, 4)},
                                new int[]{4}, new int[]{1}},
                        {new PointsAndSegments.Segment[]{new PointsAndSegments.Segment(2, 4)},
                                new int[]{2}, new int[]{1}},
                        {new PointsAndSegments.Segment[]{new PointsAndSegments.Segment(1, 1)},
                                new int[]{1}, new int[]{1}},
                        {new PointsAndSegments.Segment[]{},
                                new int[]{1}, new int[]{0}},
                        {new PointsAndSegments.Segment[]{new PointsAndSegments.Segment(1, 2)},
                                new int[]{}, new int[]{}},
                        {new PointsAndSegments.Segment[]{new PointsAndSegments.Segment(-10, 0)},
                                new int[]{-8}, new int[]{1}},
                        {new PointsAndSegments.Segment[]{new PointsAndSegments.Segment(-10, 0), new PointsAndSegments.Segment(-10, 0)},
                                new int[]{-8}, new int[]{2}},
                        {new PointsAndSegments.Segment[]{new PointsAndSegments.Segment(-10, 0), new PointsAndSegments.Segment(0, 10)},
                                new int[]{0}, new int[]{2}},
                        {new PointsAndSegments.Segment[]{new PointsAndSegments.Segment(-10, -1), new PointsAndSegments.Segment(1, 10)},
                                new int[]{0}, new int[]{0}},
                        {new PointsAndSegments.Segment[]{},
                                new int[]{}, new int[]{}},
                        {new PointsAndSegments.Segment[]{new PointsAndSegments.Segment(-9, 52), new PointsAndSegments.Segment(14, 97), new PointsAndSegments.Segment(32, 77)},
                                new int[]{-9, -9, -9}, new int[]{1, 1, 1}},
                }
        );
    }

    @Test
    public void countSegmentsReturnsCorrectResult() {
        assertArrayEquals(expectedResult, fixture.naiveCountSegments(segments, points));
    }

    @Test
    public void countSegmentsReturnsCorrectResultUsingFastMethod() {
        assertArrayEquals(expectedResult, fixture.fastCountSegments(segments, points));
    }
}
