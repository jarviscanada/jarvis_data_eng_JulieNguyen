package ca.jrvs.practice.codingChallenge;

import junit.framework.TestCase;
import org.junit.Before;

public class RemoveNthFromEndTest extends TestCase {

    ListNode head;

    RemoveNthFromEnd remove;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;

        remove = new RemoveNthFromEnd();
    }

    public void testRemoveNthFromEnd() {
        assertEquals(1, remove.removeNthFromEnd(head, 1).val);
    }

    public void testRemoveNthFromEnd2() {

        ListNode actual = remove.removeNthFromEnd(head, 2);

        assertEquals(1, actual.val);
        actual = actual.next;
        assertEquals(2, actual.val);
        actual = actual.next;
        assertEquals(3, actual.val);
        actual = actual.next;
        assertEquals(5, actual.val);

    }
}