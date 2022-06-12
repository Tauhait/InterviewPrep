class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> uniqueWin = new HashSet<Integer>();
        int result = 0;
        int sum = 0;
        
        for(int left = 0, right = 0; right < nums.length; right++){
            if(uniqueWin.contains(nums[right])){
                result = Math.max(result, sum);
                
                while(left < right && uniqueWin.contains(nums[right])){
                    uniqueWin.remove(nums[left]);
                    sum -= nums[left];
                    left++;                    
                }     
            }
            sum += nums[right];
            uniqueWin.add(nums[right]);
            
        }
        result = Math.max(result, sum);
        return result;
    }
}