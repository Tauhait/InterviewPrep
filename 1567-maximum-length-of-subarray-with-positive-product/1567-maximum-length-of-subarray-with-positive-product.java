class Solution {
    /*
    I think the intuition is this:
    At every point, we need to keep a track of both positive and negative product lengths.

    As long as you are seeing just positive numbers, 
    the length represents the max length of the positive product.
    The moment you see a negative number (first or odd numbers of negative), 
    the length from point 1 starts to represent the max length of the -ve product.
    
    So basically we are switching the lengths depending on how many negative numbers 
    we have seen so far. 
    If the number of negatives so far is an odd amount, 
    then the length represents a negative product length. 
    Otherwise, it represents the length of the positive product.
    
    Split the whole array into subarrays by zeroes 
    since a subarray with positive product cannot contain any zero.
    
    If the subarray has even number of negative numbers, the whole subarray has positive product.
    
    At every iteration, 
    tracking maximum length of positive multiplicative result and 
    negative multiplicative result can help.
    */
    public int getMaxLen(int[] nums) {
        int positive = 0;
        int negative = 0;
        int max = 0;
        for (int n: nums) {
            if (n == 0) {
                positive = 0; 
                negative = 0; 
                continue;
            }
            
            positive++;
            negative = negative > 0 ? negative + 1 : 0;
            if (n < 0) { // swap if negative number is encountered
                int tmp = positive;
                positive = negative;
                negative = tmp;
            }
            max = Math.max(max, positive);
        }
        return max;
    }
}