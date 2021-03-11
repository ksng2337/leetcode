/*
 * Runtime: 2 ms, faster than 96.04% of Java online submissions for Container With Most Water.
 * Memory Usage: 52.7 MB, less than 7.86% of Java online submissions for Container With Most Water.
 */
class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int max = area(start, end, height);

        // move 2 pointers along the array       
        while (start < end) {

            // always pick the higher one as only this is possible to
            // increase max area
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }

            // update max area if area is greater
            if (area(start, end, height) > max) {
                max = area(start, end, height);
            }
        }
        
        return max;
    }
    
    private int area(int start, int end, int[] height) {
        return Math.min(height[start], height[end]) * (end - start);
    }
}
