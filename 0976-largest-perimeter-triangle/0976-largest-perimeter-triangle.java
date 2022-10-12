class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);        
        for(int i = nums.length-3; i >= 0; i--){
            int peri = nums[i]+nums[i+1]+nums[i+2];
            if(nums[i] + nums[i+1] > nums[i+2])
                return peri;
        }
        return 0;
    }
}