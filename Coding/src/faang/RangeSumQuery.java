package faang;

public class RangeSumQuery {
	class NumArray {
	    private int dp[];
	    public NumArray(int[] nums) {
	        if(nums.length > 0) {
	            dp = new int[nums.length];
	            dp[0] = nums[0];
	            for(int i = 1; i < nums.length; i++){
	                dp[i] = dp[i-1] + nums[i];
	            }
	        }
	    }
	    public void update(int i, int val) {
	        int prev = dp[i];
	        if(i == 0) dp[i] = val;
	        else dp[i] = dp[i-1] + val;
	        int diff = dp[i] - prev;
	        for(int index = i + 1; index < dp.length; index++){
	            dp[index] = dp[index] + diff;
	        }
	    }
	    public int sumRange(int i, int j) {
	        if(i == 0) return dp[j];
	        return dp[j] - dp[i-1];
	    }
	}
}
