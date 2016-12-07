package com.lordbritishix.coursera.algorithmictoolbox.week4.dotproduct;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.lordbritishix.coursera.algorithmictoolbox.week4.dotproduct.DotProduct.Point;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class DotProductTest {
    private final DotProduct.Point[] points;
    private final double expectedResult;

    private final DotProduct fixture;

    public DotProductTest(DotProduct.Point[] points, double expectedResult) {
        this.points = points;
        this.expectedResult = expectedResult;

        this.fixture = new DotProduct();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {new DotProduct.Point[]{Point.of(0, 0), Point.of(3, 4)}, 5.0d},
                        {new DotProduct.Point[]{Point.of(7, 7), Point.of(1, 100), Point.of(4, 8), Point.of(7, 7)}, 0.0d},
                        {new DotProduct.Point[]{Point.of(4, 4), Point.of(-2, -2), Point.of(-3, -4), Point.of(-1, 3),
                                Point.of(2, 3), Point.of(-4, 0), Point.of(1, 1), Point.of(-1, -1), Point.of(3, -1), Point.of(-4, 2),
                                Point.of(-2, 4)}, 1.414213d}
                }
        );
    }

    @Test
    public void getClosestPairOfPointsReturnsCorrectResult() {
        assertTrue(Math.abs(expectedResult - fixture.getClosestPairOfPoints(points)) < 0.0001);
    }

    @Test
    public void getClosestPairOfPointsReturnsCorrectResultNaive() {
        assertTrue(Math.abs(expectedResult - fixture.getClosestPairOfPointsNaive(points)) < 0.0001);
    }

}
