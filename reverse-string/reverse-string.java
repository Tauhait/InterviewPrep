class Solution {
    public void reverseString(char[] s) {
        if(s == null || s.length <= 1){
            return;
        }
        reverse(s, 0);
    }
    public void reverse(char[] s, int index){
        if(index == s.length){
            return;
        }
        char ch = s[index];
        reverse(s, index + 1);
        s[s.length - 1 - index] = ch;
    }
}