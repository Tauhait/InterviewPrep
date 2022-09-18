class Solution {
    public int trap(int[] height) {
        int maxLeft = 0;
        int maxRight = 0;
        int low = 0, high = height.length-1;
        int rain = 0;
        while(low <= high){
            if(height[low] <= height[high]){
                if(height[low]>= maxLeft) maxLeft = height[low];
                else rain += maxLeft-height[low];
                low++;
            }else {
                if(height[high]>=maxRight) maxRight = height[high];
                else rain += maxRight-height[high];
                high--;
            }
        }
        return rain;
    }
}