class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i = 1; i <= k; i++){
            pq.add(nums[i - 1]);
        }
        for(int i = k; i < nums.length; i++){
            if(nums[i] > pq.peek()){
                pq.poll();
                pq.add(nums[i]);
            }
        }
        return pq.isEmpty() ? -1 : pq.peek();
    }
}