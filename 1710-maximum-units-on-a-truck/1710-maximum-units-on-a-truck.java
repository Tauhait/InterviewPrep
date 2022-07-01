class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (b[1] - a[1]));
        
        for(int[] box : boxTypes) pq.add(box);
        
        int maxUnits = 0;
        while(truckSize != 0 && !pq.isEmpty()){
            int[] removeBox = pq.poll();
            if(truckSize - removeBox[0] >= 0){
                maxUnits += removeBox[0]*removeBox[1];
                truckSize -= removeBox[0];
            }else {
                maxUnits += truckSize*removeBox[1];
                truckSize = 0;
            }
        }
        return maxUnits;
    }
}
/*
1. Keep all boxes in a max heap in preference of more units per box
2. pick one box at a time from the heap and load it into the truck
3. keep doing step 2 until truck size is not full
*/