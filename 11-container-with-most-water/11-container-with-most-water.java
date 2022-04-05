class Solution {
    public int maxArea(int[] height) {
        if(height == null) return 0;
        int maxArea =  0, low = 0, high = height.length - 1;
        while(low < high) {
            maxArea = Math.max(maxArea, (high - low) * Math.min(height[low], height[high]));
            if(height[low] < height[high]) low++;
            else high--;
        }
        return maxArea;
    }
}