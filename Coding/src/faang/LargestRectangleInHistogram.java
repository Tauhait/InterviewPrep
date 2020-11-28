package faang;

import java.util.Stack;

public class LargestRectangleInHistogram {
	public int largestRectangleArea(int[] heights) {
        Stack<Integer> myStack = new Stack<Integer>();
        int maxArea = 0, i = 0;
        while(i <= heights.length){
            int h = i == heights.length ? 0 : heights[i];
            if(myStack.isEmpty() || h >= heights[myStack.peek()]){
                myStack.push(i);
                i++;
            }
            else {
                int currHeight = heights[myStack.pop()];
                int rightBoundary = i - 1;
                int leftBoundary = myStack.isEmpty() ? 0 : myStack.peek() + 1;
                int width = rightBoundary - leftBoundary + 1;
                maxArea = Math.max(maxArea, (currHeight * width));
            }
        }
        return maxArea;
    }
}
