class KthLargest {
    private PriorityQueue<Integer> stream;
    private int k;
    // private int largest;
    
    public KthLargest(int k, int[] nums) {
        stream = new PriorityQueue();
        this.k = k;
        // largest = Integer.MIN_VALUE;

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
        // if(stream.size() > 0){
        //     findKthLargest(stream.size());
        // }        
    }
//     private void findKthLargest(int size){
//         List<Integer> pqList = new ArrayList();
//         int i = 1;
//         while(i < k && i <= size){
//             i++;
//             // pqIter = pqIter.next();
//             pqList.add(stream.poll());
//             // System.out.print(pqIter.next());
//         }
//         // System.out.println();
//         if(stream.size() > 0){
//             largest = stream.peek();
//         }
        
//         for(Integer l : pqList){
//             stream.add(l);
//         }
        
//     }
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