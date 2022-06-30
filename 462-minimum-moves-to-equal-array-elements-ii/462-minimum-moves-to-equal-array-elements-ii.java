class Solution {
    public int minMoves2(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        int middle = nums[nums.length/2];
        for(int n : nums) ans += Math.abs(n - middle);
        return ans;
    }
}
//try to figure out which number is closest ot every other number and then try to convert all other numbers to that number
//the numbern need not be present in the array
//array values are really large 10^9
/**
[1,10,2,9]
16
8+1+7 = 16 : 9
9+8+1 = 18 : 10
1+8+7 = 16 : 2
9+1+8 = 18 : 1

sort the array and then take the middle element
[1,2,9,10]
TC - O(n log n)
Sc - O(1) -> O(n)

without sorting we need to find the middle
find lowest  - O(n)
find highest  - O(n)
calc middle and find diff between every element with the middle element from the array

[0,0,1,6,8]
1,1,0,5,7 = 14
low=0, high=8
mid=4
3,4,4,4,2=17
*/