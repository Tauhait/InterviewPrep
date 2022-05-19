class Solution {
    public int connectSticks(int[] sticks) {
        int sum = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        for(int stick : sticks){
            minHeap.add(stick);
        }
        
        while(minHeap.size() > 1){
            int stickA = minHeap.poll();
            int stickB = minHeap.poll();
            int stickSum = stickA + stickB;
            sum += stickSum;
            minHeap.add(stickSum);
        }
        return sum;
    }
}