class Solution {
    public int fib(int n) {
        if(n == 0) return 0;
        int fib0 = 0, fib1 = 1;
        for(int i = 2; i <= n; i++) {
            int temp = fib0 + fib1;
            fib0 = fib1;
            fib1 = temp;
        }
        return fib1;
    }
}