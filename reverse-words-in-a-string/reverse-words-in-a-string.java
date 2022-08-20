class Solution {
    public String reverseWords(String s) {
        StringBuilder sentence = new StringBuilder();
        StringBuilder word = new StringBuilder();
        int left = 0, right = s.length()-1;
        // remove leading spaces
        while (left <= right && s.charAt(left) == ' ') ++left;

        // remove trailing spaces
        while (left <= right && s.charAt(right) == ' ') --right;
        
        // System.out.println(s.substring(left, right+1));
        for(int i = right; i >= left; i--){
            char c = s.charAt(i);
            if(c == ' ' || i == left){
                if(i != left && word.length() == 0) continue;
                if(i == left && c != ' ') word.insert(0, c);
                sentence.append(word);
                if(i != left) sentence.append(" ");
                word = new StringBuilder();
            }else {
                word.insert(0,c);
            }
        }
        return sentence.toString();
    }
}