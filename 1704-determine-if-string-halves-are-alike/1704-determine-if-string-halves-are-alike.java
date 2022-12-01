class Solution {
    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c =='i' || c == 'o' || c =='u' ||
               c == 'A' || c == 'E' || c =='I' || c == 'O' || c =='U';
    }
    public boolean halvesAreAlike(String s) {
        int vowels = 0;
        int low = 0, high = s.length()-1;
        while(low < high){
            char cLow = s.charAt(low);
            char cHigh = s.charAt(high);
            if(isVowel(cLow))
                ++vowels;
            if(isVowel(cHigh))
                --vowels;
            low++;
            high--;
        }
        return vowels == 0;
    }
}