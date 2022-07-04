/**
 Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
 Memory Usage: 41.1 MB, less than 34.11% of Java online submissions for Climbing Stairs.
 */
class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            int[] cache = new int[n];
            cache[0] = 1;
            cache[1] = 2;
            return calSteps(cache, n - 1);
        }
    }
    
    private int calSteps(int[] cache, int n) {
        if (cache[n] != 0) {
            return cache[n];
        } else {
            int steps = calSteps(cache, n - 1) + calSteps(cache, n - 2);
            cache[n] = steps;
            return steps;
        }
    }
}