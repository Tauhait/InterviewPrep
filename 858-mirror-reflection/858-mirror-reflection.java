/*
1. understand problem, clarify, edge cases
2. find solution
3. write code (correctness, readability, speed)
4. testing

https://www.youtube.com/watch?v=TEh0Fcu5Nok

**/
class Solution {
    public int mirrorReflection(int p, int q) {
        int m = 1, n = 1;
        int gcd = gcd(p,q);
        p /= gcd;
        q /= gcd;
        while (p*m != q*n){
            n++;
            m = (q*n)/p;
        }
        //p*m == q*n

        if(n % 2 == 0) return 2;
        else if(m % 2 == 1) return 1;
        else return 0;
    }
    private int gcd(int p, int q){
        if(q == 0) return p;
        return gcd(q, p % q);
    }
}