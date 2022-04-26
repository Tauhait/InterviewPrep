class Solution {
    private int[][] memo;
    
    private int dp(int i, int j){
        if(i < 0 || j < 0){
            return 0;
        }
        if(i == 0 && j == 0){
            return 1;
        }
        if(memo[i][j] == 0){
            memo[i][j] = dp(i - 1, j) + dp(i, j - 1);
        }
        return memo[i][j];
    }
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for(int i = 0; i < m; i++){
            memo[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            memo[0][j] = 1;
        }
        return dp(m - 1, n - 1);
    }
}