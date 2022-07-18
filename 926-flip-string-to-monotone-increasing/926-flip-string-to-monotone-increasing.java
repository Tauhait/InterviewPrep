class Solution {
    /*
    In the subarray left from i I would need to count ones to flip to make a correct string.
    In the subarray right from i I would need to count zeros to flip to make a correct string.
    just for those who have troubles understanding intuition. 
    Basically we go through string and found out 
    how much 1 before index much be flipped to 0 and 
    how much 0 after index need to be flipped to 1. adds them up and get min for result
    */
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] ones = new int[n + 1];//count of ones till current index
        for (int i = 0; i < n; ++i) ones[i+1] = ones[i] + (s.charAt(i) == '1' ? 1 : 0);

        int ans = Integer.MAX_VALUE;
        for (int j = 0; j <= n; ++j) {
            int onesLeft = ones[j];
            int zerosRight = (n-j)-(ones[n]-ones[j]);//subarray len - #ones in the subarray
            ans = Math.min(ans, onesLeft + zerosRight);
        }

        return ans;
    }
}