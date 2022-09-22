class Solution {
    public String reverseWords(String s) {
        StringBuilder wordRevSent = new StringBuilder();
        StringBuilder wordRev = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' ' || i == s.length()-1){
                if(i != s.length()-1 && wordRev.length() == 0) continue;
                if(i == s.length()-1) wordRev.insert(0, c);
                wordRevSent.append(wordRev);
                if(i != s.length()-1) wordRevSent.append(" ");
                wordRev = new StringBuilder();
            }else {
                wordRev.insert(0, c);
            }            
        }
        return wordRevSent.toString();
    }
}