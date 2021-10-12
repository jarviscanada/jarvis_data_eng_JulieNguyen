package ca.jrvs.practice.codingChallenge;

import junit.framework.TestCase;
import org.junit.Test;

public class StackUsingQueuesTest extends TestCase {

    StackUsingQueues stack;

    public void setUp() throws Exception {
        super.setUp();
        stack = new StackUsingQueues();
    }

    @Test
    public void testMyStack() {
        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.top());
        assertEquals(2, stack.pop());
        assertEquals(false, stack.empty());
    }
}