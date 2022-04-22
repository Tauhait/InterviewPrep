class Solution {
    private int[] memo;
    private int colors;
    private int dp(int i){
        if(i == 1){
            return colors;
        }
        if(i == 2){
            return colors * colors;
        }
        
        if(memo[i] == -1){
            int sameColorAsPrev = 1 * (colors - 1) * dp(i - 2);
            int diffColorThanPrev =  (colors - 1) * dp(i - 1);
            memo[i] = sameColorAsPrev + diffColorThanPrev;
        }
        return memo[i];
    }
    public int numWays(int n, int k) {
        colors = k;
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dp(n);
    }
}