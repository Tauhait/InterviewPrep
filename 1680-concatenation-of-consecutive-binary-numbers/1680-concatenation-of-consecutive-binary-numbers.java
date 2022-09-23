class Solution {
    public int concatenatedBinary(int n) {
        final int MOD = 1_000_000_007;
        int result = 0;
        for(int i = 1; i <= n; i++){
            String number = Integer.toBinaryString(i);
            for(char c : number.toCharArray())
                result = (result*2 + (c-'0')) % MOD;
        }
        return result;
    }
}