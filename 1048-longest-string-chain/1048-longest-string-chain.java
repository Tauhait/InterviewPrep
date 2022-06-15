class Solution {
    //valid ques to interviewer - is the letters in the word unique?
    private Map<String, Integer> memo;
    
    private int recurse(String[] words, int i){
        if(i < 0) return 1;
        if(memo.containsKey(words[i])) return memo.get(words[i]);
        
        String current = words[i];
        int currLen = current.length();
        List<Integer> candidates = new ArrayList<Integer>();
        int j = i-1;
        
        for(; j >= 0; j--){
            if(currLen - words[j].length() == 0) continue;
            if(currLen - words[j].length() > 1) break;
            if(isPredecessor(words[j], current)){
                candidates.add(j);
            }
        }
        int count = 1;
        for(int pred : candidates){
            count = Math.max(count, 1 + recurse(words, pred));
        }
        memo.put(current, count);
        return count;        
    }
    private boolean isPredecessor(String s1, String s2){
        //both string differ by 1 in length, s1 < s2
        char[] s1Char = s1.toCharArray();
        char[] s2Char = s2.toCharArray();

        int s1Index = 0, s2Index = 0;
        boolean oneChange = false;
        
        while(s1Index < s1.length() && s2Index < s2.length()){
            if(s1Char[s1Index] == s2Char[s2Index]){
                s1Index++;
                s2Index++;
            }else if(!oneChange){
                s2Index++;
                oneChange = true;
            }else return false;
        }
        return true;
        
    }
    public int longestStrChain(String[] words) {
        if(words.length == 1) return 1;
        memo = new HashMap<String, Integer>();
        Arrays.sort(words, (a, b)->(a.length() - b.length()));
        int ans = 1;
        for(int i = words.length-1; i >= 0; i--){
            ans = Math.max(ans, recurse(words, i));
            memo.put(words[i], ans);
        }
        return ans;
    }
    
}
/**
1. Sort by length O(n log2 n)
2. Recursively we need to call n - 1 length words and check if they can be candidates of the solution O(n)
2.a Evaluate the n - 1 length word with the current word letter by letter and if there is only one letter mismatch then it is possible candidate O(m)
3. Evaluate all candidates recursively and get the max chain value 

O(n lg n + nm) = O(nm) = o(n^2)
*/