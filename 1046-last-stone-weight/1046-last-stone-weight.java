class Solution {
    public int lastStoneWeight(int[] stones) {
        
        if(stones.length == 1){
            return stones[0];
        }
        if(stones.length == 2){
            int wStone1 = stones[0];
            int wStone2 = stones[1];
            return wStone1 > wStone2 ? wStone1-wStone2 : wStone2-wStone1;
        }
            
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int len = stones.length;
        for(int i=0; i < len; i++){
            heap.offer(stones[i]);
        }
        while(heap.size() > 1){
            int stone1 = heap.poll();
            int stone2 = heap.poll();
            int smashVal = stone1 - stone2;
            if((stone1 - stone2) > 0){
                heap.offer(smashVal);
            }
        }
        if(heap.size() == 1)
            return heap.poll();
        else
            return 0;
    }
}