class MedianFinder {
    private PriorityQueue<Integer> lo;
    private PriorityQueue<Integer> hi;

    public MedianFinder() {
        lo = new PriorityQueue<>(Collections.reverseOrder());//max-heap
        hi = new PriorityQueue<>();//min-heap
    }
    
    public void addNum(int num) {
        lo.add(num);
        hi.add(lo.poll()); //balancing step;
        //when total number of elements are even, then balancing step is useful 
        //otherwise, if size of lo < hi then we again put the median back in lo
        if(lo.size() < hi.size()){ lo.add(hi.poll()); }     
    }
    
    public double findMedian() {
        return lo.size() > hi.size() ?  lo.peek() : 
                                        ((double)(lo.peek() + hi.peek())/2.0);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */