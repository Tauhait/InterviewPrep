class Solution {
    private Integer MOD = 1000000007;
    private Long[][] memo;
    private int n;
    private Long dp(int i, int vowel){
        if(i == 0){
            return 1l;
        }
        if(memo[i][vowel] == null){
            if(vowel == 0){
                memo[i][vowel] = (dp(i - 1, 1) + dp(i - 1, 2) + dp(i - 1, 4)) % MOD;
            }else if(vowel == 1){
                memo[i][vowel] = (dp(i - 1, 0) + dp(i - 1, 2)) % MOD;
            }else if(vowel == 2){
                memo[i][vowel] = (dp(i - 1, 1) + dp(i - 1, 3)) % MOD;
            }else if(vowel == 3){
                memo[i][vowel] = dp(i - 1, 2);
            }else {
                memo[i][vowel] = (dp(i - 1, 2) + dp(i - 1, 3)) % MOD;
            }            
        }
        return memo[i][vowel];
    }
    public int countVowelPermutation(int n) {
        this.n = n;
        memo = new Long[n][5];
        long result = 0;
        for(int vowel = 0; vowel < 5; vowel++){
            result = (result + dp(n - 1, vowel)) % MOD;
        }
        
        return (int)(result);
    }
}