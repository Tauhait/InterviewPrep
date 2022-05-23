class Solution {
    private Boolean[][] memo;
    private String s;
    
    private Boolean dp(int i, int j){
        if(memo[i][j] != null){
            return memo[i][j];
        }
        
        if(i >= j){
            return true;
        }else if(s.charAt(i) != s.charAt(j)){
            return false;
        }else {
            memo[i][j] = dp(i + 1, j - 1);
        }
        return memo[i][j];        
    }
    public int countSubstrings(String s) {
        int slen = s.length();
        if(slen == 0){
            return 0;
        }
        
        memo = new Boolean[slen][slen];
        this.s = s;
        int ans = 0;
        
        for(int i = 0; i < slen; i++){
            for(int gap = i; gap < slen; gap++){
                ans += (dp(i, gap) ? 1 : 0);
            }
        }        
        return ans;
    }
}