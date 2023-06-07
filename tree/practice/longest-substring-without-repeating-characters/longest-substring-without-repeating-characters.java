class Solution {
    public int lengthOfLongestSubstring(String s) {
        Integer[] indexMap = new Integer[128];
        int left = 0, right = 0;
        int longest = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            Integer index = indexMap[c];
            if(index != null && index >= left && index < right){
                left = index+1;                
            }
            indexMap[c] = right;
            longest = Math.max(longest, right-left+1);
            right++;
        }
        return longest;
    }
}