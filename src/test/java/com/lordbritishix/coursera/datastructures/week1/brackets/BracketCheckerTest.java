package com.lordbritishix.coursera.datastructures.week1.brackets;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BracketCheckerTest {
    private final BracketChecker fixture;
    private final int expectedResult;
    private final String input;

    public BracketCheckerTest(String input, int expectedResult) {
        this.fixture = new BracketChecker();
        this.input = input;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"[]", BracketChecker.SUCCESS},
                {"{}[]", BracketChecker.SUCCESS},
                {"[()]", BracketChecker.SUCCESS},
                {"(())", BracketChecker.SUCCESS},
                {"{[]}()", BracketChecker.SUCCESS},
                {"{", 1},
                {"{[}", 3},
                {"foo(bar);", BracketChecker.SUCCESS},
                {"foo(bar[i);", 10},
                {"", BracketChecker.SUCCESS},
                {"(((()", 3}
        });
    }

    @Test
    public void checkReturnsCorrectResult() {
        assertEquals(expectedResult, fixture.check(input));
    }

}
