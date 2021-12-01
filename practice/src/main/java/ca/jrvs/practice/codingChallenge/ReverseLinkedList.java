package ca.jrvs.practice.codingChallenge;

import java.util.ArrayList;
import java.util.List;

/**Challenge: Reverse Linked List
 * https://www.notion.so/jarvisdev/Reverse-Linked-List-ba9d7bd6427342e38c94dab863572b3e
 */

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {

        List<Integer> list = new ArrayList<Integer>();
        ListNode node = head;
        int size = 0;

        while(node!=null){
            list.add(node.val);
            node = node.next;
        }

        node = head;

        for(int i=list.size()-1; i>=0; i--){
            node.val = list.get(i);
            node = node.next;
        }

        return head;
    }
}