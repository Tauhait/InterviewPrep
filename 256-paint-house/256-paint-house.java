class Solution {
    private int[][] costs;
    private Map<String, Integer> memo;
    
    private int dp(int i, int color){
        String key = getKey(i, color);
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int totalCost = costs[i][color];
        if(i == costs.length - 1){
            
        }else if(color == 0){
            totalCost += Math.min(dp(i + 1, 1), dp(i + 1, 2));
        }else if(color == 1){
            totalCost += Math.min(dp(i + 1, 0), dp(i + 1, 2));
        }else {
            totalCost += Math.min(dp(i + 1, 0), dp(i + 1, 1));
        }
        memo.put(key, totalCost);
        return totalCost;
    }
    private String getKey(int n, int color) {
        return String.valueOf(n) + " " + String.valueOf(color);
    }
    public int minCost(int[][] costs) {
        this.costs = costs;
        memo = new HashMap<String, Integer>();
        
        return Math.min(dp(0, 0), Math.min(dp(0, 1), dp(0, 2)));
    }
}