class Solution {
    public int minMoves2(int[] nums) {
        int operations = 0, mid = quickSelect(nums, 0, nums.length-1, nums.length/2);
        for (int num: nums) operations += Math.abs(mid - num);
        return operations;
    }
    
    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) return nums[left];

        int pIndex = new Random().nextInt(right - left + 1) + left;
        pIndex = partition(nums, left, right, pIndex);

        if (pIndex == k) return nums[k];
        else if (pIndex < k) return quickSelect(nums, pIndex+1, right, k);
        return quickSelect(nums, left, pIndex-1, k);
    }

    private int partition(int[] nums, int left, int right, int pIndex) {
        int pivot = nums[pIndex];
        swap(nums, pIndex, right);
        pIndex = left;

        for (int i=left; i<=right; i++) 
            if (nums[i] <= pivot) swap(nums, i, pIndex++);

        return pIndex - 1;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
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