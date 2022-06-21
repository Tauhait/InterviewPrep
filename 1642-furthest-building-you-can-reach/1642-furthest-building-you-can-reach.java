class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        //maxHeap
        PriorityQueue<Integer> bricksAllocation = new PriorityQueue(Collections.reverseOrder());
        for(int i = 0; i < heights.length - 1; i++){
            int climb = heights[i + 1] - heights[i];
            if(climb <= 0){
                continue;
            }
            
            bricksAllocation.add(climb);
            bricks -= climb;
            
            if(bricks < 0) {
                if(ladders == 0){
                    return i;
                }else {
                    int largestBrickAllocation = bricksAllocation.poll();
                    bricks += largestBrickAllocation;
                    ladders--;
                }
            }else {
                //valid allocation; 
                // continue; 
                // greedy approach with backtracking
            }          
        }
        return heights.length - 1;        
    }
}