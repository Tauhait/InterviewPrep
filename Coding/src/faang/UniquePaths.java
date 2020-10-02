package faang;

public class UniquePaths {
	//Brute force approach - recursive approach all possible paths
	//TC - O(exponential) and SC - O(exponential)
	public int uniquePaths(int m, int n) {
        return helper(1, 1, m , n);
    }	
	private int helper(int i, int j, int m, int n){
	    if(i == m && j == n) return 1;
	    if(i > m || j > n) return 0;
	    return helper(i + 1, j, m, n) + helper(i, j + 1, m, n); 
	}
	//Better soln - DP
	//TC - O(n*m) and SC - O(n*m) 
	public int uniquePathsDP(int m, int n) {        
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) 
            for(int j = 0; j < n; j++) 
                dp[i][j] = -1;
        
        return dpHelper(0, 0, m - 1, n - 1, dp);
    }
    private int dpHelper(int i, int j, int m, int n, int[][] dp){
        if(i == m && j == n) return 1;
        if(i > m || j > n) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        else {
            dp[i][j] = dpHelper(i + 1, j, m, n, dp) + dpHelper(i, j + 1, m, n, dp);
            return dp[i][j];
        }
    }
    //Optimal Soln - using combinatorics
    //TC - O(m) or O(n) whichever is small and SC - O(1)    
    public int uniquePathsOPT(int m, int n) {
        int N = n + m - 2;
        int r = n < m ? n - 1 : m - 1;
        long unqPaths = 1;
        for(int i = 1; i <= r; i++) unqPaths = unqPaths * (N - r + i) / i;
        return (int)unqPaths;
    }
}

