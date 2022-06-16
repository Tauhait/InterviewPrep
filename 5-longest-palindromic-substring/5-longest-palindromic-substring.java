class Solution {
    private Boolean memo[][];
    
    public String longestPalindrome(String s) {
        int max = 0, start = 0, end = 0;
        memo = new Boolean[s.length()][s.length()];
        
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                if(j-i+1 > max && isPalindrome(s, i, j)){
                    max = j-i+1;
                    start = i;
                    end = j;
                }
            }
        }        
        return s.substring(start, end+1);
    }
    
    private boolean isPalindrome(String s, int i, int j) {
        if(memo[i][j] != null) return memo[i][j];
        
        if(i == j) return memo[i][j] = true;
        
        if(j-i+1 == 2){
            if(s.charAt(i) == s.charAt(j)) memo[i][j] = true;
            else memo[i][j] = false;            
            return memo[i][j];
        }
        
        return memo[i][j] = s.charAt(i) == s.charAt(j) && isPalindrome(s, i+1, j-1);       
    }
}
