/** 
 Runtime: 3 ms, faster than 67.17% of Java online submissions for Best Time to Buy and Sell Stock.
 Memory Usage: 83.9 MB, less than 43.11% of Java online submissions for Best Time to Buy and Sell Stock.
 */
class Solution {
    public int maxProfit(int[] prices) {
        int start = 0;
        int max = 0;
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[start]) {
                start = i;
            } else {
                max = Math.max(max, prices[i] - prices[start]);
            }
        }
        return max;
    }
}