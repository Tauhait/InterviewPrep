class Solution {
    private final int MOD = 1_000_000_007;
    
    public int totalStrength(int[] strength) {
        int n = strength.length;
        int prefixSum = 0;
        int sum = 0;
        Stack<Integer> monoStk = new Stack<Integer>();
        int[] prefixMul = new int[n+2];
        
        
        for(int r = 0; r <= n; r++){
            int current = r < n ? strength[r] : 0;
            prefixSum = (prefixSum + current) % MOD;
            prefixMul[r+1] = (prefixSum + prefixMul[r]) % MOD;
            while(!monoStk.isEmpty() && current < strength[monoStk.peek()]){
                int elementIndex = monoStk.pop();
                int prevSmallerIndex = monoStk.isEmpty() ? -1 : monoStk.peek();
                int nextSmallerIndex = r;
                
                long leftPrefixMul = prevSmallerIndex < 0 ? prefixMul[elementIndex] : 
                                                            prefixMul[elementIndex]-prefixMul[prevSmallerIndex];
                
                long rightPrefixMul = prefixMul[nextSmallerIndex]-prefixMul[elementIndex];
                
                int leftSubArrLen =  elementIndex-prevSmallerIndex;
                int rightSubArrLen = nextSmallerIndex-elementIndex;
                
                sum = (int)(sum + 
                            (rightPrefixMul*leftSubArrLen - leftPrefixMul*rightSubArrLen) % MOD * 
                            strength[elementIndex] % MOD) % MOD;
            }
            monoStk.push(r);
        }
        return (sum + MOD) % MOD;
    }
}