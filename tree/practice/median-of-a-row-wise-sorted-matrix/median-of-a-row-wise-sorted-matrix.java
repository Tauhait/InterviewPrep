class Solution {
    private int binarySearchUpperBound(int median, int[] arr){
        int lo = 0, hi = arr.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] <= median){
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
    private int countOfElementsLessThanEqualToMedian(int median, int[][] grid){
        int count = 0;
        for(int r = 0; r < grid.length; r++){
            count += binarySearchUpperBound(median, grid[r]);
        }
        return count;
    }
    public int matrixMedian(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int total = rows * cols;
        int medianPos = total / 2;
        int lo = 1, hi = 1_000_000;
        while(lo <= hi){
            int median = lo + (hi - lo) / 2;
            int elementsLessThanEqualToMedian = countOfElementsLessThanEqualToMedian(median, grid);
            if(elementsLessThanEqualToMedian <= medianPos){
                lo = median + 1;
            } else {
                hi  = median - 1;
            }
        }
        return lo;
    }
}