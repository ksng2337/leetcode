/** 
 Runtime: 1 ms, faster than 92.53% of Java online submissions for Binary Tree Level Order Traversal.
 Memory Usage: 43.8 MB, less than 33.89% of Java online submissions for Binary Tree Level Order Traversal.
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root != null) {
            result.add(new LinkedList<Integer>());
            result.get(0).add(root.val);
            addToList(result, root, 1);
        }
        
        return result;
    }
    
    private void addToList(List<List<Integer>> result, TreeNode node, int level) {
        if (node.left != null) {
            if (result.size() <= level) {
                result.add(new LinkedList<Integer>());
            }
            result.get(level).add(node.left.val);
            addToList(result, node.left, level + 1);
        }
        if (node.right != null) {
            if (result.size() <= level) {
                result.add(new LinkedList<Integer>());
            }
            result.get(level).add(node.right.val);
            addToList(result, node.right, level + 1);
        }
    }
}