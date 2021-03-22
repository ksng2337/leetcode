/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
 * Memory Usage: 36.6 MB, less than 98.28% of Java online submissions for Remove Nth Node From End of List.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> nodes = new ArrayList<ListNode>();
        while (head.next != null) {
            nodes.add(head);
            head = head.next;
        }
        // add last item
        nodes.add(head);
        
        //special cases
        if (n == nodes.size()) {
            // remove first item, so return 2nd item
            if (nodes.size() > 1) {
                return nodes.get(1);
            } else {
                // remove the only item, return null
                return null;
            }
        } else {
           // normal remove    
            nodes.get(nodes.size() - n - 1).next = nodes.get(nodes.size() - n).next;
            return nodes.get(0);
        }
    }
}
