package other_companies;

public class findDuplicate {
	public int findDuplicateNumber(int[] nums) {
        // Approach 1
        // Time  = O (N.lg(N))
        // Space = O (1) 
        /*
        Arrays.sort(nums);
        int dup = nums[0];
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                dup = nums[i];
                break;
            }
        }
        return dup;
        */
        
        // Approach 2
        // Time  = O (N)
        // Space = O (N)
        /*
        HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
        int dup = nums[0];
        for(int ele : nums) {
            int freq = freqMap.getOrDefault(ele, 0);
            if(freq == 1) {
                dup = ele;
                break;
            }
            freqMap.put(ele, freq + 1);
        }
        return dup;
        */
        
        // Approach 3
        // Time  = O (N)
        // Space = O (1)
        int fast = nums[0];
        int slow = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(fast != slow);
        fast = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
