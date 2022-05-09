class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> bricksAllocation = new PriorityQueue(Collections.reverseOrder());
        for(int i = 0; i < heights.length - 1; i++){
            int climb = heights[i + 1] - heights[i];
            if(climb <= 0){
                continue;
            }
            
            bricksAllocation.add(climb);
            bricks -= climb;
            
            if(bricks < 0 && ladders == 0){
                return i;
            }
            if(bricks < 0){
                int largestBrickAllocation = bricksAllocation.poll();
                bricks += largestBrickAllocation;
                ladders--;
            }
            
        }
        return heights.length - 1;        
    }
}