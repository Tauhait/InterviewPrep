package faang;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSeq {
	//Brute force approach: Sort the array and linearly iterate by checking on the max length. Once consecutive iteration breaks, start count again. TC = O(n lg n)
    //Optimal approach: Linearly iterate the array and put all elements into a hashset. Then find the starting element of any consecutive seq then count its length. TC = O(n)
    public int longestConsecutive(int[] nums) {     
        if(nums == null || nums.length == 0) return 0;
        Set<Integer> elemSet = new HashSet<Integer>();
        int maxLen = 1;
        for(int x : nums) elemSet.add(x);
        for(int x : nums) { 
            if(elemSet.contains(x - 1)) continue;
            else {
                int next = x + 1;
                while(elemSet.contains(next)) next++;
                maxLen = Math.max(maxLen, next - x);
            }
        }
        return maxLen;
    }
}
