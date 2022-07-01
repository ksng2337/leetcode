/**
 Runtime: 2 ms, faster than 91.69% of Java online submissions for Jump Game.
 Memory Usage: 43.1 MB, less than 85.73% of Java online submissions for Jump Game.
 */
class Solution {
    public boolean canJump(int[] nums) {
        // determine by checking if there is any zero
        // that must reach no matter how to jump
        int zeroIndex = -1;

        // start from the end, no need to check last index
        for (int i = nums.length - 2; i >= 0; i--) {

            if (zeroIndex != -1) {
                // check if current step must step to zero index
                if (i + nums[i] > zeroIndex) {
                    zeroIndex = -1;
                }
            } else {
                if (nums[i] == 0) {
                    zeroIndex = i;
                }
            }
        }

        return zeroIndex == -1;
    }
}
