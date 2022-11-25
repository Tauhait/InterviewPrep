class Solution {
    public int sumSubarrayMins(int[] A) {
        Stack<Integer> s = new Stack<>();
        int[] dp = new int[A.length];
        int total = 0;
        for (int i = 0; i < A.length; i++) {
            while (!s.isEmpty() && A[s.peek()] > A[i]) 
                s.pop();
            if (s.isEmpty()) 
                dp[i] = (i + 1) * A[i];
            else 
                dp[i] = dp[s.peek()] + (i - s.peek()) * A[i];
            total = (total + dp[i] ) % 1000000007;
            s.push(i);
        }
        return total;
    }
}