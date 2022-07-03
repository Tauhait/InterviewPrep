class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        Integer[] charSet = new Integer[128];
        int res = 0;
        
        while(right < s.length()){
            char c = s.charAt(right);
            //if charset char is not null and present in current window[left, right] 
            //then shrink window by [left = charset[c]+1, right]
            if(charSet[c] != null && charSet[c] >= left) left = charSet[c] + 1;
            res = Math.max(res, right - left + 1);
            charSet[c] = right;
            right++;
        }
        return res;
    }
}