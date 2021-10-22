package ca.jrvs.practice.codingChallenge;

import junit.framework.TestCase;
import org.junit.Before;

public class DuplicateLinkedListNodeTest extends TestCase {

    ListNode head;
    DuplicateLinkedListNode dlln = new DuplicateLinkedListNode();

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    public void testRemoveDuplicates() {
        ListNode head, second, third, fourth;
        head = new ListNode(1);
        second = new ListNode(2);
        third = new ListNode(3);
        fourth = new ListNode(4);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = null;

        ListNode actual = dlln.removeDuplicates(head);

        assertEquals(head, actual);
        assertEquals(head.next, actual.next);
        assertEquals(head.next.next, actual.next.next);
        assertEquals(head.next.next.next, actual.next.next.next);

        third.val = 1;
        ListNode expected, second2, third2;
        expected = new ListNode(1);
        second2 = new ListNode(2);
        third2 = new ListNode(4);
        expected.next = second2;
        second2.next = third2;
        third2.next = null;

        ListNode actual2 = dlln.removeDuplicates(head);

        assertEquals(expected, actual2);
        assertEquals(expected.next, actual2.next);
        assertEquals(expected.next.next, actual2.next.next);


    }
}