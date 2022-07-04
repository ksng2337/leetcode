/**
 Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
 Memory Usage: 41.1 MB, less than 33.98% of Java online submissions for Unique Paths.
 */
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] map = new int[m][n];
        map[0][0] = 1;
        return calSteps(map, m - 1, n - 1);
    }
    
    private int calSteps(int[][] map, int m, int n) {
        if (map[m][n] != 0 && m >= 0 && n >= 0) {
            return map[m][n];
        } else {
            if (m > 0 && n > 0) {
                int c1 = calSteps(map, m - 1, n);
                int c2 = calSteps(map, m, n - 1);
                map[m][n] = c1 + c2;
                return c1 + c2;
            } else if (m == 0 || n == 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}