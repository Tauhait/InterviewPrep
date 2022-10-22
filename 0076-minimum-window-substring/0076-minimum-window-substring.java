class Solution {
    public String minWindow(String s, String t) {
        Integer[] tFreq = new Integer[128];
        for(char c : t.toCharArray())
            tFreq[c] = tFreq[c] == null ? 1 : tFreq[c]+1;
        
        int start, end, minSize = s.length()+1, minWinStart = 0, matched = 0;
        for(start = 0, end = 0; end < s.length(); end++){
            char c = s.charAt(end);
            if(tFreq[c] != null){
                tFreq[c]--;
                if(tFreq[c] >= 0)
                    matched++;
            }
            while(matched == t.length()){
                if(end-start+1 < minSize){ 
                    minSize = end-start+1;
                    minWinStart = start;
                }
                char left = s.charAt(start++);
                if(tFreq[left] != null){
                    if(tFreq[left] == 0)
                        matched--;
                    tFreq[left]++;
                }                
            }
        }
        return minSize > s.length() ? "" : s.substring(minWinStart, minWinStart+minSize);
    }
}