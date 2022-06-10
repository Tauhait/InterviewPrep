class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null){
            return 0;
        }
        int slen = s.length();
        if(slen == 0){
            return 0;
        }
        
        int longSubstrMax = 0;
        Set<Character> charSet = new HashSet<Character>();
        int windowStart, windowEnd;
        
        for(windowStart = 0, windowEnd = 0; windowEnd < slen; windowEnd++){
            char c = s.charAt(windowEnd);
            if(charSet.contains(c)){
                longSubstrMax = Math.max(longSubstrMax, windowEnd - windowStart);
                
                while(charSet.contains(c)){
                    char toRemove = s.charAt(windowStart++);
                    charSet.remove(toRemove);
                }
            }
            charSet.add(c);
            
        }
        longSubstrMax = Math.max(longSubstrMax, windowEnd - windowStart);
        return longSubstrMax;
    }
}