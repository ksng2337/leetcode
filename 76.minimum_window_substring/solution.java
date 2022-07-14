/**
 Runtime: 27 ms, faster than 38.77% of Java online submissions for Minimum Window Substring.
 Memory Usage: 44 MB, less than 72.23% of Java online submissions for Minimum Window Substring.
 */
class Solution {
    public String minWindow(String s, String t) {
        
        int[] tempList = new int[64];
        int[] tList = new int[64];
        int[] sList = new int[64];
        
        for (int i = 0; i < s.length() ; i++) {
            sList[s.charAt(i) - 64]++;
        }
        
        for (int i = 0; i < t.length() ; i++) {
            tList[t.charAt(i) - 64]++;
        }
        
        if (!containsSubString(sList, tList)) {
            return "";
        } else {
            int start = 0;
            int end = t.length();
            int minStart = 0;
            int minLength = s.length();
            
            for (int i = 0; i < t.length(); i++) {
                tempList[s.charAt(i) - 64]++;
            }
            while (start < s.length()) {
                if (!containsSubString(tempList, tList)) {
                    end++;
                    if (end > s.length()) {
                        end--;
                        start++;
                        tempList[s.charAt(start - 1) - 64]--;
                    } else {
                        tempList[s.charAt(end - 1) - 64]++;
                    }
                } else {
                    if (end - start < minLength) {
                        minStart = start;
                        minLength = end - start;
                    }
                    start++;
                    tempList[s.charAt(start - 1) - 64]--;
                }
            }
            return String.copyValueOf(s.toCharArray(), minStart, minLength);
        }

    }
    
    private boolean containsSubString(int[] s, int[] t) {
        for (int i = 0; i < s.length; i++) {
            if (s[i] < t[i]) {
                return false;
            }
        }
        return true;
    }
    
}