package com.lordbritishix.coursera.algorithmictoolbox.week5.editdistance;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class EditDistanceTest {
    private final EditDistance fixture;
    private final String from;
    private final String to;
    private final int editDistance;

    public EditDistanceTest(String from, String to, int editDistance) {
        this.fixture = new EditDistance();

        this.from = from;
        this.to = to;
        this.editDistance = editDistance;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"ab", "ab", 0},
                {"short", "ports", 3},
                {"editing", "distance", 5},
                {"abcdef", "azced", 3},
        });
    }

    @Test
    public void computeEditDistanceReturnsCorrectResult() {
        assertEquals(editDistance, fixture.editDistance(from, to));
    }
}
