class Solution {
    public int concatenatedBinary(int n) {
        final int MOD = 1_000_000_007;
        long result = 0, len = 0;
        for(int i = 1; i <= n; i++){
            if(Math.pow(2, (int)(Math.log10(i)/Math.log10(2))) == i)
                ++len;
            result = (result << len) % MOD;
            result = (result + i)    % MOD;
        }
        return (int)result;
    }
}