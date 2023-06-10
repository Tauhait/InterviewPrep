class MeetingTiming {
    Integer start;
    Integer end;
    public MeetingTiming(int start, int end){
        this.start = start;
        this.end = end;
    }
}
class MeetingStartComparator implements Comparator<MeetingTiming> {
    public int compare(MeetingTiming t1, MeetingTiming t2){
        int endCompare = t1.end.compareTo(t2.end);
        int startCompare =  t1.start.compareTo(t2.start);
        return startCompare == 0 ? endCompare : startCompare;
    }
}
class MeetingEndComparator implements Comparator<MeetingTiming> {
    public int compare(MeetingTiming t1, MeetingTiming t2){
        int endCompare = t1.end.compareTo(t2.end);
        int startCompare =  t1.start.compareTo(t2.start);
        return endCompare == 0 ? startCompare : endCompare;
    }
}
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        // add your code here
        LinkedList<MeetingTiming> ll = new LinkedList<>();
        for(int i = 0; i < n; i++){
            ll.add(new MeetingTiming(intervals[i][0], intervals[i][1]));
        }

        MeetingStartComparator meetStartComparator = new MeetingStartComparator();
        MeetingEndComparator meetEndComparator     = new MeetingEndComparator();
        Collections.sort(ll, meetStartComparator);        
        PriorityQueue<MeetingTiming> pq = new PriorityQueue<>(meetEndComparator);
        int minRooms = 0;
        for(int i = 0; i < n; i++){
            if(!pq.isEmpty() && 
                ll.get(i).start.compareTo(pq.peek().end) >= 0){
                pq.poll();
            }
            MeetingTiming thisMeet = ll.get(i);
            pq.add(thisMeet);
            minRooms = Math.max(minRooms, pq.size());
        }
        return minRooms;
    }
}