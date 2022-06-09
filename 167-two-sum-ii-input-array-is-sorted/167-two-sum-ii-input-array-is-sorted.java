class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        for(int i = 0, j = len - 1; i < j; ){
            if(numbers[i] + numbers[j] > target)
                j--;
            else if(numbers[i] + numbers[j] < target)
                i++;
            else
                return new int[]{i + 1, j + 1};
        }
        return new int[2];
    }
}