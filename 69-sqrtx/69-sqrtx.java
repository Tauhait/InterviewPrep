class Solution {
    public int mySqrt(int x) {
        if(x <= 1) return x;
        int low = 0, high = x >> 1;
        while(low <= high){
            int mid = (low + high) >>> 1;
            long sq = (long) mid * mid;
            if(sq == x) return mid;
            else if(sq < x) low = mid + 1;
            else high = mid - 1;
        }
        return high;
    }
}