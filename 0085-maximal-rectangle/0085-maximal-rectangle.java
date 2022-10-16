class Solution {
    private int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) 
            return 0;

        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        int length = heights.length;
        int maxArea = 0;
        while (index <= length) {
            int height = (index == length ? 0 : heights[index]);
            if (deque.isEmpty() || height >= heights[deque.peek()]) {
                deque.push(index);
                index++;
            } else {
                int currHeight = heights[deque.pop()];

                int end = index - 1;
                int begin = deque.isEmpty() ? 0 : deque.peek() + 1;
                maxArea = Math.max(maxArea, currHeight * (end - begin + 1));
            }
        }

        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;

        int maxRectangle = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // If current grid is '1' then we increase the height of "Histogram" for current col.
                if (matrix[row][col] == '1') {
                    heights[col]++;
                } else {
                    // Reset the height of "Histogram" for current col.
                    heights[col] = 0;
                }
            }

            // Calculate the largest rectangle area based on current "Histogram"
            maxRectangle = Math.max(maxRectangle, largestRectangleArea(heights));
        }
        return maxRectangle;
    }
}