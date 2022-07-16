/** 
 Runtime: 3 ms, faster than 98.83% of Java online submissions for Valid Palindrome.
 Memory Usage: 43.5 MB, less than 67.06% of Java online submissions for Valid Palindrome.
 */
class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        boolean valid = true;
        while (valid && start < end) {
            while (!validChar(s.charAt(start)) && start < s.length() - 1) {
                start++;
            }
            while (!validChar(s.charAt(end)) && end > 0) {
                end--;
            }
            if (match(s.charAt(start), s.charAt(end))) {
                start++;
                end--;
            } else if (start < end) {
                valid = false;
            }
        }
        
        return valid;
    }
    
    private boolean validChar(char c) {
        return ((c >= '0' && c <= '9')
                || (c >= 'A' && c <= 'Z')
                || (c >= 'a' && c <= 'z'));
    }
    
    private boolean match(char a, char b) {
        if (a == b) {
            return true;
        } else if (Math.abs(a - b) == 32 && a >= 65 && b >= 65) {
            // upper & lower case
            return true;
        } else {
            return false;
        }
    }
}