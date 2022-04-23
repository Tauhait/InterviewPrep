class Solution {
    private String s;
    private int[] memo;
    
    private int dp(int i){
        if(i == 0){
            return 1;
        }
        if(i == 1){
            return s.charAt(0) != '0' ? 1 : 0;
        }
        if(memo[i] == 0){
            int first = Integer.valueOf(s.substring(i - 1, i));
            int second = Integer.valueOf(s.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
               memo[i] += dp(i - 1);  
            }
            if (second >= 10 && second <= 26) {
                memo[i] += dp(i - 2);
            } 
        }
        return memo[i];
    }
    public int numDecodings(String s) {
        this.s = s;
        if (this.s == null || this.s.length() == 0) {
            return 0;
        }
        int n = this.s.length();
        memo = new int[n + 1];
        return dp(n);
    }
}