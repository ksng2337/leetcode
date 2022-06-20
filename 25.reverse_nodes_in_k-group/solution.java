/**
Runtime: 1 ms, faster than 58.21% of Java online submissions for Reverse Nodes in k-Group.
Memory Usage: 45.4 MB, less than 65.20% of Java online submissions for Reverse Nodes in k-Group.
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
    
    private ListNode[] reverseNode(ListNode head) {
        ListNode prev = null;
        ListNode it = head;
        while (it != null) {
            ListNode next = it.next;
            it.next = prev;
            prev = it;
            it = next;
        }
        ListNode[] result = {prev, head};
        return result;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode newList = null;
        ListNode newListEnd = null;
        ListNode it = head;
        ListNode start = head;
        int index = 0;
        while (it != null) {
            index++;
            if (index == k) {
                ListNode next = it.next;
                it.next = null;
                ListNode[] newHead = reverseNode(start);
                
                if (newList == null) {
                    newList = newHead[0];
                    newListEnd = newHead[1];
                } else {
                    newListEnd.next = newHead[0];
                    newListEnd = newHead[1];
                }
                index = 0;
                it = next;
                start = next;
                
            } else {
                it = it.next;
            }
        }
        
        if (start != null) {
            newListEnd.next = start;
        }
        
        return newList;
    }
}