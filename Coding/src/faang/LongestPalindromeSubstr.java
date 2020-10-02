package faang;

public class LongestPalindromeSubstr {
	public String longestPalindrome(String s) {        
        int strLen = s.length();
        if(strLen < 2) return s;
        int start = 0,  maxLen = 0;
        for(int mid = 0; mid < strLen; mid++){
            int oddLow = palindromeExtendFromMid(s, mid, mid);//consider oddlen palindrome
            int evenLow = palindromeExtendFromMid(s, mid, mid + 1);//consider evenlen palindrome
            int oddPalinLen = (mid - oddLow) * 2 + 1;
            int evenPalinLen = (mid - evenLow) * 2 + 2;
            if(evenPalinLen > oddPalinLen && evenPalinLen > maxLen) { 
                maxLen = evenPalinLen; start = evenLow;
            }else if(oddPalinLen > evenPalinLen && oddPalinLen > maxLen) {
                maxLen = oddPalinLen; start = oddLow;
            }
        }
        return s.substring(start , start + maxLen);
        
    }
    //Method to find the start index of the palindrome extending from given mid index
    private int palindromeExtendFromMid(String s, int low, int high){        
        int strLen = s.length();
        while(low >= 0 && high < strLen && s.charAt(low) == s.charAt(high)){ low--; high++;}
        return low + 1;
    }

}
