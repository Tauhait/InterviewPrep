class Solution {
    private Integer[] memo;
    private String s;
    
    private int dp(int i){
        if(i <= 0){
            return 0;
        }
        if(memo[i] == null){
            int last = dp(i - 1);
            if(s.charAt(i) == ')'){
                if(s.charAt(i - 1) == '('){
                    memo[i] = 2 + dp(i - 2);
                }else {                    
                    if(last > 0 && (i - last - 1) >= 0 && s.charAt(i - last - 1) == '('){
                        memo[i] = 2 + last + dp(i - last - 2);
                    }
                }
            }
            if(memo[i] == null){
                memo[i] = 0;
            }
        }
        return memo[i];
    }
    public int longestValidParentheses(String s) {
        int slen = s.length();
        if(slen == 0){
            return 0;
        }
        memo = new Integer[slen];
        this.s = s;
        dp(slen - 1);
        int ans = 0;
        for(Integer m : memo){
            if(m == null){
                continue;
            }
            ans = Math.max(ans, m);
        }
        return ans;
    }
}