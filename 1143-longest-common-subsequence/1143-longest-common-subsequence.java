class Solution {
    private String text1;
    private String text2;
    private int[][] memo;
    private int dp(int i, int j){
        if(i < 0 || j < 0){
            return 0;
        }
        if(memo[i][j] != 0){
            return memo[i][j];
        }
        
        if(text1.charAt(i) == text2.charAt(j)){
            memo[i][j] = dp(i - 1, j - 1) + 1;
        }else {
            memo[i][j] = Math.max(dp(i - 1, j), dp(i, j - 1));
        }
        return memo[i][j];        
    }
    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;
        int n = text1.length();
        int m = text2.length();
        memo = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++){
            Arrays.fill(memo[i], 0);
        }        
        
        return dp(n - 1, m - 1);    
    }
}
/*
Test Case:
"cgataattgaga"
"gttcctaata"
*/