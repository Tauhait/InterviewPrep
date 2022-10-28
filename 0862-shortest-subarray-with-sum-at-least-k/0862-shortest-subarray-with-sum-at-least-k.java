class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        Deque<Pair<Integer,Long>> monoQ = new LinkedList<Pair<Integer,Long>>();
        int shortest = Integer.MAX_VALUE;
        long currentSum = 0;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            currentSum += num;
            if(currentSum >= k){
                shortest = Math.min(shortest, i+1);
            }
            Pair<Integer,Long> p = null;
            while(!monoQ.isEmpty() && currentSum-monoQ.getFirst().getValue() >= k){
                p = monoQ.removeFirst();
            }
            if(p != null){
                shortest = Math.min(shortest, i-p.getKey());
            }
            while(!monoQ.isEmpty() && currentSum <= monoQ.getLast().getValue()){
                monoQ.removeLast();
            }
            monoQ.add(new Pair(i,currentSum));
        }
        return shortest == Integer.MAX_VALUE ? -1 : shortest;
    }
}