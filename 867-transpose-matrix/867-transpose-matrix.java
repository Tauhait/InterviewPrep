class Solution {
    public int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] result = new int[cols][rows];
        
        for(int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++){
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }
}
/**
1, 2, 3
4, 5, 6

1 4
2 5
*/