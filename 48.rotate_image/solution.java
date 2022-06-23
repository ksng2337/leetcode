/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
 * Memory Usage: 42.6 MB, less than 61.42% of Java online submissions for Rotate Image.
 */
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];

        for (int x = 0; x < n; x++) {
            for (int y = n - 1; y >= 0; y--) {
                rotated[x][n - y - 1] = matrix[y][x];
            }
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                matrix[x][y] = rotated[x][y];
            }
        }
    }
};