class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        int[] ans = new int[2];
        int n = nums.length;
        int sum = n*(n+1)/2;
        int currSum = 0;
        for(int num : nums){
            if(numSet.contains(num))
                ans[0] = num;
            else
                currSum += num;
            numSet.add(num);
        }
        ans[1] = sum-currSum;
        return ans;
    }
}