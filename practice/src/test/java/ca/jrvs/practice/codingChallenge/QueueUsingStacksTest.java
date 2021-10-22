package ca.jrvs.practice.codingChallenge;

import junit.framework.TestCase;
import org.junit.Test;

public class QueueUsingStacksTest extends TestCase {

    QueueUsingStacks queue;

    public void setUp() throws Exception {
        super.setUp();
        queue = new QueueUsingStacks();
    }

    @Test
    public void testQueue(){
        queue.push(1); // queue is: [1]
        queue.push(2); // queue is: [1, 2] (leftmost is front of the queue)

        assertEquals(1, queue.peek()); // return 1
        assertEquals(1, queue.pop()); // return 1, queue is [2]
        assertEquals(false,queue.empty()); // return false
    }
}