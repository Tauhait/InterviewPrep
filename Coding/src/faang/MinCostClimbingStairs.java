package faang;

public class MinCostClimbingStairs {
	//TC - O(n) SC - O(1)
	public int minCostClimbingStairs_OPT(int[] cost) {
        int path1 = cost[0], path2 = cost[1];
        for(int i = 2; i < cost.length; i++){
            int currCost = cost[i] + Math.min(path1, path2);
            path1 = path2;
            path2 = currCost;
        }
        return Math.min(path1, path2);
    }
	//TC - O(n) SC - O(n)
	public int minCostClimbingStairs_DP(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i - 1]+ cost[i], dp[i - 2] + cost[i]);
        }
        return Math.min(dp[len - 1], dp[len - 2]);
    }

}
