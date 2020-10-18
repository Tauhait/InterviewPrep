package faang;

import java.util.Hashtable;

public class SubArraySumEqualsK {
	public int subarraySum(int[] nums, int k) {
        if(nums.length == 1)
            return nums[0] == k ? 1 : 0;
        int n = nums.length;
        int count = 0;
        Hashtable<Integer, Integer> cumSumFreq = new Hashtable<Integer, Integer>();
        cumSumFreq.put(0, 1);
        for(int i = 0, sum = 0; i < n; i++){        	
            sum += nums[i];           
            if(cumSumFreq.containsKey(sum - k))
                count += cumSumFreq.get(sum-k);
             cumSumFreq.put(sum, cumSumFreq.getOrDefault(sum, 0) + 1);
        }                
        return count;    
    }
}
