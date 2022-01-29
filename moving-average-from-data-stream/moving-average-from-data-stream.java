class MovingAverage {
    private Deque<Integer> queue;
    private int maxSize;
    private double average;
    public MovingAverage(int size) {
        maxSize = size;
        queue = new ArrayDeque<Integer>(size);
        average = 0.0;
    }
    
    public double next(int val) {
        int currSize = queue.size();
        double sum = average * currSize;
        if(currSize == maxSize){
            Integer polVal = queue.poll();            
            sum -= polVal;
        }
        sum += val;
        queue.offer(val);
        average = sum/queue.size();
        return average;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */