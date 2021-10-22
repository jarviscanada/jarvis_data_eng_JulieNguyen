package ca.jrvs.practice.codingChallenge;

import java.util.ArrayList;
import java.util.List;

/** Challenge: Linked List Cycles
 *  https://www.notion.so/jarvisdev/LinkedList-Cycle-213ead8f7f18415a9d3c1098f8d71dde
 */

public class LinkedListCycle {
    //O(n) as while loop can iterate through full LinkedList in worst case.
    public boolean hasCycle(ListNode head) {
        ListNode node = head;
        List<ListNode> list = new ArrayList<ListNode>();

        while(node!=null){
            node = node.next;
            if(list.contains(node))
                return true;
            else
                list.add(node);
        }

        return false;
    }
}