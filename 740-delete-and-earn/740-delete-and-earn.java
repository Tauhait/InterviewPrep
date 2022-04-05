class Solution {
    private Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
    private Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
    private int[] nums;
    private int max;
    public int deleteAndEarn(int[] nums) {
        this.nums = nums;
        Arrays.sort(this.nums);
        for(int n : this.nums){
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }
        return dp(0);
    }
    private int dp(int i){
        if(i >= nums.length){
            return 0;
        }        
        if(!memo.containsKey(i)){
            Integer val = freqMap.get(nums[i]) * nums[i];
            Integer freqValPlus1 = freqMap.get(nums[i] + 1);
            if(freqValPlus1 != null){
                memo.put(i, Math.max(val + dp(i + freqMap.get(nums[i]) + freqValPlus1), 
                                                                    dp(i + freqMap.get(nums[i]))));
            }else {
                memo.put(i, val + dp(i + freqMap.get(nums[i])));
            }            
        }
        return memo.get(i);
    }
}