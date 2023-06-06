class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Integer candidate = null;
        int count = 0;
        for(int num : nums){
            if(count == 0){
                candidate = num;
            }
            count += num == candidate ? 1 : -1;
        }
        return candidate;
    }
}