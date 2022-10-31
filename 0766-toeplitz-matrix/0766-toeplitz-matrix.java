class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for(int r = rows-1, c = 0; r >= 0 && c < cols; ){
            int diag = -1;
            for(int x = r, y = c; x < rows && y < cols; x++, y++){
                if(diag == -1){ 
                    diag = matrix[x][y];
                    continue;
                }
                if(matrix[x][y] != diag)
                    return false;
            }
            if(r > 0)
                r--;
            else
                c++;
        }
        return true;
    }
}