class KthLargest {
    private PriorityQueue<Integer> stream;
    private int k;
    
    public KthLargest(int k, int[] nums) {
        stream = new PriorityQueue();
        this.k = k;

        for(int n : nums){
            if(stream.size() < k){
                stream.add(n);
            }else {
                if(n > stream.peek()){
                    stream.add(n);
                    stream.poll();
                }
            }                       
        }       
    }
    public int add(int val) {
        if(stream.size() < k){
            stream.add(val);
        }
        else if(val > stream.peek()){
            stream.add(val);
            stream.poll();
        }
        else {
            //skip
        }
        return stream.peek();        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */