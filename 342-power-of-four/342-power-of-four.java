class Solution {
    public boolean isPowerOfFour(int n) {
        int ones = 0, zeros = 0;
        while(n > 0){
            int and1 = n & 1;
            if(and1 == 1) ones++;
            else zeros++;
            n >>= 1;
        }
        return (ones == 1 && zeros % 2 == 0);
    }
}