class Solution {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length-1;
        while(start < end){
            char begin = s[start];
            char last =  s[end];
            char swap = begin;
            begin = last;
            last = swap;
            s[start] = begin;
            s[end] =   last;
            start++;
            end--;
        }
    }
}