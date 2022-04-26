class Solution {
    private int[][] memo;
    private int[][] grid;
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        this.grid = grid;
        memo = new int[m][n];
        
        memo[0][0] = grid[0][0];
        
        for(int i = 1; i < m; i++){
            memo[i][0] = memo[i - 1][0] + grid[i][0];
        }
        for(int j = 1; j < n; j++){
            memo[0][j] = memo[0][j - 1] + grid[0][j];
        }
        
        return dp(m - 1, n - 1);
    }
    private int dp(int i, int j){
        if(i < 0 || j < 0){
            return 0;
        }
        if(i == 0 && j == 0){
            return grid[i][j];
        }
        if(memo[i][j] == 0){
            memo[i][j] = grid[i][j] + Math.min(dp(i - 1, j), dp(i, j - 1));
        }
        return memo[i][j];
    }
}