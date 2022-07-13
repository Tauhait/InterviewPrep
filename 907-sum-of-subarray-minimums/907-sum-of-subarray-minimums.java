class Solution {
    private final long MOD = 1_000_000_007;
    
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> monoStk = new Stack<Integer>();
        int[] leftDist = new int[arr.length];
        int[] rightDist = new int[arr.length];
        long sum = 0;
        
        for(int i = 0; i < arr.length; i++){
            while(!monoStk.isEmpty() && arr[i] <= arr[monoStk.peek()]) monoStk.pop();
            leftDist[i] = monoStk.isEmpty() ? i+1 : i-monoStk.peek();
            monoStk.push(i);
        }
        monoStk.clear();
        
        for(int i = arr.length-1; i >= 0; i--){
            while(!monoStk.isEmpty() && arr[i] < arr[monoStk.peek()]) monoStk.pop();            
            rightDist[i] = monoStk.isEmpty() ? arr.length-i : monoStk.peek()-i;
            monoStk.push(i);
        }
        
        for(int i = 0; i < arr.length; i++) sum = (sum + (long)arr[i]*leftDist[i]*rightDist[i]) % MOD;
        
        return (int)sum;
    }
}