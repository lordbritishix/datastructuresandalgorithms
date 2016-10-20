package com.lordbritishix.coursera.week3.coveringsegments;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CoveringSegmentsTest {
    private final CoveringSegments.Segment[] segments;
    private final List<Long> points;
    private final CoveringSegments fixture;

    public CoveringSegmentsTest(CoveringSegments.Segment[] segments, List<Long> points) {
        this.segments = segments;
        this.points = points;

        fixture = new CoveringSegments();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(
                new Object[][]{
                        {new CoveringSegments.Segment[] {
                                CoveringSegments.Segment.newSegment(1L, 3L),
                                CoveringSegments.Segment.newSegment(2L, 5L),
                                CoveringSegments.Segment.newSegment(3L, 6L),
                        },
                        Lists.newArrayList(3L)
                        },

                        {new CoveringSegments.Segment[] {
                                CoveringSegments.Segment.newSegment(4L, 7L),
                                CoveringSegments.Segment.newSegment(1L, 3L),
                                CoveringSegments.Segment.newSegment(2L, 5L),
                                CoveringSegments.Segment.newSegment(5L, 6L),

                        },
                        Lists.newArrayList(3L, 6L)
                        },
                }
        );
    }

    @Test
    public void optimalPointsReturnsCorrectResult() {
        assertEquals(points, fixture.optimalPoints(segments));
    }
}
