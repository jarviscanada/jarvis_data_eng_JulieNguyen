package ca.jrvs.practice.codingChallenge;

public class MiddleOfLinkedList {

    //O(n)
    public ListNode middleNode(ListNode head) {
        ListNode node = head;

        int length = 1;
        while(node.next!=null){
            length++;
            node = node.next;
        }

        if(length==1)
            return head;

        int mid = (int) Math.ceil(length/2);

        node = head;
        int i = 0;
        while(i<mid&&node!=null){
            i++;
            node = node.next;
        }

        return node;
    }

}