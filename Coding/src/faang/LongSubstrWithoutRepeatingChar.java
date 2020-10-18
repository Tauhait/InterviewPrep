package faang;

import java.util.HashMap;
import java.util.HashSet;

public class LongSubstrWithoutRepeatingChar {
	//TC - O(2n) SC - O(n)
	public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(s == null || len == 0) return 0;
        int longSubstr = 0;
        int left = 0, right = 0;
        HashSet<Character> set = new HashSet<Character>();
        for(char c : s.toCharArray()){
            while(set.contains(c)) {
                char leftEnd = s.charAt(left);
                ++left;
                set.remove(leftEnd);                
            }
            set.add(c);
            longSubstr = (right - left + 1) > longSubstr ? (right - left + 1) : longSubstr;
            ++right;
        }
        return longSubstr;
    }
	//TC - O(2n) SC - O(n)
	public int lengthOfLongestSubstring_OPT(String s) {
        int len = s.length();
        if(s == null || len == 0) return 0;
        int longSubstr = 0;
        int left = 0, right = 0;
        HashMap<Character, Integer> mpp = new HashMap<Character, Integer>();
        while(right < len){
            if(mpp.containsKey(s.charAt(right))) left = Math.max(mpp.get(s.charAt(right)) + 1, left);
            mpp.put(s.charAt(right), right);
            longSubstr = Math.max(longSubstr, right - left + 1);
            ++right;
        }
        return longSubstr;
    }
}
