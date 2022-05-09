class Solution {
    private Integer[][] memo;
    private String s1, s2, s3;
    public int dp(int i, int j, int k) {
        if (i < 0) {
            return s2.substring(0, j + 1).equals(s3.substring(0, k + 1)) ? 1 : 0;
        }
        if (j < 0) {
            return s1.substring(0, i + 1).equals(s3.substring(0, k + 1)) ? 1 : 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (s3.charAt(k) == s1.charAt(i) && dp(i - 1, j, k - 1) == 1 || 
            s3.charAt(k) == s2.charAt(j) && dp(i, j - 1, k - 1) == 1   ) {
            memo[i][j] = 1;
        }else {
            memo[i][j] = 0;
        }
        
        return memo[i][j];
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        memo = new Integer[s1.length()][s2.length()];
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;

        return dp(s1.length() - 1, s2.length() - 1, s3.length() - 1) == 1 ? true : false;
    }
}