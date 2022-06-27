class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hSet = new HashSet<Integer>();
        for(int i=0; i < nums.length; i++){
            if(hSet.contains(nums[i])) return true;
            hSet.add(nums[i]);
        }
        return false;
    }
}