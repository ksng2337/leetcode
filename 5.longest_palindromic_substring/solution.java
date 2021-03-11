/**
 * Runtime: 27 ms, faster than 61.13% of Java online submissions for Longest Palindromic Substring.
 * Memory Usage: 39.3 MB, less than 56.79% of Java online submissions for Longest Palindromic Substring.
 */
class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        int start = 0;
        // loop through the string to find palindrome
        for (int i = 0; i < s.length(); i++) {
	    // check if previous and next char are the same and keep extend
            // odd length case
            int len = 0;
            while (i - len >= 0 && i + len < s.length() &&
                  s.charAt(i - len) == s.charAt(i + len)) {
                len++;
            }
            len--;
            if (max < len * 2 + 1) {
                max = len * 2 + 1;
                start = i - len;
            }
            
            // even length case
            len = 0;
            while (i - len >= 0 && i + len + 1< s.length() &&
                  s.charAt(i - len) == s.charAt(i + len + 1)) {
                len++;
            }
            
            if (max < len * 2) {
                max = len * 2;
                start = i - len + 1;
            }
        }
        return s.substring(start, start + max);
    }
}

