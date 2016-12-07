package com.lordbritishix.coursera.algorithmictoolbox.week4.pointsandsegments;

import java.util.Arrays;
import org.apache.commons.lang.math.RandomUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class PointsAndSegmentsStressTest {
    private PointsAndSegments fixture;

    @Before
    public void setup() {
        fixture = new PointsAndSegments();
    }

    @Test
    public void stressTest() {
        while (true) {
            PointsAndSegments.Segment[] segments = randomSegments(3);
            int[] points = randomPoints(3);

            int[] expected = fixture.naiveCountSegments(segments, points);

            System.out.println("segments: " + Arrays.toString(segments));
            System.out.println("points:   " + Arrays.toString(points));
            System.out.println("expected: " + Arrays.toString(expected));

            assertArrayEquals(fixture.naiveCountSegments(segments, points), fixture.fastCountSegments(segments, points));
        }
    }

    private PointsAndSegments.Segment[] randomSegments(int seed) {
        int segmentCount = 1 + RandomUtils.nextInt(seed);
        PointsAndSegments.Segment[] segments = new PointsAndSegments.Segment[segmentCount];

        for (int x = 0; x < segmentCount; ++x) {
            segments[x] = randomSegment();
        }

        return segments;
    }

    private int[] randomPoints(int seed) {
        int pointCount = 1 + RandomUtils.nextInt(seed);
        int[] points = new int[pointCount];

        for (int x = 0; x < pointCount; ++x) {
            points[x] = -10 + RandomUtils.nextInt(seed);
        }

        return points;
    }

    private PointsAndSegments.Segment randomSegment() {
        int start = -10 + RandomUtils.nextInt(100);
        int end = start + 1 + RandomUtils.nextInt(100);

        assertEquals(true, start < end);
        return new PointsAndSegments.Segment(start, end);
    }


}
