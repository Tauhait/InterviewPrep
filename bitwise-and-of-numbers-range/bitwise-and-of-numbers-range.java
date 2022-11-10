class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        //right tries to match the maximum number of bits in left 
        //loop exits when left>=right
        while (left < right) {
          // turn off rightmost 1-bit
           right = right & (right - 1);
            //check outputs to understnad algorithm
          // System.out.println(right);
        }
        // System.out.println(left+","+right);
        return left & right;
    }
}