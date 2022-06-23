/**
 * Runtime: 6 ms, faster than 58.72% of Java online submissions for Combination Sum.
 * Memory Usage: 42.7 MB, less than 89.89% of Java online submissions for Combination Sum.
 */
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = Arrays.stream(candidates).boxed().collect(Collectors.toList());
        Collections.sort(list);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        findMatch(list, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void findMatch(List<Integer> list, int index, int target,
                           List<Integer> picked, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(picked));
        } else {
            for (int i = index; i < list.size(); i++) {
                // already matched target
                if (target - list.get(i) >= 0) {
                    // still have space, add more
                    picked.add(list.get(i));
                    findMatch(list, i, target - list.get(i), picked, ans);
                    picked.remove(list.get(i));
                } else {
                    break;
                }
            }
        }
    }
}