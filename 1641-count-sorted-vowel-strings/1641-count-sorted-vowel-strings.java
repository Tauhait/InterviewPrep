class Solution {
    private Integer[][] memo;
    private int dp(int i, int vowels){
        if(i == 1){
            return vowels;
        }else if(vowels == 1){
            return 1;
        }else if(memo[i][vowels] == null){
            memo[i][vowels] = dp(i - 1, vowels) + dp(i, vowels - 1);
        }
        return memo[i][vowels];
    }
    
    public int countVowelStrings(int n) {
        memo = new Integer[n + 1][5 + 1];
        return dp(n, 5);
    }
}