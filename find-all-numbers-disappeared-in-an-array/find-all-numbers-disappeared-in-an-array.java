class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while(i < nums.length){
            if(nums[i] == -1 || nums[nums[i]-1] == -1) {
                i++;
                continue;
            }
            int temp = nums[nums[i]-1];
            nums[nums[i]-1] = -1;
            nums[i] = temp;
            if(i == nums[i]-1){
                if(nums[i] != i) nums[i] = -1;
                else nums[nums[i]-1] = -1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(i = 0; i < nums.length; i++) 
            if(nums[i] != -1) 
                ans.add(i+1);
        return ans;
    }
}