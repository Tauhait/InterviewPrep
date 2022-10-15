class Solution {
    Map<String,Integer> memo;
    final Set<Integer> add = Set.of(1,9,99);
    String s;
    
    private int dp(int i, int k, char lastChar, int lastCharCount){
        if(i == s.length()){
            return 0;
        }
        String key = i + "," + k + "," + lastChar + "," + lastCharCount;
        if(memo.containsKey(key))
            return memo.get(key);
        
        
        int keepChar = Integer.MAX_VALUE, deleteChar = Integer.MAX_VALUE;
        if(k-1 >= 0)
            deleteChar = dp(i+1, k-1, lastChar, lastCharCount);
        
        if(s.charAt(i) == lastChar){
            keepChar = dp(i+1, k, lastChar, lastCharCount+1) + 
                                (add.contains(lastCharCount) ? 1 : 0);
        }else {
            keepChar = dp(i+1, k, s.charAt(i), 1) + 1;
        }
        int min = Math.min(keepChar, deleteChar);
        memo.put(key, min);
        return min;
    }
    public int getLengthOfOptimalCompression(String s, int k) {
        memo = new HashMap<String,Integer>();
        this.s = s;
        return dp(0, k, '\0', 0);
    }
}