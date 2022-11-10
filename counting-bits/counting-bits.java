class Solution {
    public int[] countBits(int n) {
        int[] memo = new int[n+1];
        int offset = 1;
        for(int i = 1; i <= n; i++){
            if(offset * 2 == i)
                offset = i;
            memo[i] = 1 + memo[i-offset];
        }
        return memo;
    }
}