class Solution {
    public int hammingDistance(int x, int y) {
        int count = 0;
        while(x > 0 && y > 0){
            count += ((x&1)^(y&1)) == 1 ? 1 : 0;
            x >>>= 1;
            y >>>= 1;
        }
        while(x > 0){
            count += (x&1) == 1 ? 1 : 0;
            x >>>= 1;
        }
        while(y > 0){
            count += (y&1) == 1 ? 1 : 0;
            y >>>= 1;
        }
        return count;
    }
}