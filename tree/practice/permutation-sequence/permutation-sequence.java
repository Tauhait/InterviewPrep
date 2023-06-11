class Solution {
    public String getPermutation(int n, int k) {
        NextPermutation np = new NextPermutation();
        int[] nums = new int[n];
        for(int i = 1; i <= n; i++) nums[i-1] = i;
        while(k-- > 1) np.nextPermutation(nums);
        StringBuilder sb = new StringBuilder();
        for(int num : nums) sb.append(num);
        return sb.toString();
    }
}
class NextPermutation {
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = n - 1;
        while(pivot >= 1 && nums[pivot-1] >= nums[pivot]){            
            --pivot;
        }
        //condition >= is given for duplicate values
        //At (pivot-1) the condition fails so we need to swap with (pivot-1)
        if(pivot != 0){ //check if the sequence is already greatest
            int justGreater = n - 1;           
            while(nums[pivot-1] >= nums[justGreater]){
                --justGreater;
            }
            swap(nums, justGreater, pivot-1);
        }
        int left = pivot;
        int right = n - 1;
        while(left < right){
            swap(nums, left++, right--);
        }
    }
}