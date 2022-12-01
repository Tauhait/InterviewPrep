class Solution {
    private boolean isVowel(char c){
        return c == 'a' || c == 'e' || c =='i' || c == 'o' || c =='u';
    }
    public boolean halvesAreAlike(String s) {
        int vowels = 0;
        int low = 0, high = s.length()-1;
        String str = s.toLowerCase();
        while(low < high){
            char cLow = str.charAt(low);
            char cHigh = str.charAt(high);
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