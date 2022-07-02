/**
 Runtime: 2 ms, faster than 79.88% of Java online submissions for Insert Interval.
 Memory Usage: 44.9 MB, less than 83.59% of Java online submissions for Insert Interval.
 */
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new LinkedList<int[]>();
        boolean added = false;
        boolean merged = false;

        if (intervals.length == 0) {
            result.add(newInterval);
        } else {
            // Check if should be added first
            if (!isOverlap(intervals[0], newInterval)) {
                if (newInterval[1] < intervals[0][0]) {
                    // newInterval is either the 1st of the final list
                    result.add(newInterval);
                    added = true;
                }
                result.add(intervals[0]);
            } else {
                result.add(mergeInterval(intervals[0], newInterval));
                merged = true;
            }

            for (int i = 1; i < intervals.length; i++) {
                if (!added) {
                    if (!merged) {
                        result.add(intervals[i]);
                    }

                    // check if newInterval overlap the latest interval
                    int lastIndex = result.size() - 1;

                    if (isOverlap(intervals[i], newInterval)) {
                        int[] temp = mergeInterval(intervals[i], newInterval);
                        result.set(lastIndex, mergeInterval(result.get(lastIndex), temp));
                        merged = true;
                    } else {
                        if (merged) {
                            added = true;
                            result.add(intervals[i]);
                        } else {
                            // newInterval not overlapping any existing interval
                            if (newInterval[1] < intervals[i][0]) {
                                result.set(lastIndex, newInterval);
                                result.add(intervals[i]);
                                added = true;
                            }
                        }
                    }
                } else {
                    result.add(intervals[i]);
                }
            }

            if (!added && !merged) {
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }

    private boolean isOverlap(int[] a, int[] b) {
        return !(a[1] < b[0] || b[1] < a[0]);
    }

    private int[] mergeInterval(int[] a, int[] b) {
        return new int[] {Math.min(a[0], b[0]), Math.max(a[1], b[1])};
    }
}