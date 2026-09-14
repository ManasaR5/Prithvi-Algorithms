class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int[] interval: intervals)
        {
            int start = interval[0];
            int end = interval[1];

            if(!minHeap.isEmpty() && start >= minHeap.peek())
            {
                minHeap.poll();
            }
            minHeap.offer(end);
        }

        return minHeap.size();
    }
}