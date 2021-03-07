/* Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum.
 * Memory Usage: 38.8 MB, less than 97.05% of Java online submissions for Two Sum.
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // store existing number in map and check if complement exists
        HashMap<Integer, Integer> mapping = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            // if map already contains complement, return answer directly
	    if (mapping.containsKey(target - nums[i])) {
                return new int[]{i, mapping.get(target - nums[i])};
            } else {
                // add the number to map as it might be other number's complement
                mapping.put(nums[i], i);
            }
        }
        // won't reach here as it must contain exact 1 pair of answer
        return new int[]{0, 0};
    }
}

