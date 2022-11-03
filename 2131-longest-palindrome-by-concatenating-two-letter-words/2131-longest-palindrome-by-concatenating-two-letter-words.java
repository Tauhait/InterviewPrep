class Solution {
    public int longestPalindrome(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        
        int result = 0;
        HashMap<String, Integer> map = new HashMap<>();
        int palWordCount = 0;
        
        for (String word: words) {
            String reverseWord = "" + word.charAt(1) + word.charAt(0);
            
            if (map.containsKey(reverseWord)) {
                result += 4;
                
                int value = map.get(reverseWord);
                if (value == 1) {
                    map.remove(reverseWord);
                } else {
                    map.put(reverseWord, value - 1);
                }
                
                if (word.equals(reverseWord)) {
                    palWordCount--;
                }
            } else {
                if (map.containsKey(word)) {
                    int value = map.get(word);
                    map.put(word, value + 1);
                } else {
                    map.put(word, 1);
                }
                
                if (word.equals(reverseWord)) {
                    palWordCount++;
                }
            }
        }
        
        return palWordCount > 0 ? result + 2 : result;
    }
}