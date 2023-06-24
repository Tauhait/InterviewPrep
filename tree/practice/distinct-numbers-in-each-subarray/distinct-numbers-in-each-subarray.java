class Solution {
    public int[] distinctNumbers(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> windowMap = new HashMap<>();
        int[] ans = new int[n - k + 1];
        for(int i = 0; i < k; i++){
            windowMap.put(nums[i], windowMap.getOrDefault(nums[i], 0) + 1);
        }
        for(int i = k; i < n; i++){
            ans[i - k] = windowMap.size();
            int freq =  windowMap.get(nums[i - k]);
            windowMap.put(nums[i - k], freq - 1);
            if(windowMap.get(nums[i - k]) == 0){
                windowMap.remove(nums[i - k]);
            }
            windowMap.put(nums[i], windowMap.getOrDefault(nums[i], 0) + 1);
        }
        ans[n - k] = windowMap.size();
        return ans;
    }
}