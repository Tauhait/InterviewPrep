class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        long power = (long)n;
        if(power < 0){
            power *= -1;
            x = 1.0/x;
        }
        //binary exponentiation algorithm
        double result = 1;
        while(power > 0){
            if(power % 2 == 1){
                result *= x;
                power -= 1;
            }
            x *= x;
            power /= 2;
        }
        return result;
    }
}