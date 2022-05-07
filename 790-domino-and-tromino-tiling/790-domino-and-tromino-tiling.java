class Solution {
     // we are not actually interested in finding every possible way to completely fill the board - 
    // we are only interested in the number of ways the board can be completely filled. 
    // Whenever you are not sure how to approach a problem, 
    // it is a good idea to draw out the first couple of scenarios.
    
    private int MOD = 1_000_000_007;
    Map<Integer, Long> f_cache = new HashMap();
    Map<Integer, Long> p_cache = new HashMap();
    
    private long p(int i){
        if(p_cache.containsKey(i)){
            return p_cache.get(i);
        }
        long val;
        if(i == 2){
            val = 1L;
        }else {
            val = (p(i - 1) + f(i - 2)) % MOD;
        }
        p_cache.put(i, val);
        return val;
    }
    private long f(int i){
        if(f_cache.containsKey(i)){
            return f_cache.get(i);
        }
        long val;
        if(i == 1){
            val = 1L;
        }else if(i == 2){
            val = 2L;
        }else {
            val = (f(i - 1) + f(i - 2) + 2*p(i - 1)) % MOD;
        }
        f_cache.put(i, val);
        return val;
    }
    public int numTilings(int n) {
        return (int)f(n);
    }
}