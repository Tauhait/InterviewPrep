class Solution {
    public String reverseVowels(String s) {
        Deque<Integer> vowelPos = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || 
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
                vowelPos.add(i);
        }
        StringBuilder ans = new StringBuilder(s);
        while(vowelPos.size() > 1){
            int front = vowelPos.getFirst();
            int last  = vowelPos.getLast();
            char f = ans.charAt(front);
            char l = ans.charAt(last);
            ans.setCharAt(front, l);
            ans.setCharAt(last, f);
            vowelPos.removeFirst();
            vowelPos.removeLast();
        }
        return ans.toString();
    }
}