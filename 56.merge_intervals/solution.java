/**
 Runtime: 14 ms, faster than 52.38% of Java online submissions for Merge Intervals.
 Memory Usage: 55 MB, less than 64.77% of Java online submissions for Merge Intervals.
 */
class Solution {
    public int[][] merge(int[][] intervals) {

        // sort the intervals first
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> list = new ArrayList<int[]>();
        list.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] lastItem = list.get(list.size() - 1);
            if (intervals[i][0] > lastItem[1]) {
                // not overlapping, add new item
                list.add(intervals[i]);
            } else {
                if (lastItem[1] < intervals[i][1]) {
                    lastItem[1] = intervals[i][1];
                }
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
