package faang;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(len != 0){
            int right = len - 2;
            //find first decreasing element
            while(right >= 0 && nums[right + 1] <= nums[right]) right--;
            //if firts decreasing element is not the first index
            if(right >= 0) {
                int largThanRight = len - 1;
                //find the element just greater than first decreasing element
                while(largThanRight >= 0 && nums[largThanRight] <= nums[right]) largThanRight--;
                //swap first decreasing element and the element just greater than it to set next permute 
                swap(nums, right, largThanRight);
            }
            //reverse all elements after the first decreasing element
            for(int start = right + 1, last = len - 1; start < last; start++, last--) swap(nums, start, last);
        }
    }
    private void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

}
