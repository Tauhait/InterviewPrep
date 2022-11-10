class Solution {
    public int singleNumber(int[] nums) {
        int[] sum = new int[32];
        for(int n : nums){
            for(int bit = 0; bit < 32; bit++){
                sum[bit] += (n&1);
                n >>>= 1;
            }
        }
        for(int bit = 0; bit < 32; bit++){
            sum[bit] %= 3;//possible values are 0 and 1
        }
        int ans = 0;
        for(int bit = 0; bit < 32; bit++){
            ans += sum[bit]*(1<<bit);
        }
        return ans;
    }
}