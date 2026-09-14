class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> finalList = new ArrayList<>();

        int ind = 0;

        while(ind < intervals.length && intervals[ind][1] < newInterval[0])
        {
            finalList.add(intervals[ind]);
            ind++;
            
        }

        //now we found overlap
        int[] merged = newInterval;

        //while there's overlap start merging
        while(ind < intervals.length && intervals[ind][0] <= merged[1])
        {
            merged[0] = Math.min(merged[0], intervals[ind][0]);
            merged[1] = Math.max(merged[1], intervals[ind][1]);
            ind++;
        }

        finalList.add(merged);


        while(ind < intervals.length)
        {
            finalList.add(intervals[ind]);
            ind++;
        }

        return finalList.toArray(new int[0][]);

    }
}