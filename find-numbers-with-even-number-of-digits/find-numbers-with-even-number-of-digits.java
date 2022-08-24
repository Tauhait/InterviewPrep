class Solution {
    private int countDigits(int n){
        int count = 0;
        while(n > 0){
            n /= 10;
            ++count;
        }
        return count;
    }
    public int findNumbers(int[] nums) {
        int countEven = 0;
        for(int num : nums){
            if(countDigits(num) % 2 == 0) ++countEven;
        }
        return countEven;
    }
}