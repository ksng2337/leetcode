/**
 * Runtime: 1 ms, faster than 74.91% of Java online submissions for Merge Two Sorted Lists.
 * Memory Usage: 43.3 MB, less than 34.83% of Java online submissions for Merge Two Sorted Lists.
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode first = null;
        ListNode last = null;

        if (list1 == null && list2 == null) {
            return null;
        } else if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else {
            if (list1.val > list2.val) {
                first = list2;
                list2 = list2.next;
            } else {
                first = list1;
                list1 = list1.next;
            }
            last = first;
        }

        while (list1 != null || list2 != null) {

            if (list1 == null) {
                // add remains list2
                last.next = list2;
                list2 = null;
            } else if (list2 == null) {
                // add remains list1
                last.next = list1;
                list1 = null;
            } else {
                if (list1.val > list2.val) {
                    last.next = list2;
                    last = list2;
                    list2 = list2.next;
                } else {
                    last.next = list1;
                    last = list1;
                    list1 = list1.next;
                }
            }
        }

        return first;
    }
}