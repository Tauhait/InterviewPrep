class Solution {
    private int[] cost;
    private int minCost;
    private int memo_1;
    private int memo_2;
    //private Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
    
    public int minCostClimbingStairs(int[] cost) {
        this.cost = cost;   
        memo_1 = 0;
        memo_2 = 0;
        return dp();
    }
    private int dp(){
        //The problem statement says we are allowed to start at the 0th  or 1st step, 
        //so we know the minimum cost to reach those steps is 0.
        // if(i <= 1){
        //     return 0;
        // }
        for(int i = 2; i < cost.length + 1; i++){
            minCost = Math.min(cost[i - 1] + memo_1, cost[i - 2] + memo_2);
            memo_2 = memo_1;
            memo_1 = minCost;
        }
        // if(!memo.containsKey(i)){
        //     minCost = Math.min(cost[i - 1] + dp(i - 1), cost[i - 2] + dp(i - 2));
        //     memo.put(i, minCost);
        // }
        return minCost;
    }
}