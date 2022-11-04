public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        int rev = 0;
        int times = 31;
        boolean isNeg = false;
        // if(n < 0){ 
        //     isNeg = true;
        //     times--;
        // }
        while(n != 0){
            rev |= ((n&1)<<times);
            n >>>= 1;
            times--;
        }
        // if(isNeg)
        //     rev *= -1;
        return rev;
    }
}