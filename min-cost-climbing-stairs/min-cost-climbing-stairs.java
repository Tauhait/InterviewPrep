class Solution {
    private int[] cost;
    private int minCost;
    private Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
    
    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;       
        return dp(cost.length);
    }
    private int dp(int i){
        //The problem statement says we are allowed to start at the 0th  or 1st step, 
        //so we know the minimum cost to reach those steps is 0.
        if(i <= 1){
            return 0;
        }
        if(!memo.containsKey(i)){
            minCost = Math.min(cost[i - 1] + dp(i - 1), cost[i - 2] + dp(i - 2));
            memo.put(i, minCost);
        }
        return memo.get(i);
    }
}