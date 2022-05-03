class Solution {
    private int[][] costs;
    private Map<String, Integer> memo;
    private int k;
    private int dp(int i, int color){
        String key = getKey(i, color);
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int totalCost = costs[i][color];        
        if(i == costs.length - 1){
            
        }else {
            int minColorCost = Integer.MAX_VALUE;
            for(int j = 0; j < k; j++){
                if(j == color){
                    continue;
                }
                minColorCost = Math.min(minColorCost, dp(i + 1, j));
            }
            totalCost += minColorCost;
            memo.put(key, totalCost);
        }
        return totalCost;
    }
    private String getKey(int houseNo, int color){
        return String.valueOf(houseNo) + " " + String.valueOf(color);
    }
    public int minCostII(int[][] costs) {
        k = costs[0].length;
        this.costs = costs;
        memo = new HashMap();
        int minColorCost = Integer.MAX_VALUE;
        for(int color = 0; color < k; color++){
            minColorCost = Math.min(minColorCost, dp(0, color));
        }
        return minColorCost;        
    }
}