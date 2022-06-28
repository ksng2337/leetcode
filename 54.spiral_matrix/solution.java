/**
 Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.
 Memory Usage: 42.1 MB, less than 52.74% of Java online submissions for Spiral Matrix.
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int w = matrix[0].length;
        int h = matrix.length;
        int level = 0;
        List<Integer> result = new ArrayList<Integer>();
        while (result.size() < w * h) {
            for (int i = level; i < w - level; i++) {
                // top
                result.add(matrix[level][i]);
            }
            if (result.size() < w * h) {
                for (int i = level + 1; i < h - level; i++) {
                    // right
                    result.add(matrix[i][w - level - 1]);
                }
            }
            if (result.size() < w * h) {
                for (int i = w - level - 2; i >= level; i--) {
                    // bottom
                    result.add(matrix[h - level - 1][i]);
                }
            }
            if (result.size() < w * h) {
                for (int i = h - level - 2; i > level; i--) {
                    // left
                    result.add(matrix[i][level]);
                }
            }
            level++;
        }
        return result;
    }
}