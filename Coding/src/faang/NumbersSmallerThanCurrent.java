package faang;

public class NumbersSmallerThanCurrent {
	public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] freq = new int[101];
        for(int i = 0; i < n; i++){
            freq[nums[i]]++;
        }
        
        for(int i = 1; i < 101; i++){
            freq[i] += freq[i-1];
        }
        
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            if(nums[i] > 0){
                ans[i] = freq[nums[i]-1];
            }else {
                ans[i] = 0;
            }
            
        }
        return ans;
    }

}
