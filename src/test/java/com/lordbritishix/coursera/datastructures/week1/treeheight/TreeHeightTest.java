package com.lordbritishix.coursera.datastructures.week1.treeheight;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TreeHeightTest {
    private tree_height.TreeHeight fixture;

    @Before
    public void setup() {
        fixture = new tree_height.TreeHeight();
    }

    @Test
    public void constructTreeConstructsTree() {
        tree_height.Node root = fixture.constructTree(new int[]{4, -1, 4, 1, 1});
        assertEquals("1,3,4,0,2,", root.toString());

        root = fixture.constructTree(new int[]{-1, 0, 4, 0, 3});
        assertEquals("0,1,3,4,2,", root.toString());
    }

    @Test
    public void heightReturnsCorrectHeight() {
        tree_height.Node root = fixture.constructTree(new int[]{4, -1, 4, 1, 1});
        assertEquals(3, root.getMaxHeight());

        root = fixture.constructTree(new int[]{-1, 0, 4, 0, 3});
        assertEquals(4, root.getMaxHeight());
    }
}
