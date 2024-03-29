class Solution {
    // Assign the size as per maximum value for different params
    private Map<String, Integer> memo = new HashMap<String,Integer>();
    // Maximum cost possible plus 1
    private final int MAX_COST = 1000001;
    private int[] houses;
    private int[][] cost;
    
    int findMinCost(int targetCount, int currIndex, int neighborhoodCount, int prevHouseColor) {
        /*
        Base Case
        */
        if (currIndex == houses.length) {
            // If all houses are traversed, check if the neighbor count is as expected or not
            return neighborhoodCount == targetCount ? 0 : MAX_COST;
        }
        /*
        Base Case
        */
        if (neighborhoodCount > targetCount) {
            // If the neighborhoods are more than the threshold, we can't have target neighborhoods
            return MAX_COST;
        }
        /*
        Memoization state identifier
        */
        String key = currIndex+","+neighborhoodCount+","+prevHouseColor;
        
        // We have already calculated the answer so no need to go into recursion
        if (memo.get(key) != null) return memo.get(key);
        
        int minCost = MAX_COST;
        // If the house is already painted, update the values accordingly
        if (houses[currIndex] != 0) {
            int newNeighborhoodCount = neighborhoodCount + 
                                    (houses[currIndex] != prevHouseColor ? 1 : 0);
            minCost = findMinCost(targetCount, currIndex + 1, newNeighborhoodCount, houses[currIndex]);
        } else {
            int totalColors = cost[0].length;
            
            // If the house is not painted, try every possible color and store the minimum cost
            for (int color = 1; color <= totalColors; color++) {
                int newNeighborhoodCount = neighborhoodCount + (color != prevHouseColor ? 1 : 0);
                int currCost = cost[currIndex][color - 1] 
                    + findMinCost(targetCount, currIndex + 1, newNeighborhoodCount, color);
                minCost = Math.min(minCost, currCost);
            }
        }
        
        // Return the minimum cost and also storing it for future reference (memoization)
        memo.put(key, minCost);
        return memo.get(key);
    }
    
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.houses = houses;
        this.cost = cost;
        int answer = findMinCost(target, 0, 0, 0);
        // Return -1 if the answer is MAX_COST as it implies no answer possible
        return answer == MAX_COST ? -1 : answer;
    }
}