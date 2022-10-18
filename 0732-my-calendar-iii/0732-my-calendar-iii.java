class MyCalendarThree {
    Map<Integer,Integer> calendar;//Tree-Map

    public MyCalendarThree() {
        calendar = new TreeMap<Integer,Integer>();
    }
    
    public int book(int startTime, int endTime) {        
        calendar.put(startTime, calendar.getOrDefault(startTime,0)+1);
        calendar.put(endTime, calendar.getOrDefault(endTime,0)-1);
        
        int currentIntersect = 0, maxIntersect = 0;
        for(int val : calendar.values()){
            currentIntersect += val;
            maxIntersect = Math.max(maxIntersect, currentIntersect);
        }
        return maxIntersect;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */