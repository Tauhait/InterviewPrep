package faang;

public class TrappingRainWater1 {
	 public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int rainWaterTrapped = 0;
        while(left < right){
            if(height[left] < height[right]){
                if(height[left] > leftMax) leftMax = height[left];
                else rainWaterTrapped += leftMax - height[left];
                left++;
            }
            else {
                if(height[right] > rightMax) rightMax = height[right];
                else rainWaterTrapped += rightMax - height[right];
                right--;                
            }
        }
        return rainWaterTrapped;
    }
}
