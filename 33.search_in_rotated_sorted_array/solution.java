/**
 * Runtime: 1 ms, faster than 69.83% of Java online submissions for Search in Rotated Sorted Array.
 * Memory Usage: 42.9 MB, less than 30.88% of Java online submissions for Search in Rotated Sorted Array.
 */
class Solution {

    private int findPivot(int[] nums, int start, int end) {
        int index = (start + end) / 2;
        if (start >= end || index >= nums.length) {
            return -1;
        } else if (nums[index] > nums[index + 1]) {
            // found pivot
            return index;
        }

        if (nums[start] > nums[index]) {
            // pivot is here
            return findPivot(nums, start, index);
        } else if (nums[index] > nums[end]) {
            return findPivot(nums, index, end);
        } else {
            return -1;
        }
    }

    private int bSearch(int[] nums, int target, int start, int end) {
        int index = (start + end - 1) / 2;
        if (nums[index] == target) {
            return index;
        } else if (start >= end) {
            return -1;
        } else if (nums[index] < target) {
            return bSearch(nums, target, index + 1, end);
        } else {
            return bSearch(nums, target, start, index);
        }
    }

    public int search(int[] nums, int target) {
        // find if the list is rotated
        int pivot = findPivot(nums, 0, nums.length - 1);
        if (pivot == -1) {
            return bSearch(nums, target, 0, nums.length);
        } else {
            // separate 2 list and search twice
            int result = bSearch(nums, target, 0, pivot + 1);
            if (result == -1) {
                result = bSearch(nums, target, pivot + 1, nums.length);
            }
            return result;
        }
    }
}