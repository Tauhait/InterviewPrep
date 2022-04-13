class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int elems = 1;
        int n2 = n * n;
        int rows = n;
        int cols = n;
        int iter = 0;
        while(elems < n2){
            //top
            for(int i = iter; elems <= n2 && i < cols - iter - 1; i++){
                matrix[iter][i] = elems;
                ++elems;
            }
            //right
            for(int i = iter; elems <= n2 && i < rows - iter - 1; i++){
                matrix[i][cols - 1 - iter] = elems;
                ++elems;
            }
            //bottom
            for(int i = cols - 1 - iter; elems <= n2 && i > iter; i--){
                matrix[rows - 1 - iter][i] = elems;
                ++elems;
            }
            //left
            for(int i = rows - 1 - iter; elems <= n2 && i > iter; i--){
                matrix[i][iter] = elems;
                ++elems;
            }
            ++iter;
        }
        /* Special case when n is a perfect square. */
        if(rows > 0 && rows == cols && rows % 2 == 1) matrix[rows/2][rows/2] = elems;
        return matrix;
    }
}