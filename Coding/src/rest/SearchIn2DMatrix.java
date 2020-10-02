package rest;
/*
 * Two variants of the same problem:
Variant 1
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

Soln:
 - Naive, linear search, time - O(N*M), space - O(1)
 - Search in every sorted row, time - O(N lg M), space - O(1)
 - Binary search on the whole matrix, time - O( lg N), space - O(1)

Variant 2
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Soln:
 - Naive, linear search, time - O(N*M), space - O(1)
 - Search in every sorted row, time - O(N lg M), space - O(1)
 - use binary search starting fom top right corner going left(target is less than current value) and down target is greater than current value), time - O(lg N), space - O(1) 
 */

public class SearchIn2DMatrix {
	/*
Variant 1
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

Soln:
 - Naive, linear search, time - O(N*M), space - O(1)
 - Search in every sorted row, time - O(N lg M), space - O(1)
 - Binary search on the whole matrix, time - O( lg N), space - O(1)

	 */
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        if(matrix[0].length == 0) return false;
        int rows = matrix.length, cols = matrix[0].length;
        return  helper(matrix, rows, cols , 0, rows*cols - 1, target);
    }
    private boolean helper(int[][] mat, int rows, int cols, int low, int high, int tar){
        if(low > high) return false;
        int mid = low + (high - low)/2;
        int r = mid / cols;
        int c = mid % cols;
        if(tar == mat[r][c]) return true;
        else if(tar > mat[r][c]) return helper(mat, rows, cols, mid + 1, high, tar);
        else return helper(mat, rows, cols, low, mid - 1, tar);
    }
    /*
 Variant 2
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Soln:
 - Naive, linear search, time - O(N*M), space - O(1)
 - Search in every sorted row, time - O(N lg M), space - O(1)
 - use binary search starting fom top right corner going left(target is less than current value) and down target is greater than current value), time - O(lg N), space - O(1) 

     */
    public boolean searchMatrixII(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        return helperII(matrix, matrix.length, matrix[0].length, 0, matrix[0].length - 1, target);
    }
    private boolean helperII(int[][] mat, int rows, int cols, int r, int c, int tar){
        if(r >= rows || c < 0) return false;
        if(tar == mat[r][c]) return true;
        if(tar < mat[r][c]) return helper(mat, rows, cols, r, c - 1, tar);
        else return helper(mat, rows, cols, r + 1, c, tar);        
    }

}
