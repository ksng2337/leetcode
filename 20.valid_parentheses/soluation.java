/* 
 * Runtime: 1 ms, faster than 98.63% of Java online submissions for Valid Parentheses.
 * Memory Usage: 37.4 MB, less than 25.76% of Java online submissions for Valid Parentheses.
 */
class Solution {
    public boolean isValid(String s) {
        boolean result = true;
        Stack<Character> charStack = new Stack<>();
        charStack.push(s.charAt(0));
        
        // loop the string to check
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                charStack.push(s.charAt(i));
            } else {
                // case that don't have {[( in stack
                if (charStack.size() == 0) {
                    result = false;
                    break;
                }
                char check = charStack.pop();
                // case that current char don't match
                if (!((check == '{' && s.charAt(i) == '}') ||
                    (check == '[' && s.charAt(i) == ']') ||
                    (check == '(' && s.charAt(i) == ')'))) {
                    // not match, return false;
                    result = false;
                    break;
                }
            }
        }
        
        // false if anything remain in the stack
        if (charStack.size() > 0) {
            result = false;
        }
        return result;
    }
}
