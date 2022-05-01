class Solution {
    private int[][] memo;
    private int[][] mat;
    private int dp(int i, int j){
        if(i == mat.length){
            return 0;
        }
        if(j < 0 || j == mat[0].length){
            return Integer.MAX_VALUE;
        }
        if(memo[i][j] == -1){
            memo[i][j] = mat[i][j] + Math.min(dp(i + 1, j), 
                                              Math.min(dp(i + 1, j - 1), dp(i + 1, j + 1)));
        }        
        return memo[i][j];
    }
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        memo = new int[m][n];
        this.mat = matrix;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            Arrays.fill(memo[i], -1);
        }
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++){
            ans = Math.min(ans, dp(0, j));
        }
        return ans;
    }
}