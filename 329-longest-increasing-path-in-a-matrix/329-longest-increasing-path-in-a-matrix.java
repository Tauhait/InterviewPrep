class Solution {
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;
    private int[][] memo;
    private int[][] matrix;
    
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length; 
        n = matrix[0].length;
        this.matrix = matrix;
        memo = new int[m][n];
        
        int ans = 0;
        
        for (int i = 0; i < m; ++i){
            for (int j = 0; j < n; ++j){
                ans = Math.max(ans, DFS(i, j));
            }
        }
        
        return ans + 1;//Add 1 to count the initial start cell in the path
    }
    //DFS with DP memoization technique
    private int DFS(int i, int j) {
        if(memo[i][j] == 0){            
            for (int[] d : dirs) {                
                int next_i = i + d[0], next_j = j + d[1];
                
                if (0 <= next_i && next_i < m && 
                    0 <= next_j && next_j < n && 
                    matrix[next_i][next_j] > matrix[i][j]){
                    
                    memo[i][j] = Math.max(memo[i][j], 1 + DFS(next_i, next_j));
                }
            }
        }
        return memo[i][j];
    }
}