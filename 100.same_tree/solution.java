/** 
 Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
 Memory Usage: 39.4 MB, less than 99.58% of Java online submissions for Same Tree.
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return validate(p, q);
    }
    
    private boolean validate(TreeNode node1, TreeNode node2) {
        if ((node1 != null && node2 != null && node1.val != node2.val) || 
            (node1 == null && node2 != null) ||
            (node1 != null && node2 == null)) {
            return false;
        } else if (node1 == null && node2 == null) {
            return true;
        } else {
            return validate(node1.left, node2.left) &&
                validate(node1.right, node2.right);
        }
    }
}