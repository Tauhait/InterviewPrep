class Solution {
    public void sortColors(int[] nums) {   
		// Approach 1 : Comparison sort
		// Time  = O(NlgN)
		// Space = O(1)
		
		// Approach 2 : Counting sort using freq
		// Time  = O(2N)
		// Space = O(1)
		
		// Approach 3 : Dutch National Flag Algo (using three variables)
		// Time  = O(N)
		// Space = O(1)		
		int lo = 0, hi = nums.length - 1, mid = 0;
		while(mid <= hi) {
			switch(nums[mid]){
				case 0: swap(nums, lo++, mid++); break;					
				case 1 : mid++; break;
				case 2 : swap(nums, mid, hi--); break;			
			}			
		}
		
		// Approach 4 : Using two variables
		// Time  = O(N)
		// Space = O(1)
        /*
		int rIndex = -1, bIndex = nums.length;
         for(int i=0; i < bIndex; ){
            if(nums[i] == 0){            	
                ++rIndex;
                int temp = nums[rIndex];
                nums[rIndex] = nums[i];
                nums[i] = temp;            	
                
            }else if(nums[i] == 2){            	
                --bIndex;
                int temp = nums[bIndex];
                nums[bIndex] = nums[i];
                nums[i] = temp;
            	
            }else {   
            	i++;           
            	continue;
            }            
            switch(nums[i]) {
	            case 0:
	            	if(i <= rIndex) i++; 
                    break;
	            case 1:
	            	if(i > rIndex && i < bIndex) i++;
	            	break;
	            case 2:
	            	if(i > bIndex) i++;
	            	break;            
            }
        }
        */        
    }
	public void swap(int[] nums, int first, int second) {
		int temp = nums[first];
		nums[first] = nums[second];
		nums[second] = temp;
	}
}