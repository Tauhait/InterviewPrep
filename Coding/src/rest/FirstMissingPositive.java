package rest;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {        
        int size = nums.length;
        if(size == 0) return 1;
        int i = 0;
        while(i < size){
            int pos = nums[i] - 1;
            if(nums[i] >= 1 && nums[i] <= size && nums[i] != nums[nums[i] - 1]) swap(nums, pos, i);
            else i++;
        }
        i = 0;
        while(i < size && nums[i] == (i + 1)) i++;
        return i + 1;
    }
    public void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

}
