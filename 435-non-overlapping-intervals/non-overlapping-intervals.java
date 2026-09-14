class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n <= 1)
        {
            return 0;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));


        int[] lastInterval = intervals[0];
        int result = 0;
        for(int i = 1; i < n; i++)
        {
            //check overlap
            if(intervals[i][0] < lastInterval[1] && lastInterval[0] < intervals[i][1])
            {
                result++;
            }
            else
            {
                lastInterval = intervals[i];
            }
        }

        return result;
    }
}