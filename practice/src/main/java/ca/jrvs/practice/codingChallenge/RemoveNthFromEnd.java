package ca.jrvs.practice.codingChallenge;

public class RemoveNthFromEnd {

    //O(n) solution as it traverses through the LinkedList once with no nested traversal.
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;

        for(int i=0; i<n; i++){
            fast = fast.next;
        }

        if(fast==null) {
            head=head.next;
        } else {
            while(fast.next!=null) {
                fast = fast.next;
                slow = slow.next;
            }

            slow.next = slow.next.next;
        }

        return head;
    }

}