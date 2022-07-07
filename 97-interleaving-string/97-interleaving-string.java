class Solution {
    private Boolean[][] memo;
    private String s1, s2, s3;
    
    public boolean dp(int i, int j, int k) {
        if (i < 0) {
            return s2.substring(0, j + 1).equals(s3.substring(0, k + 1));
        }
        if (j < 0) {
            return s1.substring(0, i + 1).equals(s3.substring(0, k + 1));
        }
        if (memo[i][j] != null) return memo[i][j];
        if (s3.charAt(k) == s1.charAt(i) && dp(i - 1, j, k - 1) || 
            s3.charAt(k) == s2.charAt(j) && dp(i, j - 1, k - 1)) 
             memo[i][j] = true;
        else memo[i][j] = false;
        
        return memo[i][j];
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        
        memo = new Boolean[s1.length()][s2.length()];
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;

        return dp(s1.length() - 1, s2.length() - 1, s3.length() - 1);
    }
}
/*
QtI
1. Do s1 and s2 needs to exhaust completely?
*/