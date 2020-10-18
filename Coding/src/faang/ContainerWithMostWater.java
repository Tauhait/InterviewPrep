package faang;

import java.util.ArrayDeque;

public class ContainerWithMostWater {
	//TC - O(n2)
	//SC - O(n)
	public int maxArea_DPWithOptSpace(int[] height) {
        if(height == null) return 0;
        int len = height.length;
        ArrayDeque<Integer> que = new ArrayDeque<Integer>();
        for(int j = 1; j < len; j++) {
            int area = Math.min(height[j - 1], height[j]);
            que.offer(area);
        }
        for(int diff = 2; diff < len; diff++){
            int i = 0;
            int j = i + diff;
            while(j < len){
                int leftArea = que.poll();
                int downArea = que.peek();
                int currArea = diff * Math.min(height[i], height[j]);
                que.offer(Math.max(leftArea, Math.max(downArea, currArea)));
                i++;
                j++;
            }
            que.poll();//remove the last down area
        }
        return que.poll();        
    }
	public int maxArea_with_SC_O_n2(int[] height) {
        if(height == null) return 0;
        int len = height.length;
        int[][] dp = new int[len][len];
        
        for(int i = 0, j = 1; i < len - 1 && j < len; i++, j++) dp[i][j] = Math.min(height[j - 1], height[j]);
        for(int diff = 2; diff < len; diff++){
            int i = 0;
            int j = i + diff;
            while(j < len){
                dp[i][j] = Math.max(dp[i][j-1], Math.max(dp[i + 1][j], diff * Math.min(height[i], height[j])));
                i++;
                j++;
            }    
        }
        return dp[0][len - 1];        
    }
	
	public int maxArea_BruteForce(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
    }
	//==============================================================================================================
	//TC - O(n)
	public int maxArea_OPT(int[] height) {
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
