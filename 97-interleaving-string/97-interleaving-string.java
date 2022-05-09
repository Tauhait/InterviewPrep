class Solution {
    private Integer[][] memo;
    private String s1, s2, s3;
    public int dp(int i, int j, int k) {
        if (i == s1.length()) {
            return s2.substring(j).equals(s3.substring(k)) ? 1 : 0;
        }
        if (j == s2.length()) {
            return s1.substring(i).equals(s3.substring(k)) ? 1 : 0;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        // boolean ans = false;
        if (s3.charAt(k) == s1.charAt(i) && dp(i + 1, j, k + 1) == 1 || 
            s3.charAt(k) == s2.charAt(j) && dp(i, j + 1, k + 1) == 1   ) {
            // ans = true;
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
        // for (int i = 0; i < s1.length(); i++) {
        //     for (int j = 0; j < s2.length(); j++) {
        //         memo[i][j] = -1;
        //     }
        // }
        // return dp(s1, 0, s2, 0, s3, 0);
        return dp(0, 0, 0) == 1 ? true : false;
    }
}