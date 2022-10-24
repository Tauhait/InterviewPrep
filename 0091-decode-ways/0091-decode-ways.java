class Solution {
    Map<Integer,Integer> memo;
    String s;
    
    private boolean isValid(String s){
        if(s.length() > 1 && s.charAt(0) == '0')
            return false;
        int val = Integer.parseInt(s);
        if(val < 1 || val > 26)
            return false;
        return true;        
    }
    private int enumerate(int i){
        if(i == s.length())
            return 1;

        if(memo.containsKey(i))
            return memo.get(i);
        
        String one = null, two = null;
        one = s.substring(i,i+1);
        if(i < s.length()-1)
            two = s.substring(i,i+2);
        
        int ways = 0;
        if(two != null && isValid(two))
            ways += enumerate(i+2);
        if(isValid(one))
            ways += enumerate(i+1);
        
        memo.put(i, ways);
        return ways;
    }
    public int numDecodings(String s) {
        memo = new HashMap<>();
        this.s = s;
        return enumerate(0);
    }
}