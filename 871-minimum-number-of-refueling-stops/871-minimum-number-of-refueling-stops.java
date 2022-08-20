class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (target <= startFuel) return 0;    
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        maxQueue.add(startFuel);
        int result = -1, currPos = 0, currStation = 0;   
        while (currPos < target && maxQueue.size() > 0) {
            currPos += maxQueue.remove();
            result++;
            while (currStation < stations.length && stations[currStation][0] <= currPos) {
                maxQueue.add(stations[currStation++][1]);
            }
        }
        return target <= currPos ? result : -1;    
    }
}