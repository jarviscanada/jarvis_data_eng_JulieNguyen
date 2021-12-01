package ca.jrvs.practice.codingChallenge;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseLinkedListTest {

    ListNode head;
    ReverseLinkedList rll;
    ListNode fifth;

    @Before
    public void setUp() throws Exception {
        rll = new ReverseLinkedList();

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

    }

    @Test
    public void reverseList() {
        ListNode actual = rll.reverseList(head);
        assertEquals(5, actual.val);
        actual = actual.next;
        assertEquals(4, actual.val);
        actual = actual.next;
        assertEquals(3, actual.val);
        actual = actual.next;
        assertEquals(2, actual.val);
        actual = actual.next;
        assertEquals(1, actual.val);
    }
}