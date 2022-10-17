class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[nums.length-1];
        for(int i = 0; i < nums.length; i++){
            int left = i+1, right = nums.length-1;
            while(left < right){                
                int currentSum = nums[i] + nums[left] + nums[right];
                if(currentSum < target)
                    left++;
                else if(currentSum > target)
                    right--;
                else
                    return target;
                if(Math.abs(currentSum-target) < Math.abs(closest-target))
                    closest = currentSum;                
            }
        }
        return closest;
    }
}