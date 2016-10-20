package com.lordbritishix.coursera.week3.coveringsegments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * You are given a set of segments on a line and your goal is to mark as few points on a line as possible so that
 * each segment contains at least one marked point.
 * <p>
 * Algorithm:
 * 1. Sort segments by end point
 * 2. Pick the next segment
 * 3. If there is a previous segment, compare if the previous segment intersects the next segment. If not, add that segment's end point to the array of points
 * 4. If it intersects, eliminate that next segment.
 * 5. If it doesn't intersect, add the next segment's end point to the array of points
 * 6. Repeat #2 until there are no more segment
 *
 * Insights:
 * 1. Safe choice: pick the next segment. If it does not intersect with the previous segment, add that segment's end point
 * to the list of points. If it does, don't consider that segment.
 */
public class CoveringSegments {
    public List<Long> optimalPoints(Segment[] segments) {
        List<Long> points = new ArrayList<>();

        if (segments.length <= 0) {
            return points;
        }

        Arrays.sort(segments);

        // Initialize points array, set first element the the first segment's end point
        Segment previousSegment = null;
        for (Segment segment : segments) {
            // Find a disjoint set (relative to the current set), if we found it, that means we found another point
            if (previousSegment == null || segment.start > previousSegment.end) {
                previousSegment = segment;
                points.add(previousSegment.end);
            }
        }

        return points;
    }

    public static class Segment implements Comparable<Segment> {
        long start, end;

        private Segment(long start, long end) {
            this.start = start;
            this.end = end;
        }

        public static Segment newSegment(long start, long end) {
            return new Segment(start, end);
        }

        @Override
        public int compareTo(Segment that) {
            return Long.compare(this.end, that.end);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }

        CoveringSegments coveringSegments = new CoveringSegments();
        List<Long> points = coveringSegments.optimalPoints(segments);
        System.out.println(points.size());
        for (Long point : points) {
            System.out.print(point + " ");
        }
    }
}
 
