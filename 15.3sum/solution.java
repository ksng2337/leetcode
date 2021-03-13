/* Runtime: 49 ms, faster than 38.94% of Java online submissions for 3Sum.
 * Memory Usage: 42.4 MB, less than 98.22% of Java online submissions for 3Sum.
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> sorted = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.sort(sorted);
        int index = 0;
        
	// Pick each number to be first number
        while (index < sorted.size() - 2) {
            int value = sorted.get(index);

	    // Find if there is any pairs in remaining array that sum of three number is 0
            List<List<Integer>> match = findPairs(sorted, index);
            if (match.size() > 0) {
                result.addAll(match);
            }

	    // skip repeated numbers for the first pick
            while (index < sorted.size() - 2 && sorted.get(index) == value) {
                index++;
            }
        }
        return result;
    }
    
    private List<List<Integer>> findPairs(List<Integer> sorted, int index) {
        int target = -sorted.get(index);
        int start = index + 1;
        int end = sorted.size() - 1;
        List<List<Integer>> result = new ArrayList();
        
        while (start < end) {
            int stVal = sorted.get(start);
            int edVal = sorted.get(end);
            int value = stVal + edVal;
            if (value == target) {
                // matched, return result
                result.add(Arrays.asList(sorted.get(start), sorted.get(end), sorted.get(index)));

		// Update 2nd and 3rd number index
                while (start < sorted.size() && sorted.get(start) == stVal) {
                    start++;
                }
                while (end > start && sorted.get(end) == edVal) {
                    end--;
                }
            } else if (value < target) {
		// As numbers are sorted, only picking larger number would be possible to reach target
                start++;
            } else {
		// Same as above
                end--;
            }
        }
        
        return result;
    }
}

