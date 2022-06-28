/**
 * Runtime: 8 ms, faster than 89.25% of Java online submissions for Group Anagrams.
 * Memory Usage: 45.1 MB, less than 97.19% of Java online submissions for Group Anagrams.
 */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<List<String>>();
        if (strs.length == 1) {
            results.add(Arrays.asList(strs[0]));
        } else {
            Map<String, List<String>> map = new HashMap<String, List<String>>();
            for (int i = 0; i < strs.length; i++) {
                String key = getSortedString(strs[i]);
                if (map.containsKey(key)) {
                    map.get(key).add(strs[i]);
                } else {
                    map.put(key, new ArrayList<String>(Arrays.asList(strs[i])));
                }
            }
            for (String key : map.keySet()) {
                results.add(map.get(key));
            }
        }
        return results;
    }

    private String getSortedString(String input) {
        char[] sortedChars = input.toCharArray();
        Arrays.sort(sortedChars);
        return new String(sortedChars);
    }
}