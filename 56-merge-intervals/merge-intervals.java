class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        if(n <= 1)
        {
            return intervals;
        }

        List<int[]> merged = new ArrayList<>();

        merged.add(intervals[0]);

        for(int i = 1; i < intervals.length; i++)
        {
            //check overlap with last item
            int[] lastInterval = merged.get(merged.size() - 1);
            if(lastInterval[0] <= intervals[i][1] && intervals[i][0] <= lastInterval[1])
            {
                lastInterval[0] = Math.min(lastInterval[0], intervals[i][0]);
                lastInterval[1] = Math.max(lastInterval[1], intervals[i][1]);
            }
            else
            {
                merged.add(intervals[i]);
            }
        }

        return merged.toArray(new int[0][]);
    }
}