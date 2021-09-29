package ca.jrvs.practice.codingChallenge;

import junit.framework.TestCase;
import org.junit.*;
import java.util.*;

public class CompareTwoMapsTest extends TestCase {

    CompareTwoMaps compare;

    @Before
    protected void setUp() throws Exception {
        compare = new CompareTwoMaps();
        super.setUp();
    }

    @Test
    public void testCompareMaps() {

        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "A");
        map1.put(2, "B");
        map1.put(3, "C");

        Map<Integer, String> map2 = new HashMap<>();
        map2.put(3, "C");
        map2.put(1, "A");
        map2.put(2, "B");

        Assert.assertEquals(true, compare.compareMaps(map1, map2));
    }
}