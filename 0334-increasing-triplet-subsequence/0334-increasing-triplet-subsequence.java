class Solution {
    public boolean increasingTriplet(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int smaller = Integer.MAX_VALUE;
        for(int num : nums){
            if(num <= smallest)
                smallest = num;
            else if(num <= smaller)
                smaller = num;
            else 
                return true;
        }
        return false;
    }
}