package faang;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	//Brute force approach: Keep i at one pos and iterate rest of the right half of the array with j index TC = O(n*n) SC = O(1)
    //Better approach: Sort the input and traverse from both ends and reduce/increase the index accordingly from both sides. TC = O(n lg n) SC = O(1)
    //Optimal approach: Deduct array[i] value from target and then  check for this value in the hashtable. TC = O(n) SC = (n)    
    public int[] twoSum(int[] nums, int target) {
       if(nums == null || nums.length == 0) return new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int len = nums.length;
        int i = 0;
        int[] ans = new int[2];
        for( ; i < len; i++){
            if(map.containsKey(target - nums[i])) break;
            map.put(nums[i], i);
        }
        if(i >= len) return null;
        ans[0] = map.get(target - nums[i]);
        ans[1] = i;
        return ans;
    }
}
