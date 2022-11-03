class Solution {    
    public int longestPalindrome(String[] words) {
        Map<String,Integer> dict = new HashMap<>();
        Map<String,Integer> map = new HashMap<>();
        
        int len = 0;
        for(String word : words){
            char first = word.charAt(0);
            char last  = word.charAt(1);
            
            if(first == last){
                map.put(word, map.getOrDefault(word,0)+1);
            }else {
                dict.put(word, dict.getOrDefault(word,0)+1);
                String rev = (new StringBuilder(word)).reverse().toString();
                if(dict.containsKey(rev)){
                    len += 4;
                    dict.put(rev,dict.get(rev)-1);
                    dict.put(word,dict.get(word)-1);
                    if(dict.get(rev) == 0){ 
                        dict.remove(rev);
                    }
                    if(dict.get(word) == 0){
                        dict.remove(word);
                    }
                    
                    // System.out.println(word+","+rev);
                }
            }
        }
        boolean isMidTaken = false;
        if(map.size() > 0){   
            for(Map.Entry<String,Integer> entry : map.entrySet()){
                String k  = entry.getKey();
                Integer v = entry.getValue();
                
                if((v&1) == 1){
                    if(isMidTaken)
                        v -= 1;
                    else 
                        isMidTaken = true;
                }
                // System.out.println(k);
                len += (v<<1);
            }
        }        
        return len;
    }
}