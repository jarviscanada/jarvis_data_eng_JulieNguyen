package ca.jrvs.practice.codingChallenge;

import junit.framework.TestCase;

public class MiddleOfLinkedListTest extends TestCase {

    ListNode head;
    MiddleOfLinkedList mid;
    ListNode fifth;

    public void setUp() throws Exception {
        super.setUp();

        head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        fifth = new ListNode(5);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;

        mid = new MiddleOfLinkedList();
    }

    public void testMiddleNode() {
        ListNode actual = mid.middleNode(head);

        assertEquals(3, actual.val);
        actual = actual.next;
        assertEquals(4, actual.val);
        actual = actual.next;
        assertEquals(5, actual.val);
    }

    public void testMiddleNode2() {
        ListNode sixth = new ListNode(6);
        fifth.next = sixth;
        sixth.next = null;

        ListNode actual = mid.middleNode(head);

        assertEquals(4, actual.val);
        actual = actual.next;
        assertEquals(5, actual.val);
        actual = actual.next;
        assertEquals(6, actual.val);
    }
}