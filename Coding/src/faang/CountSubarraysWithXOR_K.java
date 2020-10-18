package faang;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithXOR_K {
	// Naive approach: Generate all subraays and find the XOR for each of them.
	// Optimal approach: using hashmap and prefix XOR. TC - O(n) SC - O(n)
	public int countSubarraysXOR(int[] nums, int k) {
		int len = nums.length;
		int count = 0;
		Map<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
		int xor = 0;
		for(int i = 0; i < len; i++) {
			xor ^= nums[i];
			// important step to check number of subarrays 
			// 		xor = y ^ k
			// or 	y = xor ^ k
			// count the #y's in the current subarrays/prefixes
			if(freqMap.containsKey(xor ^ k)) count += freqMap.get(xor ^ k);
			if(xor == k) ++count;
			freqMap.put(xor, freqMap.getOrDefault(xor, 0) + 1);
		}
		return count;
	}

}
