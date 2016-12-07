package com.lordbritishix.coursera.algorithmictoolbox.week4.pointsandsegments;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PointsAndSegments {
    public static final class Segment implements Comparable<Segment> {
        private final int start;
        private final int end;

        public Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }

        @Override
        public int compareTo(Segment o) {
            return 0;
        }
    }

    public static final class SegmentMutant {
        public static final String LEFT = "l";
        public static final String RIGHT = "r";
        public static final String POINT = "p";

        private final int val;
        private final String type;
        private final int idx;

        private SegmentMutant(int val, String type) {
            this.idx = -1;
            this.val = val;
            this.type = type;
        }

        private SegmentMutant(int idx, int val, String type) {
            this.idx = idx;
            this.val = val;
            this.type = type;
        }


        public static SegmentMutant newSegmentStart(Segment segment) {
            return new SegmentMutant(segment.getStart(), LEFT);
        }

        public static SegmentMutant newSegmentEnd(Segment segment) {
            return new SegmentMutant(segment.getEnd(), RIGHT);
        }

        public static SegmentMutant newPoint(int idx, int val) {
            return new SegmentMutant(idx, val, POINT);
        }

        public static boolean isPoint(SegmentMutant mutant) {
            return mutant.getType().equals(POINT);
        }

        public static boolean isStart(SegmentMutant mutant) {
            return mutant.getType().equals(LEFT);
        }

        public static boolean isEnd(SegmentMutant mutant) {
            return mutant.getType().equals(RIGHT);
        }


        public int getVal() {
            return val;
        }

        public String getType() {
            return type;
        }

        public int getIdx() {
            return idx;
        }
    }

    public int[] fastCountSegments(Segment[] segments, int[] points) {
        SegmentMutant[] mutants = transform(segments, points);

        int stackCount = 0;
        int[] count = new int[points.length];

        for (SegmentMutant segmentMutant : mutants) {
            if (SegmentMutant.isStart(segmentMutant)) {
                stackCount++;
            }

            if ((SegmentMutant.isPoint(segmentMutant)) && (stackCount > 0)) {
                int idx = segmentMutant.getIdx();
                count[idx] = count[idx] + stackCount;
            }

            if (SegmentMutant.isEnd(segmentMutant)) {
                stackCount--;
            }
        }

        return count;
    }

    private SegmentMutant[] transform(Segment[] segments, int[] points) {
        int length = segments.length * 2 + points.length;
        SegmentMutant[] mutants = new SegmentMutant[length];

        for (int x = 0; x < segments.length; x++) {
            mutants[x] = SegmentMutant.newSegmentStart(segments[x]);
        }

        for (int x = segments.length; x < segments.length * 2; x++) {
            mutants[x] = SegmentMutant.newSegmentEnd(segments[x - segments.length]);
        }

        for (int x = segments.length * 2; x < (segments.length * 2) + points.length; x++) {
            int idx = x - (segments.length * 2);
            mutants[x] = SegmentMutant.newPoint(idx, points[idx]);
        }

        Arrays.sort(mutants, new Comparator<SegmentMutant>() {
            @Override
            public int compare(SegmentMutant o1, SegmentMutant o2) {
                int comp = Integer.compare(o1.getVal(), o2.getVal());

                if (comp != 0) {
                    return comp;
                }

                return o1.getType().compareTo(o2.getType());
            }
        });

        return mutants;
    }

    public int[] naiveCountSegments(Segment[] segments, int[] points) {
        int[] cnt = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < segments.length; j++) {
                if (segments[j].start <= points[i] && points[i] <= segments[j].end) {
                    cnt[i]++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        Segment[] segments = new Segment[n];
        int[] points = new int[m];
        for (int i = 0; i < n; i++) {
            segments[i] = new Segment(scanner.nextInt(), scanner.nextInt());
        }
        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }

        PointsAndSegments pointsAndSegments = new PointsAndSegments();

        //use fastCountSegments
        int[] cnt = pointsAndSegments.fastCountSegments(segments, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}

