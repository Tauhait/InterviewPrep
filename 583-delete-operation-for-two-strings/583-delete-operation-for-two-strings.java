class Solution {
    private Integer[][] memo;
    
    public int minDistance(String word1, String word2) {
        memo = new Integer[word1.length()+1][word2.length()+1];
        int lcs = lcs(word1, word2, word1.length(), word2.length());
        return word1.length() + word2.length() - 2*lcs;
    }
    private int lcs(String s1, String s2, int n, int m){
        if(n == 0 || m == 0) return 0;
        if(memo[n][m] == null){
            if(s1.charAt(n-1) == s2.charAt(m-1)) memo[n][m] = 1 + lcs(s1, s2, n-1, m-1);
            else memo[n][m] = Math.max(lcs(s1, s2, n-1, m), //max bcz we want lcs
                                       lcs(s1, s2, n, m-1));
        }
        return memo[n][m];
    }
}