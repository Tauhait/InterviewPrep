class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1){
            return 0;
        }
        int left = 0;
        int prefixProd = 1;
        int contiguousSubArrs = 0;
        for(int right = 0; right < nums.length; right++){
            prefixProd *= nums[right];
            while(prefixProd >= k){
                prefixProd /= nums[left];
                left++;
            }
            contiguousSubArrs += right - left + 1;
        }
        return contiguousSubArrs;
    }
}