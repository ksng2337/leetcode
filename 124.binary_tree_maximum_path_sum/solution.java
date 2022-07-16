/** 
 Runtime: 1 ms, faster than 99.67% of Java online submissions for Binary Tree Maximum Path Sum.
 Memory Usage: 47.9 MB, less than 38.84% of Java online submissions for Binary Tree Maximum Path Sum.
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
    
    private int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        findMax(root);
        return max;
    }
    
    private int findMax(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int leftMax = Math.max(0, findMax(node.left));
        int rightMax = Math.max(0, findMax(node.right));
        
        // update max if including this node in the path
        max = Math.max(max, leftMax + rightMax + node.val);
        
        // return max value that only picking left or right
        return Math.max(leftMax, rightMax) + node.val;
        
    }
    
}