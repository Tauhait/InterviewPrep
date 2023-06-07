class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> complementIndexMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(complementIndexMap.containsKey(complement)) {
                return new int[]{complementIndexMap.get(complement), i};
            }
            complementIndexMap.put(nums[i], i);
        }
        return new int[] {-1,-1};
        
    }
}