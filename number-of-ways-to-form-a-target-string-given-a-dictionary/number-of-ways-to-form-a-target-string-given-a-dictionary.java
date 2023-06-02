class Solution {
    public int numWays(String[] words, String target) {
        int alphabets = 26;
        int mod = 1000000007;
        int m = target.length(), k = words[0].length();
        int cnt[][] = new int[alphabets][k];
        for (int j = 0; j < k; j++) {
            for (String word : words) {
                cnt[word.charAt(j) - 'a'][j]++;
            }
        }
        long dp[][] = new long[m + 1][k + 1];
        dp[0][0] = 1;//when target and dict both are empty
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= k; j++) {
                //taken 
                if(j < k && i < m){
                    dp[i + 1][j + 1] += cnt[target.charAt(i) - 'a'][j] * dp[i][j];
                    dp[i + 1][j + 1] %= mod; 
                }
               
                //not taken
                if(j < k){
                    dp[i][j + 1] += dp[i][j];
                    dp[i][j + 1] %= mod;
                }
            }
        }
        return (int)dp[m][k];
    }
}