class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int evenSum = 0;
        for(int n : nums) 
            if(n % 2 == 0) 
                evenSum += n;
        
        int q = queries.length;
        int[] ans = new int[q];
        
        for(int i = 0; i < q; i++){
            int j = queries[i][1];
            if(nums[j] % 2 == 0){
                int prev = nums[j];
                nums[j] += queries[i][0];
                evenSum -= prev;
                if(nums[j] % 2 == 0)
                    evenSum += nums[j];                               
            }else {
                if((nums[j] + queries[i][0]) % 2 == 0){
                    nums[j] += queries[i][0];
                    evenSum += nums[j];
                }else {
                    nums[j] += queries[i][0];
                }
            }
            ans[i] = evenSum;
        }
        return ans;
    }
}