package faang;

public class MaximumProductSubarray {
	/*
	To get the max subarray product we have to exclude one -ve val either from front / back of an subarray whichever makes 
	the subarray product value maximum we'll keep that.
	If there are no zeros then the whole array is considered as the subarray.
	The #-ve values present must be even in the subarray to get max product
	*/
	public int maxProduct(int[] nums) { 
        int res = nums[0], left = 0, right = 0;
        int size = nums.length;
        for(int i = 0; i < size; i++){
            left = (left == 0 ? 1 : left) * nums[i];
            right = (right == 0 ? 1 : right) * nums[size - i - 1];
            res = Math.max(res, Math.max(left, right));
        }
        return res;
    }
}
