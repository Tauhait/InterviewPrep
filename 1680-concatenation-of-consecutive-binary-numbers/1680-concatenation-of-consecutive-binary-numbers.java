class Solution {
    public int concatenatedBinary(int n) {
        final int MOD = 1_000_000_007;
        long result = 0, len = 0;
        for(int i = 1; i <= n; i++){
            // if(Math.pow(2, (int)(Math.log10(i)/Math.log10(2))) == i)
            //     ++len;
            //With bitwise operation, we can check whether a number is the power of 2 in O(1).
            if((i & (i-1)) == 0)
                ++len;
            result = ((result << len) | i) % MOD;
        }
        return (int)result;
    }
}