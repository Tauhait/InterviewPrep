class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> prefixSumMap = new HashMap<>();
        int ans = 0, prefixSum = 0;
        prefixSumMap.put(0, 1);
        for(int num : nums){
            prefixSum += num;
            ans += prefixSumMap.getOrDefault(prefixSum-k, 0);
            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum,0)+1);
        }
        return ans;
    }
}