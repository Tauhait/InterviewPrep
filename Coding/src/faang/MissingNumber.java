package faang;

public class MissingNumber {
	public int missingNumber(int[] nums) {
        int ans = 0, index = 0;
        int len = nums.length;
        for(int e : nums) ans ^= e;       
        while(index <= len) ans ^= index++;
        return ans;
    }
}
