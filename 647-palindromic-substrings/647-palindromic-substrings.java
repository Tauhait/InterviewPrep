class Solution {
//     private Integer[][] memo;
//     private String s;
    
//     private int dp(int i, int j){
//         if(i < 0 || j >= s.length()){
//             return 0;
//         }
//         if(memo[i][j] == null){
//             memo[i][j] = dp(i - 1, j + 1) + s.charAt(i) == s.charAt(j) ? 1 : 0;
//         }
//         return memo[i][j];
//     }
    public int countSubstrings(String s) {
//         int slen = s.length();
//         if(slen == 0){
//             return 0;
//         }
        
//         memo = new Integer[slen][slen];
//         this.s = s;
        
//         for(int i = 0; i < slen; i++){
//             memo[i][i] = 1;
//         }
//         for(int i = 0; i < slen - 1; i++){
//             memo[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? 1 : 0;
//         }
        
//         return dp(slen - 1, slen - 3 - 1);
        
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans=0;
        for(int gap=0;gap<s.length();gap++){
            for(int i=0,j=gap;i<s.length() && j<s.length();i++,j++){
                if(gap==0){
                    dp[i][j]=true;
                    ans++;
                }
                else if(gap==1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=true;
                        ans++;
                    }
                }
                else{
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=dp[i+1][j-1];
                        if(dp[i][j]){
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }
}