class Solution {
    private String findPalindrome(int l, int r, String s){
        int len = 0;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            len = Math.max(r - l + 1, len);
            l--;
            r++;
        }
        return len > 0 ? s.substring(l + 1, r) : "";
    }
    public String longestPalindrome(String s) {
        String longest = "";
        int l = -1, r = -1;
        for(int i = 0; i < s.length(); i++){
            // odd len
            String oddLenSubstrPalinFromCenterPos_i = findPalindrome(i, i, s);
            longest = oddLenSubstrPalinFromCenterPos_i.length() > longest.length() ? oddLenSubstrPalinFromCenterPos_i : longest;

            // even len
            String evenLenSubstrPalinFromCenterPos_i = findPalindrome(i, i + 1, s);
            longest = evenLenSubstrPalinFromCenterPos_i.length() > longest.length() ? evenLenSubstrPalinFromCenterPos_i : longest;

        }
        return longest;
    }
}