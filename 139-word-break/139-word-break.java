class Solution {
    private enum state {
        INVALID, TRUE, FALSE
    };
    private List<String> wordDict;
    private String s;
    private state[] memo;
    
    private state dp(int i){
        if(i < 0){
            return state.TRUE;
        }
        if(memo[i] == state.INVALID){
            for(String word : wordDict){
                int wLen = word.length();
                if(i >= wLen - 1 && dp(i - wLen) == state.TRUE){
                    if(s.substring(i - wLen + 1, i + 1).equals(word)){
                        memo[i] = state.TRUE;
                        break;
                    }
                }
            }
        }
        if(memo[i] == state.INVALID){
            memo[i] = state.FALSE;
        }
        return memo[i];
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        this.s = s;
        int len = s.length();
        
        memo = new state[len];
        Arrays.fill(memo, state.INVALID);
        // memo[0] = state.TRUE;
        
        return dp(len - 1) == state.TRUE;
    }
}