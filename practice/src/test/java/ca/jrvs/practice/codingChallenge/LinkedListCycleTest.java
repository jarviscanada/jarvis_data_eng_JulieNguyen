package ca.jrvs.practice.codingChallenge;

import junit.framework.TestCase;
import org.junit.Before;

public class LinkedListCycleTest extends TestCase {

    LinkedListCycle llc;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        llc = new LinkedListCycle();
    }

    public void testHasCycle() {
        ListNode head, second, third, fourth;
        head = new ListNode(3);
        second = new ListNode(2);
        third = new ListNode(0);
        fourth = new ListNode(-4);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = second;

        assertEquals(true, llc.hasCycle(head));

        head.val = 1;
        second.val = 2;
        second.next = head;

        assertEquals(true, llc.hasCycle(head));

        head.next = null;

        assertEquals(false, llc.hasCycle(head));

    }
}