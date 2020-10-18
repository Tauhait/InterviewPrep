package faang;

import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWithZeroSum {
	public int zeroSumSubarray(int[] arr) {
		int n = arr.length;
		if(n == 0) return -1;
		Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
		int sum = 0, maxLen = 0;
		for(int i = 0; i < n; i++) {
			sum += arr[i];
			if(sum == 0) maxLen = i + 1;
			else {
				if(sumMap.containsKey(sum)) { 
					int len = i - sumMap.get(sum);
					maxLen = len > maxLen ? len : maxLen;
				}
				else sumMap.put(sum, i);
			}
		}
		return maxLen;
	}
}
