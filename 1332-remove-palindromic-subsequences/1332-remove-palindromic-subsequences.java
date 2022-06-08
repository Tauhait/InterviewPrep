class Solution {
    public int removePalindromeSub(String s) {
        if(s == null || s.length() == 0) return 0;
        int[] freq = new int[2];
        char[] sChar = s.toCharArray();
        
        int left = 0, right = s.length() - 1;
        
        while(left < right){
            if(sChar[left++] != sChar[right--]) return 2;
        }       
        return 1;
    }
}