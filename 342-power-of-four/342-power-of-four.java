class Solution {
    public boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0xaaaaaaaa) == 0);
    }
    //How to check if the number is a power of two : x > 0 and x & (x - 1) == 0
}