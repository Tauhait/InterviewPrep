class Solution {
    public int majorityElement(int[] nums) {
        int majorityElement = 0;
        int n = nums.length;
        for(int i = 0; i < 32; i++){
            int setBit = 1 << i;
            int count = 0;
            for(int num : nums){
                int isSet = num & setBit;
                if(isSet != 0) count++;
            }
            if(count > n/2) majorityElement |= setBit;
        }
        return majorityElement;
    }
}