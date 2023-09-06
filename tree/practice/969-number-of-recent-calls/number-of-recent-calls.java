class RecentCounter {
    Queue<Integer> q; 
    int count;
    public RecentCounter() {
        q = new LinkedList<>();
        count = 0;
    }
    
    public int ping(int t) {
        int startTime = 0;
        if(!q.isEmpty()) {
            startTime = q.peek();
        } else {
            startTime = t;
        }
        q.offer(t);
        count++;
        while(!q.isEmpty() && (t - startTime) > 3000) {
            q.poll();
            count--;
            startTime = q.peek();
        }
        return count;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */