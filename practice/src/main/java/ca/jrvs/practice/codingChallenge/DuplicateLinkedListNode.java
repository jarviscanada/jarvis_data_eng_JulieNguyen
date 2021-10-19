package ca.jrvs.practice.codingChallenge;


import java.util.HashSet;
import java.util.Set;

/** Challenge: Remove duplicates from LinkedList
 *  https://www.notion.so/jarvisdev/Duplicate-LinkedList-Node-9cc25d36b11c475b8254f5e4e4434c7b
 */

public class DuplicateLinkedListNode {
    //O(n) as the function iterates through the LinkedList at worst one full iteration
    public ListNode removeDuplicates(ListNode head){
        ListNode node = head;
        if(head==null)
            return head;

        Set<ListNode> set = new HashSet<ListNode>();

        while(node!=null){
            if(set.contains(node))
                node.next = node.next.next;
            else {
                set.add(node);
                node = node.next;
            }
        }

        return head;
    }
}