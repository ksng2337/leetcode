/* Runtime: 5 ms, faster than 82.01% of Java online submissions for Longest Substring Without Repeating Characters.
 * Memory Usage: 39.2 MB, less than 56.68% of Java online submissions for Longest Substring Without Repeating Characters.
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int start = 0; 

        for (int i = 0; i < s.length(); i++) {
           // if selection has duplicate char 
	   if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= start) {
                max = Math.max(max, i - start);
		// update start index to be the index after the duplicate char
                start = map.get(s.charAt(i)) + 1;
                // update duplicate char's index in hashmap
		map.replace(s.charAt(i), i);
            } else {
		// new char is not duplicated, add to hashmap
                map.put(s.charAt(i), i);
            }
        }
        // handle case that the substring is at the end of the original string
        return Math.max(max, s.length() - start);
    }
}
