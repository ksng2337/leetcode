/**
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Maximum Subarray.
 * ZMemory Usage: 52 MB, less than 83.48% of Java online submissions for Maximum Subarray.
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int total = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (total > 0) {
                total += nums[i];
            } else {
                // if subtotal is less than 0, just abandon previous number
                total = nums[i];
            }
            if (total > max) {
                max = total;
            }
        }
        return max;
    }
}