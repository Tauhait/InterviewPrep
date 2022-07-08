class Solution {
    public int strStr(String haystack, String needle) {
        //What should we return when needle is an empty string? This is a great question to ask during an interview.
        if(needle == null || needle.length() == 0) return 0;
        int haylen = haystack.length();
        int needlen = needle.length();
        if(needlen > haylen) return -1;
        for (int i = 0; ; i++) { // The length of haystack
            for (int j = 0; ; j++) { // The length of needle
              if (j == needlen) return i; // If at this point we have navigated through the entire length of needle, we have found a solution, haystack[i].
              if (i + j == haylen) return -1; // This happens when we run out of elements in haystack, but there are still elements in needle. 
              if (needle.charAt(j) != haystack.charAt(i + j)) break; // We stop comparing after needle[j], so i will be incremented and cycle repeats itself. 
            }
        }
    }
}