/** 
 Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
 Memory Usage: 44.4 MB, less than 18.07% of Java online submissions for Validate Binary Search Tree.
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
    public boolean isValidBST(TreeNode root) {
        return validate(root, -Double.MAX_VALUE, Double.MAX_VALUE);
    }
    
    private boolean validate(TreeNode node, double min, double max) {
        if (node == null) {
            return true;
        } else if (node.val >= max || node.val <= min) {
            return false;
        } else {
            return validate(node.left, min, node.val) &&
                validate(node.right, node.val, max);
        }
    }
}