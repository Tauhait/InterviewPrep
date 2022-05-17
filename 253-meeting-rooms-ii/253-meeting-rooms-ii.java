class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> endTimePQ = new PriorityQueue();
        
        
        for(int[] thisInterval : intervals){            
            if(endTimePQ.isEmpty() || thisInterval[0] < endTimePQ.peek()){
                endTimePQ.add(thisInterval[1]);
            }else {
                endTimePQ.poll();
                endTimePQ.add(thisInterval[1]);
            }
        }
        return endTimePQ.size();
    }
}